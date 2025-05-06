package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.CustomSoftAssertion;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    // Variables
    // private WebDriver driver; Relpace it by using DriverManager.getDriver()

    @Test
    public void sucessfulLogin(){
        new LoginPage(DriverManager.getDriver()).enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertSucessfulLogin();
                // .assertSucessfulLoginSoft();
    }

    // Configruations
    @BeforeMethod
    public void setup(){
//        driver = DriverManager.createInstance("chrome");
//        new LoginPage(driver).navigateToLoginPage();
        DriverManager.createInstance("chrome");
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
        DriverManager.getDriver().quit();
        // CustomSoftAssertion.customAssertAll();
    }
}
