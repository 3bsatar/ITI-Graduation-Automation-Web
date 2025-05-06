package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private ElementActions(){
    }

    // sendKeys
    public static void sendData(WebDriver driver, By locator,String data){

        Waits.waitForElementVisible(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        findElement(driver,locator).sendKeys(data);
    }

    // Click
    public static void clickElement(WebDriver driver, By locator){

        Waits.waitForElementClickable(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        findElement(driver,locator).click();
    }

    public static String getText(WebDriver driver,By locator){
        Waits.waitForElementVisible(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        return findElement(driver,locator).getText();
    }

    public static WebElement findElement(WebDriver driver, By locator){
        return driver.findElement(locator);
    }
}
