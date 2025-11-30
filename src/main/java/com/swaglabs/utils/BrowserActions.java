package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private BrowserActions() {

    }
    @Step("Navigate to URL: {url}")
    public static void navigateToURL(WebDriver driver, String url) {
        driver.get(url);
        Logsutil.info("Navigated to URL: ", url);
    }
    @Step("Get current URL")
    public static String getCurrentURL(WebDriver driver) {
        Logsutil.info("Current URL: ", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    @Step("Get page title")
    public static String getPageTitle(WebDriver driver) {
        Logsutil.info("Page title: ", driver.getTitle());
        return driver.getTitle();
    }
    @Step("Refresh page")
    public static void refreshPage(WebDriver driver) {
        Logsutil.info("Refreshing page");
        driver.navigate().refresh();
    }
    @Step("Close browser")
    public static void closeBrowser(WebDriver driver) {
        Logsutil.info("Closing browser");
        driver.quit();
    }
}
