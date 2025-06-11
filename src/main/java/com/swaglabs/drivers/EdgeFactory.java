package com.swaglabs.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeFactory extends AbstractDriver implements WebDriverOptionsAbstract<EdgeOptions> {

    @Override
    public EdgeOptions getOptions() {
        org.openqa.selenium.edge.EdgeOptions options = new org.openqa.selenium.edge.EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        //                EdgeOptionsOptions edgeOptions = new EdgeOptions();
//                edgeOptions.addArguments("--start-maximized");
//                edgeOptions.addArguments("--disable-extensions");
//                edgeOptions.addArguments("--disable-infobars");
//                edgeOptions.addArguments("--disable-notifications");
//                edgeOptions.addArguments("--remote-allow-origin=*");
//                Map<String, Object> edgePrefs = Map.of(
//                        "profile.default_content_setting_values.notifications", 1,
//                        "credentials_enable_service", false,
//                        "profile.password_manager_enabled", false,
//                        "autofill.profile_enabled", false
//                );
//                edgeOptions.setExperimentalOption("prefs",edgePrefs);
//                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//                // options.addArguments("--headless");
//                return new edgeOptions(options);
        // Selenium Version not compatible with edge
        return options;
    }
    @Override
    public WebDriver startDriver() {
        return new EdgeDriver(getOptions());
    }
}
