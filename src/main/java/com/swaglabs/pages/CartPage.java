package com.swaglabs.pages;

import com.swaglabs.utils.CustomSoftAssertion;
import com.swaglabs.utils.ElementActions;
import com.swaglabs.utils.Validations;
import io.qameta.allure.Step;
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
    @Step("Get product name from cart")
    private String getProductName() {

        return ElementActions.getText(driver, productName);
    }

    @Step("Get product price from cart")
    private String getProductPrice() {
        return ElementActions.getText(driver, productPrice);
    }

    @Step("Click on checkout button")
    // Change the return type to InformationPage to use it in #TC4 checkoutProduct
    public InformationPage clickCheckoutButton() {
        ElementActions.clickElement(driver, checkoutButton);
        return new InformationPage(driver);
    }

    // validations
    @Step("Assert product details in cart")
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
