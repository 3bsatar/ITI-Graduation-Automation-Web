package com.swaglabs.tests;

import com.swaglabs.pages.LoginPage;
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
    private WebDriver driver;

    @Test
    public void sucessfulLogin(){
        new LoginPage(driver).enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertSucessfulLogin();
    }

    // Configruation
    @BeforeMethod
    public void setup(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        new LoginPage(driver).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
