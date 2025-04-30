package com.ottapp.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/resources/java/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:reports/cucumber-html-report"},
        tags = "@api or @ui"
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {
    
}

