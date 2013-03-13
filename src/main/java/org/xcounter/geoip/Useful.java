package org.xcounter.geoip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Useful
{

    static public long ipToLong(String raw_ip){

        long ip = 0l;
        try{
            byte[] bytes = InetAddress.getByName(raw_ip).getAddress();
            for (byte b: bytes)
            {
                ip = ip << 8 | (b & 0xFF);
            }
        }catch (UnknownHostException e){
//            e.printStackTrace();
        }finally{
            return ip;
        }
    }
    
    static public String trimChar(String str, char chr){
        String result = str;
        
        if (result.charAt(0) == chr && result.charAt(result.length() - 1) == chr){
            result = result.substring(1, result.length() - 1);
        }
        
        return result;
    }

    static public String longToIP(long i){
        return ((i >> 24 ) & 0xFF) + "." + ((i >> 16 ) & 0xFF) + "." +  ((i >> 8 ) & 0xFF) + "." + ( i & 0xFF);
    }
    
}
