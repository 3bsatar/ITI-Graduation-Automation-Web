package steps;
import com.swaglabs.drivers.DriverManager;
import com.swaglabs.pages.*;
import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.JsonUtils;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EshopSteps {

    private WebDriver driver = DriverManager.getDriver();
    private JsonUtils testData = new JsonUtils("test-data");

    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private InformationPage informationPage;
    private OverviewPage overviewPage;
    private ConfirmationPage confirmationPage;

    @Before
    public void setUp() {
        String browserName = "chrome";
        DriverManager.createInstance(browserName);
        driver = DriverManager.getDriver();
        testData = new JsonUtils("test-data");
    }

    @Given("the user is on the login page")
    public void navigateToLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @When("the user logs in with valid credentials")
    public void userLogsIn() {
        homePage = loginPage
                .enterUsername(testData.getJsonData("login-credentials.username"))
                .enterPassword(testData.getJsonData("login-credentials.password"))
                .clickLoginButton()
                .assertSucessfulLogin(); // HomePage
    }

    @When("adds a specific product to the cart")
    public void addProductToCart() {
        homePage
                .addSpecificProductToCart(testData.getJsonData("product-names.item1.name"))
                .assertProductAddedToCart(testData.getJsonData("product-names.item1.name"));
    }

    @When("goes to the cart page")
    public void goToCart() {
        cartPage = homePage.clickCartIcon(); // CartPage
        cartPage.assertProductDetails(
                testData.getJsonData("product-names.item1.name"),
                testData.getJsonData("product-names.item1.price")
        );
    }

    @When("proceeds to checkout")
    public void proceedToCheckout() {
        informationPage = cartPage.clickCheckoutButton(); // InformationPage
    }

    @When("fills in personal information")
    public void fillInformation() {
        overviewPage = informationPage
                .fillInformationForm(
                        testData.getJsonData("user.firstName"),
                        testData.getJsonData("user.lastName"),
                        testData.getJsonData("user.postalCode")
                )
                .assertInformationPage(
                        testData.getJsonData("user.firstName"),
                        testData.getJsonData("user.lastName"),
                        testData.getJsonData("user.postalCode")
                )
                .clickContinueButton(); // OverviewPage
    }

    @When("continues to finish the order")
    public void finishOrder() {
        confirmationPage = overviewPage.clickFinishButton(); // ConfirmationPage
    }

    @Then("the user should see the confirmation message")
    public void checkConfirmationMessage() {
        confirmationPage.assertConfirmationMessage(testData.getJsonData("confirmation-message"));
    }
}