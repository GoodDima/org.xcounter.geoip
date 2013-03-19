package org.xcounter.geoip.routes;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

import org.xcounter.geoip.CacheMongo;
import org.xcounter.geoip.Useful;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import spark.Request;
import spark.Response;
import spark.Route;

public class ApiRoute extends UIRoute
{

    public ApiRoute(){
        super("/api/ip/:ip/");
    }

    @Override
    public Object handle(Request arg0, Response arg1)
    {
        try{
            String raw_ip = arg0.params("ip");
            long ip = 0;
            if (raw_ip.matches("\\d+")){
                ip = Long.valueOf(raw_ip);
            }else{
                ip = Useful.ipToLong(raw_ip);
            }

            Template template = this.ftl_configuration.getTemplate("api_ip_page.ftl");
            StringWriter sw = new StringWriter();

            HashMap data = (HashMap) CacheMongo.search(ip);
            data.put("_id", Useful.longToIP((Long) data.get("_id")));

            HashMap range = (HashMap) data.get("range");
            range.put("from", Useful.longToIP((Long) range.get("from")));
            range.put("to", Useful.longToIP((Long) range.get("to")));

            data.put("range", range);

            data.put("lasten", CacheMongo.getLasten());
            
            template.process(data, sw);

            return renderLayout(sw.toString());

        }catch (TemplateException e) {
            halt(500);
        }catch (IOException e) {
            halt(500);
        }
        return null;

    }

}
