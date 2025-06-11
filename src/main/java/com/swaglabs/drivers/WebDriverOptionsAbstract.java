package com.swaglabs.drivers;

import org.openqa.selenium.chrome.ChromeOptions;

// T : Template for WebDriver options
public interface WebDriverOptionsAbstract<T> {
    T getOptions();
}
