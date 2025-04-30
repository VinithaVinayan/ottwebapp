package com.ottapp.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features = "src/test/resources/com.ottapp.features", 
//glue = {"com.ottapp.stepdefinitions", "hooks"}, 
//plugin = {"pretty", "html:target/cucumber-reports.html"},
//monochrome = true)

@CucumberOptions(
        features = "src/test/resources/com.ottapp.features",
        glue = {"com.ottapp.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
    )

public class TestRunner extends AbstractTestNGCucumberTests{

}

