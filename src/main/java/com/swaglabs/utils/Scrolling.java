package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scrolling {
    private Scrolling(){
    }

    public static void scrollToElement(WebDriver driver, By locator){
        // Code
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);",ElementActions.findElement(driver,locator));
    }
}
