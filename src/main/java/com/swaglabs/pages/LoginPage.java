package com.swaglabs.pages;

import com.swaglabs.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) { this.driver = driver; }

    @Step("Navigate to the login page")
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }

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

    @Step("Assert login page URL")
    public LoginPage assertLoginPageURL() {
        CustomSoftAssertion.softAssertion.assertEquals(
                BrowserActions.getCurrentURL(driver),
                PropertiesUtils.getPropertyValue("homeURL"),
                "URL is not as expected"
        );
        return this;
    }

    @Step("Assert login page title")
    public LoginPage assertLoginPageTitle() {
        CustomSoftAssertion.softAssertion.assertEquals(
                BrowserActions.getPageTitle(driver),
                PropertiesUtils.getPropertyValue("appTitle"),
                "Title is not as expected"
        );
        return this;
    }

    @Step("Assert successful login")
    public HomePage assertSucessfulLogin() {
        Validations.validatePageUrl(driver, PropertiesUtils.getPropertyValue("homeURL"));
        return new HomePage(driver);
    }

    @Step("Assert unsuccessful login")
    public HomePage assertUnSucessfulLogin() {
        Validations.validateEquals(
                getErrorMessage().equals(PropertiesUtils.getPropertyValue("errorMSG")),
                PropertiesUtils.getPropertyValue("errorMSG"),
                "Error Message"
        );
        return new HomePage(driver);
    }
}
