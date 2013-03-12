package org.xcounter.geoip;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class CacheMongo
{

    static public DBObject search(long ip){
        DBCollection collection = GeoMongo.getInstance().getCollection();
        DBObject result = collection.findOne(new BasicDBObject("_id", ip));
        if (result == null){
            result = new BasicDBObject("_id", ip);
            ASNBlock asn_block = GeoCollections.searchASN(ip);
            ((BasicDBObject)result).append("asn", asn_block.getName());
            GeoBlock geo_block = GeoCollections.search(ip);
            ((BasicDBObject)result).append("range", 
                    new BasicDBObject()
                        .append("from", geo_block.getBegin())
                        .append("to", geo_block.getEnd())
                    );
            GeoLocation geo_location = GeoCollections.getGeoLocation(geo_block.getId());
            ((BasicDBObject)result).append("location", 
                    new BasicDBObject().append("name", geo_location.getName())
                        .append("country", geo_location.getCountry())
                        .append("region", geo_location.getRegion())
                        .append("postcode", geo_location.getPostcode())
                        .append("gps_lat", geo_location.getLat())
                        .append("gps_lon", geo_location.getLon())
                    );
            
            collection.insert(result);
        }
        return result;
    }

}
