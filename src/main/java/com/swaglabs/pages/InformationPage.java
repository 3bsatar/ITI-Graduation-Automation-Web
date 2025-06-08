package com.swaglabs.pages;

import com.swaglabs.utils.CustomSoftAssertion;
import com.swaglabs.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage {
    // locators
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    // code
    // Variables
    private WebDriver driver;
    // constructor
    public InformationPage(WebDriver driver) {
        this.driver = driver;
    }
    // actions
    @Step("Fill in the information form")
    public InformationPage fillInformationForm(String firstName, String lastName, String postalCode) {
        ElementActions.sendData(driver, this.firstName, firstName);
        ElementActions.sendData(driver, this.lastName, lastName);
        ElementActions.sendData(driver, this.postalCode, postalCode);
        return this;
    }
    @Step("Click on continue button")
    public InformationPage clickContinueButton() {
        ElementActions.clickElement(driver, continueButton);
        return this;
    }

    // validations
    @Step("Assert information form is filled correctly")
    public void assertInformationPage(String firstName, String lastName, String postalCode) {
        CustomSoftAssertion.softAssertion.assertEquals(ElementActions.getTextFromInput(driver, this.firstName), firstName, "First name field is not filled correctly");
        CustomSoftAssertion.softAssertion.assertEquals(ElementActions.getTextFromInput(driver, this.lastName), lastName, "Last name field is not filled correctly");
        CustomSoftAssertion.softAssertion.assertEquals(ElementActions.getTextFromInput(driver, this.postalCode), postalCode, "Postal code field is not filled correctly");
    }
}
