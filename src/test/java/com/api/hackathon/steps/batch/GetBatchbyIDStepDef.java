package com.api.hackathon.steps.batch;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

import com.api.hackathon.utils.ConfigReaderWriter;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetBatchbyIDStepDef {
	RequestSpecification req;
	RequestSpecification res;
	ValidatableResponse response;
	String resBody;
	String resMsg;
	Response response2;
	int id;

	@Given("A Service with URL \\(Get Batch)")
	public void a_service_with_url_get_batch() {
		req = new RequestSpecBuilder().setBaseUri("https://lms-backend-service.herokuapp.com/lms/")
				.setContentType(ContentType.JSON).build();
		res = given().spec(req).log().all();
	}

	@When("GET request is made all the batch details will be displayed")
	public void get_request_is_made_all_the_batch_details_will_be_displayed() {

		response = res.when().get("/batches").then().log().all();

	}

	@Then("Validate status code as {int}")
	public void validate_status_code_as(Integer int1) {
		response.assertThat().statusCode(int1);
	}

	@When("GET request is made with valid batch ID")
	public void get_request_is_made_with_valid_batch_id() {
		 String batchId = ConfigReaderWriter
	                .loadConfig()
	                .getProperty("batchId");
		response = res.when().get("/batches/batchId/"+ batchId).then().log().all();
		System.out.println("*********Batch ID is:*******" +batchId);

	}

	@When("GET request is made with invalid ID")
	public void get_request_is_made_with_invalid_id() {
		response = res.when().get("/batches/batchId/1000").then().log().all();
	}

	@When("GET request is made with Batch Name")
	public void get_request_is_made_with_batch_name() {
		String batchName = ConfigReaderWriter
                .loadConfig()
                .getProperty("batchName");
		response = res.when().get("/batches/batchName/"+ batchName).then().log().all();
	}

	@When("GET request is made with Program Id")
	public void get_request_is_made_with_program_id() {
		
		response = res.when().get("batches/program/458").then().log().all();
		
		
		//parsing program Id dynamically while running program module
		/*
		 * String programId = ConfigReaderWriter .loadConfig()
		 * .getProperty("programId");
		 * 
		 * 
		 * response = res.when().get("batches/program/"+programId ).then().log().all();
		 */
		
	}

	@Then("Validate status code and error message")
	public void validate_status_code_and_error_message() {

		response.assertThat().statusCode(400).body("errorCode", Matchers.equalTo("ENTITY_DOES_NOT_EXIST"));

	}

}
