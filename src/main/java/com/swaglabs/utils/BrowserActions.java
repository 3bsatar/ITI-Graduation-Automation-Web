package com.swaglabs.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private BrowserActions() {

    }

    public static void navigateToURL(WebDriver driver, String url) {
        driver.get(url);
        Logsutil.info("Navigated to URL: ", url);
    }

    public static String getCurrentURL(WebDriver driver) {
        Logsutil.info("Current URL: ", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    // Get Page title
    public static String getPageTitle(WebDriver driver) {
        Logsutil.info("Page title: ", driver.getTitle());
        return driver.getTitle();
    }
    // Refresh page
    public static void refreshPage(WebDriver driver) {
        Logsutil.info("Refreshing page");
        driver.navigate().refresh();
    }
    // Close browser
    public static void closeBrowser(WebDriver driver) {
        Logsutil.info("Closing browser");
        driver.quit();
    }
}
