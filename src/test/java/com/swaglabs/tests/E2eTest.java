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

import static com.swaglabs.utils.TimestampUtils.getCurrentTimestamp;

@Test(singleThreaded = true)
@Listeners({com.swaglabs.listeners.TestNGListeners.class, io.qameta.allure.testng.AllureTestNg.class})
public class E2eTest {

    static {
        String projectPath = System.getProperty("user.dir");
        String allureResultsPath = projectPath + "/test-outputs/allure-results";
        System.setProperty("allure.results.directory", allureResultsPath);
    }

    JsonUtils testData;
    WebDriver driver;
    String FIRST_NAME;
    String LAST_NAME;


    @Test(groups = "e2e")
    public void successfulLogin() {
        new LoginPage(driver)
                .enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginButton()
                .assertSucessfulLogin();

        ScreenshotsUtils.takeScreenshot("successful_login");
    }

    @Test(groups = "e2e", dependsOnMethods = "successfulLogin")
    public void addingProductToCart() {
        new HomePage(driver)
                .addSpecificProductToCart(testData.getJsonData("product-names.item1.name"))
                .assertProductAddedToCart(testData.getJsonData("product-names.item1.name"));
    }

    @Test(groups = "e2e", dependsOnMethods = "addingProductToCart")
    public void checkoutProduct() {
        new HomePage(driver)
                .clickCartIcon()
                .assertProductDetails(
                        testData.getJsonData("product-names.item1.name"),
                        testData.getJsonData("product-names.item1.price"));
    }

    @Test(groups = "e2e", dependsOnMethods = "checkoutProduct")
    public void fillInformationForm() {
        new CartPage(driver)
                .clickCheckoutButton()
                .fillInformationForm(
                        FIRST_NAME,
                        LAST_NAME,
                        testData.getJsonData("user.postalCode"))
                .assertInformationPage(
                        FIRST_NAME,
                        LAST_NAME,
                        testData.getJsonData("user.postalCode"));
    }

    @Test(groups = "e2e", dependsOnMethods = "fillInformationForm")
    public void overviewPage() {
        new InformationPage(driver)
                .clickContinueButton()
                .clickFinishButton()
                .assertConfirmationMessage(testData.getJsonData("confirmation-message"));
    }


    @BeforeClass(alwaysRun = true)
    public void setup() {
        testData = new JsonUtils("test-data");

        FIRST_NAME = testData.getJsonData("user.firstName") + getCurrentTimestamp();
        LAST_NAME = testData.getJsonData("user.lastName") + getCurrentTimestamp();

        String browserName = PropertiesUtils.getPropertyValue("browserType");
        DriverManager.createInstance(browserName);

        driver = DriverManager.getDriver();
        new LoginPage(driver).navigateToLoginPage();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}
