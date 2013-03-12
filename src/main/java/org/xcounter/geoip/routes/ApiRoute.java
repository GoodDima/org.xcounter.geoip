package org.xcounter.geoip.routes;

import org.xcounter.geoip.CacheMongo;
import org.xcounter.geoip.Useful;

import spark.Request;
import spark.Response;
import spark.Route;

public class ApiRoute extends Route
{

    public ApiRoute(){
        this("/api/ip/:ip");
    }

    protected ApiRoute(String path)
    {
        super(path);
        // TODO Auto-generated constructor stub
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
        return CacheMongo.search(ip).toString();
    }

}
