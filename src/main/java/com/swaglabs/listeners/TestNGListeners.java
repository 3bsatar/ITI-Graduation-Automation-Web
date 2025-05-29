package com.swaglabs.listeners;

import com.swaglabs.utils.AllureUtils;
import com.swaglabs.utils.FileUtils;
import com.swaglabs.utils.Logsutil;
import com.swaglabs.utils.ScreenshotsUtils;
import org.testng.*;

import java.io.File;

import static com.swaglabs.utils.PropertiesUtils.loadProperties;

public class TestNGListeners implements IExecutionListener, ITestListener, IInvokedMethodListener {

    File allureResult = new File("test-outputs/allure-results");
    File logs = new File("test-outputs/logs");
    File screenshots = new File("test-outputs/screenshots");

    @Override
    public void onExecutionStart() {
        // Code to execute before the test execution starts
        Logsutil.info("Test execution is starting.");
        loadProperties();
        FileUtils.deleteFile(allureResult);
        FileUtils.cleanDirectory(logs);
        FileUtils.cleanDirectory(screenshots);
    }

    @Override
    public void onExecutionFinish() {
        Logsutil.info("Test execution is finishing.");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS:
                    ScreenshotsUtils.takeScreenshot("successful_" + testResult.getName());
                    break;
                case ITestResult.FAILURE:
                    ScreenshotsUtils.takeScreenshot("failed_" + testResult.getName());
                    break;
                case ITestResult.SKIP:
                    ScreenshotsUtils.takeScreenshot("skipped_" + testResult.getName());
                    break;
            }

            AllureUtils.attacheLogsToAllureReport();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logsutil.info("Test '" + result.getName() + "' passed.");
        // ScreenshotsUtils.takeScreenshot("successful_" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logsutil.error("Test '" + result.getName() + "' failed.");
       // ScreenshotsUtils.takeScreenshot("failed_" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logsutil.warn("Test '" + result.getName() + "' skipped.");
      //  ScreenshotsUtils.takeScreenshot("skipped_" + result.getName());
    }

}
