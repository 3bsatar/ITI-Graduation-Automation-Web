package com.swaglabs.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class FirefoxFactory extends AbstractDriver implements WebDriverOptionsAbstract<FirefoxOptions> {

    @Override
    public FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--remote-allow-origin=*");
        Map<String, Object> firefoxPrefs = Map.of(
                "profile.default_content_setting_values.notifications", 1,
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile_enabled", false
        );
        // firefoxOptions.setExperimentalOption("firefoxPrefs",firefoxPrefs);
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        // options.addArguments("--headless");
        return options;
    }

    @Override
    public WebDriver startDriver() {
        return new FirefoxDriver(getOptions());
    }
}
