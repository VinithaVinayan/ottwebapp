package com.ottapp.stepDefinitions;

import com.ottapp.api.ApiUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class ApiTest {
	ApiTest apitest;
	 Response response;

	    @When("I perform GET request on {string}")
	    public void i_perform_get_request(String url) {
	        response = ApiUtils.getRequest(url);
	    }

	    @Then("the response status code should be {int}")
	    public void the_response_status_code_should_be(Integer statusCode) {
	        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
	    }

}
