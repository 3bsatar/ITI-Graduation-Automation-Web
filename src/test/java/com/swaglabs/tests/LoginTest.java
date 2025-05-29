package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.*;
import io.qameta.allure.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

import java.io.File;

import static com.swaglabs.utils.PropertiesUtils.loadProperties;

// To make Listeners work, you need to add the following annotation to your test class
@Listeners(com.swaglabs.listeners.TestNGListeners.class)
public class LoginTest {
    // Variables
    String browserName = PropertiesUtils.getPropertyValue("browserType");
    // File allureResult = new File("test-outputs/allure-results");
    JsonUtils testData;
    // private WebDriver driver; Relpace it by using DriverManager.getDriver()

    WebDriver driver;
    @Epic("Login")
    @Feature("Login feature")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid login")
    @Description("Verify successful login with valid credentials")
    @Test
    public void sucessfulLogin() {
        new LoginPage(DriverManager.getDriver()).enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertSucessfulLogin();
        // .assertSucessfulLoginSoft();

        ScreenshotsUtils.takeScreenshot("successful_login");
    }

    // Configruations

    @BeforeClass
    public void beforeClass() {
        // loadProperties();
        // FileUtils.deleteFile(allureResult);
        testData= new JsonUtils("test-data");
    }


    @BeforeMethod
    public void setup() {
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        DriverManager.createInstance(browserName);
        driver = DriverManager.getDriver(); // Add this line
        new LoginPage(driver).navigateToLoginPage();
    }


    @AfterMethod
    public void tearDown() {
        //driver.quit();
        // DriverManager.getDriver().quit();
        // CustomSoftAssertion.customAssertAll();
        BrowserActions.closeBrowser(driver);
    }

//    @AfterClass
//    public void afterClass() {
//     //   AllureUtils.attacheLogsToAllureReport();
//    }
}
