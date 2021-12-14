/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebackup.controlers;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class AppProperties {
    private static AppProperties appProperties;
    private File appFile;
    private Properties properties;
    private AppProperties () {
        appFile = new File("app.prop");
        properties = new Properties();
        try {
        if(!appFile.exists()) appFile.createNewFile();
        properties.load(new FileReader(appFile));
        } catch (IOException ex) {}
        
    }
    
    public static AppProperties getAppProperties(){
        if (appProperties==null) appProperties=new AppProperties();
        return appProperties;
    }
    
    public String getValue (String key){
        return properties.getProperty(key);
    }
    
    public String getValue (String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }
    
    public void setProperty (String key, String value){
        properties.setProperty(key, value);
        try {
            properties.store(new FileWriter(appFile), null);
        } catch (IOException ex) {}
    }
}
