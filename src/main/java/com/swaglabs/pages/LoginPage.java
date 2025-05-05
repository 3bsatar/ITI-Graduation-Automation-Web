package com.swaglabs.pages;

import com.swaglabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // Locators
    private final WebDriver driver;
    private final By username= By.id("user-name");
    private final By password= By.id("password");
    private final By loginButton= By.id("login-button");


    // Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }


    // Actions
    // Wait >> scroll >> find >> sendKeys
    public void enterUsername(String username){
        ElementActions.sendData(driver,this.username,username);
    }

    public void enterPassword(String password){
        ElementActions.sendData(driver,this.password,password);
    }

    public void clickLoginButton(){
        ElementActions.clickElement(driver,loginButton);
    }


    // Validations
}
