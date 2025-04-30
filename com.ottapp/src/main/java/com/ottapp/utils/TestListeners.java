package com.ottapp.utils;

import org.testng.ITestListener;
import org.testng.ITestResult; // Import this to resolve the error
import com.aventstack.extentreports.ExtentReports;

public class TestListeners implements ITestListener {
    private ExtentReports extent;

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // String screenshotPath = ScreenshotUtils.takeScreenshot(result.getMethod().getMethodName());
        ExtentReportManager.getTest().fail("Test failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test skipped");
    }
}
