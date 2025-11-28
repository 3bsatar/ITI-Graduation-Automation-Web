package com.swaglabs.utils;

import java.io.File;
import java.util.Collection;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;

public class PropertiesUtils {

    private PropertiesUtils() {
        super();
    }

    public final static String PROPERTIES_PATH = "src/main/resources/";

    public static Properties loadProperties() {
        try {
            Properties properties = new Properties();
            Collection<File> propertiesFilesList;
            propertiesFilesList = FileUtils.listFiles(new File(PROPERTIES_PATH), new String[]{"properties"}, true);
            propertiesFilesList.forEach(propertyFile -> {
                try {
                    properties.load(new FileInputStream(propertyFile));
                } catch (IOException ioe) {
                    Logsutil.error(ioe.getMessage());
                }
                properties.putAll(System.getProperties());
                System.getProperties().putAll(properties);
            });
            Logsutil.info("Loading Properties File Data");
            return properties;
        } catch (Exception e) {
            Logsutil.error("Failed to Load Properties File Data because: " + e.getMessage());
            return null;
        }
    }

    // Get the value of the property
    public static String getPropertyValue(String key) {

        try {
            return System.getProperty(key);
        } catch (Exception e) {
            Logsutil.error(e.getMessage());
            return "";
        }
    }
}
