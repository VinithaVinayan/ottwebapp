package com.ottapp.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ottapp.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	WebDriver driver;
    LoginPage login;
    
	@Given("user launches ott app first launch screen")
	public void user_launches_ott_app_first_launch_screen() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User launches OTT app first launch screen");
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user logged into the application")
	public void user_logged_into_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user is on home screen")
	public void user_is_on_home_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
