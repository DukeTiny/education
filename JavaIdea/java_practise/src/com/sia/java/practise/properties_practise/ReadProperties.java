package com.sia.java.practise.properties_practise;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadProperties {
    Map<String,String> maps = new HashMap<String,String>();
    private String[] strs;
    File file = new File("src/com/sia/java/practise/properties_practise/config.properties");
    public ReadProperties() {
        try {
            FileReader fr = new FileReader(file.getAbsolutePath());
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            strs = str.split("=");
            maps.put(strs[0],strs[1]);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getConfig() {
        return maps.get(strs[0]);
    }


}
