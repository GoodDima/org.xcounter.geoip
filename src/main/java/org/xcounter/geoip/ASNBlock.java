package org.xcounter.geoip;

public class ASNBlock extends AbstractBlock
{

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        StringBuilder r = new StringBuilder("Range: ");
        r.append(begin);
        r.append(" - ");
        r.append(end);
        r.append(" ASN: ");
        r.append(name);
        return r.toString();
    }

}
