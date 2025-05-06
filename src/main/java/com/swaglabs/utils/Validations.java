package com.swaglabs.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    private Validations(){

    }

    public static void validateTrue(boolean condition,String message){
        Assert.assertTrue(condition,message);
    }
    public static void validateFalse(boolean condition,String message){
        Assert.assertFalse(condition,message);
    }
    public static void validateEquals(boolean condition,String expected,String message){
        Assert.assertEquals(condition,expected,message);
    }
    public static void validateNotEquals(boolean condition,String expected,String message){
        Assert.assertNotEquals(condition,expected,message);
    }
    public static void validatePageUrl(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),expected);
    }
    public static void validatePageTitle(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getPageTitle(driver),expected);
    }
}
