package com.autoqa.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static String getBaseUrl() {
        return getProperty("baseUrl");
    }

    public static int getTimeout() {
        return Integer.parseInt(getProperty("timeout"));
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(getProperty("headless"));
    }
}
