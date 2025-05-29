package com.swaglabs.listeners;

import com.swaglabs.utils.Scrolling;
import com.swaglabs.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebManagerListener implements WebDriverListener {
    public void beforeFindElement(WebDriver driver, By locator) {
        Waits.waitForElementClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
    }
}
