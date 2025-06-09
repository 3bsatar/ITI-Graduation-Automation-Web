package com.swaglabs.pages;

import com.swaglabs.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    // Locators
    private final By finishButton = By.id("finish");
    // Variables
    private WebDriver driver;

    // constructor
    public OverviewPage(WebDriver driver) {
        // Initialize elements if needed
        this.driver = driver;
    }
    // Methods

    // Change return type to ConfirmationPage to use it in E2e #TC5
    @Step("Clicking on Finish button")
    public ConfirmationPage clickFinishButton() {
        ElementActions.clickElement(driver, finishButton);
        return new ConfirmationPage(driver);
    }
    // Validations
}
