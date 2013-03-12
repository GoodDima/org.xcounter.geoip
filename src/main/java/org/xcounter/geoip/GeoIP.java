package org.xcounter.geoip;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.xcounter.geoip.routes.JsonRoute;


import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class GeoIP
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        LoadData.loadData();

        Spark.get(new Route("/api/:ip")
        {
            @Override
            public Object handle(Request arg0, Response arg1)
            {
                String raw_ip = arg0.params("ip");
                long ip = 0;
                if (raw_ip.matches("\\d+")){
                    ip = Long.valueOf(raw_ip);
                }else{
                    try
                    {
                        byte[] bytes = InetAddress.getByName(raw_ip).getAddress();
                        for (byte b: bytes)
                        {  
                            ip = ip << 8 | (b & 0xFF);  
                        }
                    }catch (UnknownHostException e){
                        e.printStackTrace();
                    }
                }
//                System.out.println("Found " + ip + " " + GeoCollections.searchASN(ip));
//                System.out.println("Found " + ip + " " + GeoCollections.search(ip));
                return "Found " + ip + " " + GeoCollections.searchASN(ip) + "<br>Found " + ip + " " + GeoCollections.search(ip);
            }
        });

        Spark.get(new JsonRoute()); //"/api/:ip/json"


        //mvn compile exec:java -Dexec.mainClass="org.xcounter.geoip.GeoIP"
        //mvn exec:java -Dexec.args="server=y" -Dexec.mainClass="org.xcounter.geoip.GeoIP"

    }

}
