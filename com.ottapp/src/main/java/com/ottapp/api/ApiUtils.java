package com.ottapp.api;


public class ApiUtils {

	    public static Response getRequest(String url) {
	        return given()
	                .when()
	                .get(url)
	                .then()
	                .extract()
	                .response();
	    }

	    public static Response postRequest(String url, Object body) {
	        return given()
	                .contentType("application/json")
	                .body(body)
	                .when()
	                .post(url)
	                .then()
	                .extract()
	                .response();
	    }
	}
