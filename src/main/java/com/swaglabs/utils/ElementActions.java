package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private ElementActions() {
    }

    // sendKeys
    public static void sendData(WebDriver driver, By locator, String data) {

        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).sendKeys(data);
        Logsutil.info("Data entered: ", data, "in the field: ", locator.toString());
    }

    // Click
    public static void clickElement(WebDriver driver, By locator) {

        Waits.waitForElementClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).click();
        Logsutil.info("Clicked on element: ", locator.toString());
    }

    public static String getText(WebDriver driver, By locator) {
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        Logsutil.info("CGetting text from element: ", locator.toString(), "Text: ", findElement(driver, locator).getText());
        return findElement(driver, locator).getText();
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }
}
