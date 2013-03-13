package org.xcounter.geoip.routes;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;

public class IndexRoute extends UIRoute
{

    public IndexRoute(){
        super("/");
    }

    @Override
    public Object handle(Request arg0, Response arg1)
    {
        try{
            Template template = this.ftl_configuration.getTemplate("index.ftl");
            StringWriter sw = new StringWriter();

            HashMap valuesMap = new HashMap();
//            valuesMap.put("content", content);

            template.process(valuesMap, sw);
            return renderLayout(sw.toString());

        }catch (TemplateException e) {
            halt(500);
        }catch (IOException e) {
            halt(500);
        }
        return null;
    }

    
    
}
