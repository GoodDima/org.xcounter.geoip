package org.xcounter.geoip.routes;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

import org.xcounter.geoip.CacheMongo;

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
        this.current_menu = "/example/list/";
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

        {
            HashMap<String, String> template = new HashMap<String, String>();
            template.put("template", "examples/python.ftl");
            template.put("title", "Python GeoIP Api for software development free");
            template.put("keywords", "Python GeoIP Api for software development free");
            template.put("description", "Python GeoIP Api for software development free");
            this.templates.put("python", template);
        }

        {
            HashMap<String, String> template = new HashMap<String, String>();
            template.put("template", "examples/ruby.ftl");
            template.put("title", "Ruby GeoIP Api for software development free");
            template.put("keywords", "Ruby GeoIP Api for software development free");
            template.put("description", "Ruby GeoIP Api for software development free");
            this.templates.put("ruby", template);
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

            HashMap valuesMap = new HashMap();
            valuesMap.put("lasten", CacheMongo.getLasten());

            template.process(valuesMap, sw);
            return renderLayout(sw.toString());


        }catch (TemplateException e) {
//            halt(500);
        }catch (IOException e) {
//            halt(500);
        }

        return null;

    }

}
