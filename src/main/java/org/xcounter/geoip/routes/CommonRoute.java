package org.xcounter.geoip.routes;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;

public class CommonRoute extends UIRoute
{

    public CommonRoute()
    {
        super("/:route/");
    }

    @Override
    public Object handle(Request arg0, Response arg1)
    {
        try{

            String route = arg0.params("route");
            this.current_menu = "/" + route + "/";

            Template template = this.ftl_configuration.getTemplate("common/" + route + ".ftl");
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
