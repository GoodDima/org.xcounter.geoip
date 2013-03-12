package org.xcounter.geoip;

import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class GeoCollections
{

    private static HashMap<Integer, GeoLocation> locations = new HashMap<Integer, GeoLocation>();
    private static SortedSet<GeoBlock> blocks = new TreeSet<GeoBlock>();
    private static SortedSet<ASNBlock> asn_blocks = new TreeSet<ASNBlock>();

    static void addToCollection(GeoLocation o)
    {
        GeoCollections.locations.put(o.getId(), o);
    }

    static void addToCollection(GeoBlock o)
    {
        GeoCollections.blocks.add(o);
    }

    static void addToCollection(ASNBlock o)
    {
        GeoCollections.asn_blocks.add(o);
    }

    static int countLocations()
    {
        return GeoCollections.locations.size();
    }

    static int countBlocks()
    {
        return GeoCollections.blocks.size();
    }

    static int countASNBlocks()
    {
        return GeoCollections.asn_blocks.size();
    }
    
    static GeoLocation getGeoLocation(int id)
    {
        return GeoCollections.locations.get(id);
    }


    static ASNBlock searchASN(long ip)
    {
        ASNBlock seed = new ASNBlock();
        seed.setBegin(ip);

        SortedSet<ASNBlock> result = GeoCollections.asn_blocks.headSet(seed);
        Iterator<ASNBlock> iterator = result.iterator();

        while (iterator.hasNext())
        {
            ASNBlock block = iterator.next();
            if (block.getEnd() > ip)
            {
                return block;
            }
        }
        return null;
    }

    static GeoBlock search(long ip)
    {
        GeoBlock seed = new GeoBlock();
        seed.setBegin(ip);

        SortedSet<GeoBlock> result = GeoCollections.blocks.headSet(seed);
        Iterator<GeoBlock> iterator = result.iterator();

        while (iterator.hasNext())
        {
            GeoBlock block = iterator.next();
            if (block.getEnd() > ip)
            {
                return block;
            }
        }
        return null;
    }
/*
    class Interval
    {
        double begin, end;
    }

    class BeginComparator implements java.util.Comparator<Interval>
    {
        public int compare(Interval o1, Interval o2)
        {
            return Double.compare(o1.begin, o2.begin);
        }
    };
*/
}