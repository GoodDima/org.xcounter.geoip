package org.xcounter.geoip.routes;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
            InetAddress.getAllByName(site);
        } catch (UnknownHostException e)
        {
            halt(500);
        }
        
        
        return site;
    }

}
