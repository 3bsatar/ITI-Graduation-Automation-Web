package com.swaglabs.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createInstance(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeFactory chromeFactory = new ChromeFactory();
            driver.set(chromeFactory.startDriver());
        }
        // you can add Firefox, Edge, etc.
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

}
