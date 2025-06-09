package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.listeners.TestNGListeners;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.JsonUtils;
import com.swaglabs.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

// Don't forget to import the TestNG Listeners to call BrowserActions and JsonUtils
@Listeners(TestNGListeners.class) // To make Listeners work, you need to add this annotation to your test class

public class UserFlowTC {
    // Variables
    private WebDriver driver;
    JsonUtils testData;

    // Using fluent pattern to chain methods together ( Use objects from different pages in the same test)
    @Test
    public void userFlow() {
        new LoginPage(DriverManager.getDriver()).enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginButton()
                .assertSucessfulLogin()
                .addSpecificProductToCart(testData.getJsonData("product-names.item1.name"))
                .assertProductAddedToCart(testData.getJsonData("product-names.item1.name"))
                .clickCartIcon()
                .assertProductDetails(testData.getJsonData("product-names.item1.name"), testData.getJsonData("product-names.item1.price"))
                .clickCheckoutButton()
                .fillInformationForm(testData.getJsonData("user.firstName"),
                        testData.getJsonData("user.lastName"),
                        testData.getJsonData("user.postalCode"))
                .assertInformationPage(testData.getJsonData("user.firstName"),
                        testData.getJsonData("user.lastName"),
                        testData.getJsonData("user.postalCode"))
                .clickContinueButton()
                .clickFinishButton()
                .assertConfirmationMessage(testData.getJsonData("confirmation-message"));
    }
    @BeforeClass
    public void beforeClass(){
        testData = new JsonUtils("test-data");
    }
    @BeforeMethod(alwaysRun = true)
    public void setup() {
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        DriverManager.createInstance(browserName);
        driver = DriverManager.getDriver(); // Add this line
        new LoginPage(driver).navigateToLoginPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        BrowserActions.closeBrowser(driver);
    }
}
