package com.swaglabs.pages;

import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.CustomSoftAssertion;
import com.swaglabs.utils.ElementActions;
import com.swaglabs.utils.Validations;
import io.qameta.allure.Step;
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
    @Step("Navigate to the login page")
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }

    // Actions
    // Wait >> scroll >> find >> sendKeys


    // Applying Fluent pattern : Convert void to LoginPage to return object from the page
    @Step("Enter username: {username}")
    public LoginPage enterUsername(String username) {
        ElementActions.sendData(driver, this.username, username);
        return this;
    }

    @Step("Enter password: {password}")
    public LoginPage enterPassword(String password) {
        ElementActions.sendData(driver, this.password, password);
        return this;
    }

    @Step("Click on login button")
    public LoginPage clickLoginButton() {
        ElementActions.clickElement(driver, loginButton);
        return this;
    }

    @Step("Get error message")
    public String getErrorMessage() {
        return ElementActions.getText(driver, errorMessage);
    }


    // Validations
    @Step("Assert login page URL")
    public LoginPage assertLoginPageURL(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver),"https://www.saucedemo.com/inventory.html","URL is not as expected");
        return this;
    }
    @Step("Assert login page title")
    public LoginPage assertLoginPageTitle(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getPageTitle(driver),"Swag Labs","Title is not as expected");
        return this;
    }
    @Step("Assert login page")
    public LoginPage assertSucessfulLoginSoft() {
    assertLoginPageURL().assertLoginPageTitle();
    return this;
    }
    @Step("Assert successful login")
    public LoginPage assertSucessfulLogin() {
        Validations.validatePageUrl(driver,"https://www.saucedemo.com/inventory.html");
        return this;
    }

//    public LoginPage assertUnSucessfulLogin() {
//        Validations.validateEquals(getErrorMessage(),"Epic sadface: Username and password do not match any user in this service","Error Message");
//        return this;
//    }

}
