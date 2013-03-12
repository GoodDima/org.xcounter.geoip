package org.xcounter.geoip;

abstract class AbstractBlock implements Comparable<AbstractBlock>
{

    protected long begin, end;
    
    public void setBegin(long begin)
    {
        this.begin = begin;
    }

    public void setEnd(long end)
    {
        this.end = end;
    }

    public long getBegin()
    {
        return begin;
    }

    public long getEnd()
    {
        return end;
    }

    public int compareTo(AbstractBlock o)
    {
        if (this.begin < o.begin)
        {
            return -1;
        } else if (this.begin > o.begin)
        {
            return 1;
        }
        return 0;
    }

}
