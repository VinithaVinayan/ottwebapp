package com.ottapp.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static WebDriver driver;
	
	public static WebDriver getDriver(String browser) {
		if (driver == null) {
			switch(browser.toLowerCase()) {
				case "chrome":
					WebDriverManager.chromedriver().setup(); // Initialize the WebDriver instance here
					driver = new ChromeDriver(); // or new FirefoxDriver() based on your requirement
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
					throw new IllegalArgumentException("Browser not supported: " + browser);
			}
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
