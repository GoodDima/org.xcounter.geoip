package org.xcounter.geoip;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

abstract class LoadData
{

    static void loadData()
    {

        String values[];
        try
        {
            FileInputStream fstream = new FileInputStream("geoip_data/GeoIPASNum2.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            ASNBlock asnBlock;
            while ((strLine = br.readLine()) != null)
            {
                values = strLine.split(",");
                asnBlock = new ASNBlock();
                asnBlock.setBegin(Long.parseLong(values[0]));
                asnBlock.setEnd(Long.parseLong(values[1]));
                asnBlock.setName(values[2]);
                GeoCollections.addToCollection(asnBlock);

            }
            in.close();
        } catch (Exception e)
        {// Catch exception if any
            e.printStackTrace();
        }

        try
        {
            FileInputStream fstream = new FileInputStream("geoip_data/GeoLiteCity-Location.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            GeoLocation gl;
            while ((strLine = br.readLine()) != null)
            {
                values = strLine.split(",");
                gl = new GeoLocation();
                gl.setId(Integer.parseInt(values[0]));
                gl.setName(values[3]);
                gl.setLat(Float.parseFloat(values[5]));
                gl.setLon(Float.parseFloat(values[5]));
                GeoCollections.addToCollection(gl);
            }
            in.close();
        } catch (Exception e)
        {// Catch exception if any
            e.printStackTrace();
        }

        try
        {
            FileInputStream fstream = new FileInputStream("geoip_data/GeoLiteCity-Blocks.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            GeoBlock gb;
            GeoLocation gl;
            while ((strLine = br.readLine()) != null)
            {
                values = strLine.split(",");
                gb = new GeoBlock();
                gb.setBegin(Long.parseLong(values[0]));
                gb.setEnd(Long.parseLong(values[1]));
                gb.setId(Integer.parseInt(values[2]));
                gl = GeoCollections.getGeoLocation(gb.getId());
                if (gl != null)
                {
                    GeoCollections.addToCollection(gb);
                }
            }
            in.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
