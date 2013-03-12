package org.xcounter.geoip;

public class GeoLocation implements Comparable<GeoLocation>
{

    private int id;
    private String name, country, postcode, region;
    private float lat, lon;

    public void setLon(float lon)
    {
        this.lon = lon;
    }

    public void setLat(float lat)
    {
        this.lat = lat;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getLon()
    {
        return lon;
    }

    public float getLat()
    {
        return lat;
    }

    public String getName()
    {
        return name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public int compareTo(GeoLocation o)
    {

        if (this.id < o.id)
        {
            return -1;
        } else if (this.id > o.id)
        {
            return 1;
        }
        return 0;

    }

    public String toString()
    {
        return this.name;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

}
