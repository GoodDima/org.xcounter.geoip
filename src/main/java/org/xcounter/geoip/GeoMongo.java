package org.xcounter.geoip;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


public class GeoMongo
{

    private DBCollection collection;
    private String mongo_host = "127.0.0.1", db_name = "geoip.xcounter.org", collection_name = "cache";
    private int mongo_port = 27017;
    
    private static GeoMongo instance;

    private GeoMongo() throws UnknownHostException{

        MongoClient mongoClient = new MongoClient(new ServerAddress(this.mongo_host, this.mongo_port));
        DB database = mongoClient.getDB(this.db_name);
        this.collection = database.getCollection(this.collection_name);

    }

    static public GeoMongo getInstance(){
        if (GeoMongo.instance == null){
            try
            {
                GeoMongo.instance = new GeoMongo();
            } catch (UnknownHostException e)
            {
                e.printStackTrace();
            }
        }
        return GeoMongo.instance;
    }

    public DBCollection getCollection(){
        return this.collection;
    }

}
