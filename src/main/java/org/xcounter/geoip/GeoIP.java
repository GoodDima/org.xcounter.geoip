package org.xcounter.geoip;

import org.xcounter.geoip.routes.ApiRoute;
import org.xcounter.geoip.routes.JsonRoute;

import spark.Spark;

public class GeoIP
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        LoadData.loadData();

        Spark.get(new ApiRoute());

        Spark.get(new JsonRoute()); //"/api/:ip/json"

        //mvn compile exec:java -Dexec.mainClass="org.xcounter.geoip.GeoIP"
        //mvn exec:java -Dexec.args="server=y" -Dexec.mainClass="org.xcounter.geoip.GeoIP"

    }

}
