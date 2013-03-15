package org.xcounter.geoip.routes;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import spark.Request;
import spark.Response;
import spark.Spark;

public class LangApiRoute extends UIRoute
{
    private HashMap<String, HashMap<String, String>> templates = new HashMap<String, HashMap<String, String>>();

    public LangApiRoute()
    {
        super("/example/:tag/");

        {
            HashMap<String, String> template = new HashMap<String, String>();
            template.put("template", "examples/list.ftl");
            template.put("title", "GeoIP Api for software development free");
            template.put("keywords", "GeoIP Api for software development free");
            template.put("description", "GeoIP Api for software development free");
            this.templates.put("list", template);
        }
        {
            HashMap<String, String> template = new HashMap<String, String>();
            template.put("template", "examples/php.ftl");
            template.put("title", "PHP GeoIP Api for software development free");
            template.put("keywords", "PHP GeoIP Api for software development free");
            template.put("description", "PHP GeoIP Api for software development free");
            this.templates.put("php", template);
        }

    }

    @Override
    public Object handle(Request arg0, Response arg1)
    {

        try{

            String tag = arg0.params("tag");

            if (!this.templates.containsKey(tag)){
                arg1.redirect("/");
            }
            HashMap<String, String> tpl = this.templates.get(tag);
            this.title = tpl.get("title");
            this.keywords = tpl.get("keywords");
            this.description = tpl.get("description");
            Template template = this.ftl_configuration.getTemplate(tpl.get("template"));
            StringWriter sw = new StringWriter();

            template.process(null, sw);
            return renderLayout(sw.toString());


        }catch (TemplateException e) {
            halt(500);
        }catch (IOException e) {
            halt(500);
        }

        return null;

    }

}
