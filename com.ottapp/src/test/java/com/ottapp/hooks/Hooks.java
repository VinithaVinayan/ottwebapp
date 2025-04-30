package com.ottapp.hooks;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.ottapp.driver.DriverManager;
import com.ottapp.utils.ExtentReportManager;
import com.ottapp.utils.Logger;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private static WebDriver driver = DriverManager.getDriver("chrome"); // Initialize the WebDriver instance here

    @Before
    public void setup(Scenario scenario) {  
        // Initialize Extent Reports before creating the test
        ExtentReportManager.initReports();  
        
        // Create a test in the report with the scenario name
        ExtentReportManager.createTest(scenario.getName());

        System.out.println("🔹 Scenario Name: " + scenario.getName()); 

        if (driver == null) {
            driver = DriverManager.getDriver("chrome");
            Logger.info("Browser is launching...");
        }
    }

    @After(order = 1) // This will run after each scenario
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(src.toPath(), Paths.get("screenshots/" + scenario.getName() + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        DriverManager.quitDriver(); // Quit the driver after each scenario
    }
    
    @After(order = 2) // This will run after each scenario
    public void tearDownAfterTest(Scenario scenario) {
    ExtentTest test = ExtentReportManager.getTest();

    if (test == null) {
        System.out.println("❌ ERROR: ExtentTest instance is NULL for scenario: " + scenario.getName());
    } else {
        if (scenario.isFailed()) {
            test.fail("❌ Test Failed: " + scenario.getName());
        } else {
            test.pass("✅ Test Passed: " + scenario.getName());
        }
    }

    ExtentReportManager.flushReports();  // Flush the reports
    Logger.info("Scenario Completed: " + scenario.getName());
    }
    
    
    @AfterAll
    public static void tearDownAfterAll() { // Close browser after all tests
        if (driver != null) {
            DriverManager.quitDriver();
            driver = null; // Reset driver
        }
    }
}
