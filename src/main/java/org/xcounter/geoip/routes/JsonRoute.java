package org.xcounter.geoip.routes;

import spark.Request;
import spark.Response;
import spark.Route;

public class JsonRoute extends Route
{

    public JsonRoute(){
        this("/api/ip/:ip/json");
    }

    protected JsonRoute(String path)
    {
        super(path);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object handle(Request arg0, Response arg1)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
