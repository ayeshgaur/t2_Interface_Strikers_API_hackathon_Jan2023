package com.api.hackathon.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
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
}
