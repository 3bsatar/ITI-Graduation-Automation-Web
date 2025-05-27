package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    private Validations() {

    }

    @Step("Validate that condition is true: {condition} with message: {message}")
    public static void validateTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    @Step("Validate that condition is false: {condition} with message: {message}")
    public static void validateFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    @Step("Validate Equals")
    public static void validateEquals(boolean condition, String expected, String message) {
        Assert.assertEquals(condition, expected, message);
    }

    @Step("Validate Not Equals")
    public static void validateNotEquals(boolean condition, String expected, String message) {
        Assert.assertNotEquals(condition, expected, message);
    }

    @Step("Validate Page Url: {expected}")
    public static void validatePageUrl(WebDriver driver, String expected) {
        Assert.assertEquals(BrowserActions.getCurrentURL(driver), expected);
    }

    @Step("Validate Page Title: {expected}")
    public static void validatePageTitle(WebDriver driver, String expected) {
        Assert.assertEquals(BrowserActions.getPageTitle(driver), expected);
    }
}
