package com.ottapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * PageFactory.initElements(driver, this); is a method from the Selenium framework used to initialize the WebElements defined in a Page Object class. It binds the @FindBy annotated fields to their corresponding elements in the DOM.
				Explanation:
				1. `driver`: The WebDriver instance used to interact with the browser.
				2. `this`: Refers to the current instance of the Page Object class, where the WebElements are defined.
				This method ensures that the @FindBy annotations are processed, and the WebElements are located when the Page Object is instantiated. Without this, the @FindBy annotations would not work, and the WebElements would remain uninitialized.
*/

public class LoginPage {
	
	    WebDriver driver;

	    @FindBy(id = "username") WebElement username;
	    @FindBy(id = "password") WebElement password;
	    @FindBy(id = "loginBtn") WebElement loginBtn;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void login(String user, String pass) {
	        username.sendKeys(user);
	        password.sendKeys(pass);
	        loginBtn.click();
	    }
	}
