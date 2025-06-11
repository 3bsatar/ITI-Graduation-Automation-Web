package com.swaglabs.utils;

import com.swaglabs.drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import static com.swaglabs.utils.TimestampUtils.getCurrentTimestamp;

public class ScreenshotsUtils {

    public static final String SCREENSHOTS_PATH = "test-outputs/screenshots/";

    private ScreenshotsUtils() {
        // Prevent instantiation
    }

    public static void takeScreenshot(String screenshotName) {
        try {
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + "_" + getCurrentTimestamp() + ".png");

            // Ensure the directory exists
            screenshotFile.getParentFile().mkdirs();

            FileUtils.copyFile(screenshot, screenshotFile);
            AllureUtils.attachScreenshotToAllureReport(screenshotName, screenshotFile.getPath());
        } catch (Exception e) {
            Logsutil.error("Failed to take screenshot: " + e.getMessage());
        }
    }
}
