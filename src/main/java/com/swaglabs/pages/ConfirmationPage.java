package com.swaglabs.pages;

import com.swaglabs.utils.ElementActions;
import com.swaglabs.utils.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    // Locators
    private final By confirmationMessage = By.cssSelector(".complete-header");
    // Variables
    private WebDriver driver;

    // Constructor
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // actions
    @Step("Getting confirmation message")
    public String getConfirmationMessage() {
        return ElementActions.getText(driver, confirmationMessage);
    }

    // Validations
    @Step("Validating confirmation message: {expectedMessage}")
    public void assertConfirmationMessage(String expectedMessage) {
        String actualMessage = getConfirmationMessage();
        Validations.validateEquals(actualMessage, expectedMessage, "Confirmation message validation failed");
    }
}
