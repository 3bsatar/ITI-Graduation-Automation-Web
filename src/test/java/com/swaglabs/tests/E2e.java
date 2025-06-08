package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.HomePage;
import com.swaglabs.pages.InformationPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.*;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

// To make Listeners work, you need to add the following annotation to your test class
@Listeners(com.swaglabs.listeners.TestNGListeners.class)
public class E2e {
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
    public void successfulLogin() {
        new LoginPage(DriverManager.getDriver()).enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertSucessfulLogin();
        // .assertSucessfulLoginSoft();

        ScreenshotsUtils.takeScreenshot("successful_login");
    }


    @Test(dependsOnMethods = "successfulLogin")
    public void addingProductToCart() {
        new HomePage(driver).addSpecificProductToCart(testData.getJsonData("product-names.item1.name"))
                .assertProductAddedToCart(testData.getJsonData("product-names.item1.name"));
    }

    @Test(dependsOnMethods = "addingProductToCart")
    public void checkoutProduct() {
        new HomePage(driver).clickCartIcon()
                .assertProductDetails(testData.getJsonData("product-names.item1.name"),
                        testData.getJsonData("product-names.item1.price"));
    }

    @Test(dependsOnMethods = "checkoutProduct")
    public void fillInformationForm() {
        new CartPage(driver).clickCheckoutButton()
                .fillInformationForm(testData.getJsonData("user.firstName"),
                        testData.getJsonData("user.lastName"),
                        testData.getJsonData("user.postalCode"))
                .assertInformationPage(testData.getJsonData("user.firstName"),
                        testData.getJsonData("user.lastName"),
                        testData.getJsonData("user.postalCode"));
    }

    @BeforeClass
    public void beforeClass() {
        // loadProperties();
        // FileUtils.deleteFile(allureResult);
        testData = new JsonUtils("test-data");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        DriverManager.createInstance(browserName);
        driver = DriverManager.getDriver(); // Add this line
        new LoginPage(driver).navigateToLoginPage();
    }


    @BeforeMethod
    public void setup() {
//        String browserName = PropertiesUtils.getPropertyValue("browserType");
//        DriverManager.createInstance(browserName);
//        driver = DriverManager.getDriver(); // Add this line
//        new LoginPage(driver).navigateToLoginPage();
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
         DriverManager.getDriver().quit();
        // CustomSoftAssertion.customAssertAll();
    }

//    @AfterClass
//    public void afterClass() {
//     //   AllureUtils.attacheLogsToAllureReport();
//    }
}
