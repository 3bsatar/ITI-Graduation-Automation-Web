package com.swaglabs.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class ChromeFactory extends AbstractDriver implements WebDriverOptionsAbstract<ChromeOptions> {


    @Override
    public ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origin=*");
        Map<String, Object> prefs = Map.of(
                "profile.default_content_setting_values.notifications", 1,
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile_enabled", false
        );
        options.setExperimentalOption("prefs",prefs);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        // options.addArguments("--headless");
        return options;
    }
    @Override
    public WebDriver startDriver() {
        return new ChromeDriver(getOptions());
    }
}
