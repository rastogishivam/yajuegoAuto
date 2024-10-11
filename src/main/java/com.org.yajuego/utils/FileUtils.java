package com.org.yajuego.utils;

import com.org.yajuego.constant.Constant;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;
public class FileUtils {
    private static Properties properties;
    public static void initializeProp(){
        properties = new Properties();
        String configFile = decodePath(Constant.CONFIG_PROP_PATH);
        System.out.println("Read the Config file from :: " + configFile);
        try {
            FileInputStream fileInputStream = new FileInputStream(configFile);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String decodePath(String path){
        String decodePath = path;
        try {
            decodePath = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getStackTrace());
            throw new RuntimeException(e);
        }
        return decodePath;
    }
    public static String getValue(String key){
        String value = properties.getProperty(key);
        if(value == null){
            System.err.println("The key :: " + key +" :: is not mentioned in the config file.");
        }
        return value;
    }
}
