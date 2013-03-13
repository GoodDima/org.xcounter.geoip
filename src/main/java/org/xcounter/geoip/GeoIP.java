package org.xcounter.geoip;

import java.util.Locale;

import org.xcounter.geoip.routes.ApiRoute;
import org.xcounter.geoip.routes.IndexRoute;
import org.xcounter.geoip.routes.JsonRoute;
import org.xcounter.geoip.routes.WhereisRoute;

import spark.Spark;

public class GeoIP
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        LoadData.loadData();
        
        Locale.setDefault(Locale.US);

        Spark.get(new JsonRoute()); //"/api/ip/:ip/json"
        
        Spark.get(new ApiRoute());  //"/api/ip/:ip"
        
        Spark.get(new WhereisRoute());  //"/api/whereis/:site"
        
        Spark.get(new IndexRoute());  //"/"

        

        

        //mvn compile exec:java -Dexec.mainClass="org.xcounter.geoip.GeoIP"
        //mvn exec:java -Dexec.args="server=y" -Dexec.mainClass="org.xcounter.geoip.GeoIP"

    }

}
