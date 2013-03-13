package org.xcounter.geoip.routes;

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
        return site;
    }

}
