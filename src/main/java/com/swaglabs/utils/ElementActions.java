package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private ElementActions() {
    }

    @Step("Send data to element: {locator} with data: {data}")
    public static void sendData(WebDriver driver, By locator, String data) {

        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).sendKeys(data);
        Logsutil.info("Data entered: ", data, "in the field: ", locator.toString());
    }

    @Step("Click on element: {locator}")
    public static void clickElement(WebDriver driver, By locator) {

        Waits.waitForElementClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).click();
        Logsutil.info("Clicked on element: ", locator.toString());
    }

    @Step("Get text from element: {locator}")
    public static String getText(WebDriver driver, By locator) {
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        Logsutil.info("CGetting text from element: ", locator.toString(), "Text: ", findElement(driver, locator).getText());
        return findElement(driver, locator).getText();
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    public static String getTextFromInput(WebDriver driver, By locator) {
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        Logsutil.info("Getting text from input element: ", locator.toString(), "Text: ", findElement(driver, locator).getDomAttribute("value"));
        return findElement(driver, locator).getDomAttribute("value");
    }
}
