package com.api.hackathon.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderWriter {
    public static Properties loadConfig() {

        System.out.println("executing LoadProperties.....");
        Properties prop = new Properties();
        try {

            System.out.println(System.getProperty("user.dir") + "//src//test//resources//config.properties");

            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;

    }


    public static void storeConfig(String key, String value) throws IOException {

        Properties props = new Properties();
        //Populating the properties file
        props.put(key, value);
        //Instantiating the FileInputStream for output file
        String path = System.getProperty("user.dir") + "//src//test//resources//config.properties";
        FileOutputStream outputStrem = new FileOutputStream(path);
        //Storing the properties file
        props.store(outputStrem, "This is a sample properties file");
        System.out.println("Properties file created......");
    }


}
