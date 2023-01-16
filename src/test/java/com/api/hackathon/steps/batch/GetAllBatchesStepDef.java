package com.api.hackathon.steps.batch;

import io.cucumber.java.en.Given;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
public class GetAllBatchesStepDef {

	private static final String BASE_URL = "http://lms-backend-service.herokuapp.com/lms/";
	RequestSpecification req;
	Response response;

	@Given("A Service URL")
	public void a_service_url()
	{
		req = new RequestSpecBuilder().setBaseUri(BASE_URL)
	            .setContentType(ContentType.JSON)
	            .build()
	            .log()
	            .all();
	    req = given().spec(req);

	}

	@When("Get request is made")
	public void get_request_is_made()
	{
		response= req.when().get("/batches");
	    response.body().print();

	}

	@Then("Status Code Validation")
	public void validate_response_status_code_received()
	{
		int actualCode = response.then().extract().statusCode();
	    Assert.assertEquals(200, actualCode);
	    }

	}


