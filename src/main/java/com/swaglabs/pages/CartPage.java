package com.swaglabs.pages;

import com.swaglabs.utils.CustomSoftAssertion;
import com.swaglabs.utils.ElementActions;
import com.swaglabs.utils.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    // locators
    private final By productName = By.cssSelector(".inventory_item_name");
    private final By productPrice = By.cssSelector(".inventory_item_price");
    private final By checkoutButton = By.cssSelector(".checkout_button");

    // Variables
    private WebDriver driver;

    // constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // actions
    public String getProductName() {

        return ElementActions.getText(driver, productName);
    }

    public String getProductPrice() {
        return ElementActions.getText(driver, productPrice);
    }

    public CartPage clickCheckoutButton() {
        ElementActions.clickElement(driver, checkoutButton);
        return this;
    }

    // validations
    public CartPage assertProductDetails(String expectedProductName, String expectedProductPrice) {
        String actualProductName = getProductName();
        String actualProductPrice = getProductPrice();
        // Using CustomSoftAssertion to allow multiple assertions without stopping the test
        CustomSoftAssertion.softAssertion.assertEquals(actualProductName, expectedProductName, "Product name does not match");
        CustomSoftAssertion.softAssertion.assertEquals(actualProductPrice, expectedProductPrice, "Product price does not match");
//        Validations.validateEquals(actualProductName, expectedProductName, "Product name does not match");
//        Validations.validateEquals(actualProductPrice, expectedProductPrice, "Product price does not match");
        return this;
    }
}
