package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class LoadProperty {
    static Properties prop;
    static FileInputStream input;
    static String fileName = "config.properties";
    static String fileLocation = "src/test/resources/TestData/config.properties";

    public String getProperty(String keyName) {
        prop = new Properties();
        try {
            input = new FileInputStream(fileLocation);
            prop.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(keyName);
    }

}