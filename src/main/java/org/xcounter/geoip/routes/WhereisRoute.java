package org.xcounter.geoip.routes;

import java.io.IOException;
import java.io.StringWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedList;

import org.xcounter.geoip.CacheMongo;
import org.xcounter.geoip.Useful;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import spark.Request;
import spark.Response;

public class WhereisRoute extends UIRoute{

    public WhereisRoute()
    {
        super("/api/whereis/:site/");
    }

    @Override
    public Object handle(Request arg0, Response arg1)
    {
        String site = arg0.params("site");
        try
        {
            InetAddress[] addresses = InetAddress.getAllByName(site);
            LinkedList<HashMap> responce = new LinkedList<HashMap>();
            HashMap values = new HashMap();
            Template template = this.ftl_configuration.getTemplate("where_is_page.ftl");
            StringWriter sw = new StringWriter();
            HashMap data;
            long ip;
            for (int i = 0; i < addresses.length; i++)
            {
                
                InetAddress inetAddress = addresses[i];
                if (inetAddress instanceof Inet4Address){
                    ip = Useful.ipToLong(inetAddress.getHostAddress());
                    
                    data = (HashMap) CacheMongo.search(ip);
                    data.put("_id", Useful.longToIP((Long) data.get("_id")));

                    HashMap range = (HashMap) data.get("range");
                    range.put("from", Useful.longToIP((Long) range.get("from")));
                    range.put("to", Useful.longToIP((Long) range.get("to")));

                    data.put("range", range);

                    responce.add(data);
                }
            }
            values.put("list", responce);
            template.process(values, sw);

            return renderLayout(sw.toString());

            
        } catch (UnknownHostException e)
        {
            halt(500);
        }catch (TemplateException e) {
            halt(500);
        }catch (IOException e) {
            halt(500);
        }

        
        
        return site;
    }

}
