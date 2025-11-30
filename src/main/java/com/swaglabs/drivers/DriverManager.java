package com.swaglabs.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createInstance(String browserName) {
        if (browserName == null) {
            throw new IllegalArgumentException("Browser name cannot be null");
        }

        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeFactory chromeFactory = new ChromeFactory();
                driver.set(chromeFactory.startDriver());
                break;

            case "firefox":
                FirefoxFactory firefoxFactory = new FirefoxFactory();
                driver.set(firefoxFactory.startDriver());
                break;

            case "edge":
                EdgeFactory edgeFactory = new EdgeFactory();
                driver.set(edgeFactory.startDriver());
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }


    public static WebDriver getDriver() {
        return driver.get();
    }

}
