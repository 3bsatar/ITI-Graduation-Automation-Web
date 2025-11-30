package com.swaglabs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class PropertiesUtils {

    private PropertiesUtils() { super(); }

    public final static String PROPERTIES_PATH = "src/main/resources/";
    private static Properties properties;

    static {
        properties = loadProperties();
    }

    public static Properties loadProperties() {
        try {
            Properties props = new Properties();
            Collection<File> propertiesFilesList = FileUtils.listFiles(new File(PROPERTIES_PATH), new String[]{"properties"}, true);
            for (File propertyFile : propertiesFilesList) {
                try (FileInputStream fis = new FileInputStream(propertyFile)) {
                    props.load(fis);
                } catch (IOException ioe) {
                    Logsutil.error(ioe.getMessage());
                }
            }
            Logsutil.info("Loading Properties File Data");
            return props;
        } catch (Exception e) {
            Logsutil.error("Failed to Load Properties File Data because: " + e.getMessage());
            return new Properties();
        }
    }

    public static String getPropertyValue(String key) {
        try {
            if (properties.containsKey(key)) {
                return properties.getProperty(key);
            } else {
                return System.getProperty(key, "");
            }
        } catch (Exception e) {
            Logsutil.error(e.getMessage());
            return "";
        }
    }
}
