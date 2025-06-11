package com.swaglabs.drivers;

import com.swaglabs.utils.Logsutil;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.fail;

public class GUIDriver {
    // To run Parallel
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public GUIDriver(String browserName) {
        WebDriver driver = getDriver(browserName).startDriver();
        setDriver(driver);
    }

//    @Step("Create WebDriver instance for browser: {browserName}")
//    public static WebDriver createInstance(String browserName) {
//        WebDriver driver = BrowserFactory.getBrowser(browserName);
//        Logsutil.info("Driver is created for browser: ", browserName);
//        setDriver(driver);
//        return getDriver();
//    }

    public static AbstractDriver getDriver(String browserName) {
     switch (browserName){
         // case "chrome" -> return new ChromeFactory();
            case "chrome":
                return new ChromeFactory();
            case "firefox":
                return new FirefoxFactory();
            case "edge":
                return new EdgeFactory();
            default:
                Logsutil.error("Browser not supported: " + browserName);
                fail("Browser not supported: " + browserName);
                return null; // This line will never be reached, but is required to compile
     }
    }

    private void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public WebDriver get(){
        if(driverThreadLocal.get() ==null){
            Logsutil.error("Driver is null");
            fail("Driver is null");
            return null;
        }
        return driverThreadLocal.get();
    }
}
