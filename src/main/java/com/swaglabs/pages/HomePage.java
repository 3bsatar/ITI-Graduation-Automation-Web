package com.swaglabs.pages;

import com.swaglabs.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import com.swaglabs.utils.Validations;

public class HomePage {
    // Variables
    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");

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

    // Using Fluent Pattern "CartPage object not HomePage"
    public CartPage clickCartIcon() {
        Logsutil.info("Clicking on cart icon");
        ElementActions.clickElement(driver, cartIcon);
        return new CartPage(driver);
    }
    // Validations

    public HomePage assertProductAddedToCart(String productName) {
        By addToCartButton = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.= '" + productName + "']"));
        String actualValue = ElementActions.getText(driver, addToCartButton);
        Logsutil.info("Asserting product added to cart: " + productName + ", Actual Value: " + actualValue);

        // FIX: Compare strings directly
        Validations.validateEquals(actualValue, "Remove", "Product was not added to cart successfully");

        Logsutil.info("Product added to cart successfully: " + productName);
        return this;
    }


}
