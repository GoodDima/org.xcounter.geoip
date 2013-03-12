package org.xcounter.geoip;

public class GeoBlock extends AbstractBlock
{

    private int id;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String toString()
    {
        StringBuilder r = new StringBuilder("Range: ");
        r.append(begin);
        r.append(" - ");
        r.append(end);
        r.append(" Location: ");
        r.append(GeoCollections.getGeoLocation(id));
        return r.toString();
    }

}