package com.swaglabs.pages;

import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.ElementActions;
import com.swaglabs.utils.Logsutil;
import com.swaglabs.utils.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage {
    // Variables
    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators


    // Actions
    public HomePage navigateToHomePage() {
        BrowserActions.navigateToURL(driver, PropertiesUtils.getPropertyValue("homePageURL"));
//        driver.get("https://www.saucedemo.com/inventory.html");
        return this;
    }

    public HomePage addSpecificProductToCart(String productName) {
        Logsutil.info("Adding product to cart: " + productName);
        // el Button elly below el productName as dynamic locator
        By addToCartButton = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.= '" + productName + "']"));
        ElementActions.clickElement(driver, addToCartButton);

        return this;
    }

    // Validations
}
