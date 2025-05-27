package com.swaglabs.drivers;

import com.swaglabs.utils.Logsutil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.fail;

public class DriverManager {
    // To run Parallel
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager(){
        super();
    }
    @Step("Create WebDriver instance for browser: {browserName}")
    public static WebDriver createInstance(String browserName){
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        Logsutil.info("Driver is created for browser: ", browserName);
        setDriver(driver);
        return getDriver();
    }
    public static WebDriver getDriver(){
        if(driverThreadLocal.get() == null){
            Logsutil.error("Driver is null");
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }
    public static void setDriver(WebDriver driver){
        driverThreadLocal.set(driver);
    }
}
