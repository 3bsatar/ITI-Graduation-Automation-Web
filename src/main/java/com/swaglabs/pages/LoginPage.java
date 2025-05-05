package com.swaglabs.pages;

import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    // Locators
    private final WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to the login page
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }

    // Actions
    // Wait >> scroll >> find >> sendKeys


    // Applying Fluent pattern : Convert void to LoginPage to return object from the page
    public LoginPage enterUsername(String username) {
        ElementActions.sendData(driver, this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        ElementActions.sendData(driver, this.password, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        ElementActions.clickElement(driver, loginButton);
        return this;
    }

    public String getErrorMessage() {
        return ElementActions.getText(driver, errorMessage);
    }


    // Validations
    public LoginPage assertSucessfulLogin() {
        Assert.assertEquals(BrowserActions.getCurrentURL(driver), "https://www.saucedemo.com/inventory.html");
        return this;
    }

    public LoginPage assertUnSucessfulLogin() {
        Assert.assertEquals(getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
        return this;
    }

}
