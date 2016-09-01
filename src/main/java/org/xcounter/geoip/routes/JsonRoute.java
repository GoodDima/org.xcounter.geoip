package org.xcounter.geoip.routes;

import org.xcounter.geoip.CacheMongo;
import org.xcounter.geoip.Useful;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.RouteImpl;

public class JsonRoute extends RouteImpl
{

    public JsonRoute(){
        super("/api/ip/:ip/json");
    }

    @Override
    public Object handle(Request arg0, Response arg1)
    {
        String raw_ip = arg0.params("ip");
        long ip = 0;
        if (raw_ip.matches("\\d+")){
            ip = Long.valueOf(raw_ip);
        }else{
            ip = Useful.ipToLong(raw_ip);
        }
        return CacheMongo.search(ip);
    }

}
