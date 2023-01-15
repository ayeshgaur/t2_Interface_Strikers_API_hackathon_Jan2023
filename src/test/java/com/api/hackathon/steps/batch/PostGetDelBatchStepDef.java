
package com.api.hackathon.steps.batch;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Assert;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostGetDelBatchStepDef {
	RequestSpecification req;
	RequestSpecification res;
	ValidatableResponse response;
	String resBody;
	String resMsg;
	Response response2;
	int id;

	@Given("A Service with URL \\(Create Batch)")
	public void a_service_with_url_create_batch() {
		req = new RequestSpecBuilder().setBaseUri("https://lms-backend-service.herokuapp.com/lms/")
				.setContentType(ContentType.JSON).build();
		res = given().spec(req).log().all();
	}

	@When("POST request is made with parameters at path {string},{string},{string},{string},{string}")
	public void post_request_is_made_with_parameters_at_path(String batchName, String batchDescription,
			String batchStatus, String batchNoOfClasses, String programId) {
		response = (ValidatableResponse)res
				.body("{ \"batchName\": \"" + batchName + "\", \"batchDescription\": \"" + batchDescription
						+ "\", \"batchStatus\": \"" + batchStatus + "\", " + "\"batchNoOfClasses\": \""
						+ batchNoOfClasses + "\"," + " \"programId\": \"" + programId + "\" }")
				.when().post("/batches").then().log().all().assertThat().statusCode(201);

		/*
		 * id = response.extract().path("batchId"); System.out.
		 * println("******************Batch Id created is:**************************" +
		 * id); res.when().get("/batches/batchId/" +
		 * id).then().log().all().assertThat().statusCode(200);
		 * 
		 * res.when().delete("/batches/" +
		 * id).then().assertThat().statusCode(200).log().all().extract().response();
		 */

	}

	@Then("validate the status code")
	public void validate_the_status_code() {

		response.assertThat().statusCode(201);
	}

	@Then("save the batch ID")
	public void save_the_batch_id() {

		id = response.extract().path("batchId");
		System.out.println("******************Batch Id created is:**************************" + id);

	}

	@Then("get the batch details using created batch ID")
	public void get_the_batch_details_using_created_batch_id() {
		System.out.println("Getting batch details based on created ID");
		response2=(Response) res.when().get("/batches/batchId/" + id).then().log().all().assertThat().statusCode(200);
		String r2=response2.asString();
		System.out.println(r2);

	}

	@Then("validate the necessary fields as {string},{string},{string},{string},{string}")
	public void validate_the_necessary_fields_as(String batchName, String batchDescription, String batchStatus,
			String batchNoOfClasses, String programId) {
		response.assertThat().body("batchName", Matchers.is(batchName))
				.body("batchDescription", Matchers.is(batchDescription)).body("batchStatus", Matchers.is(batchStatus))
				.body("batchNoOfClasses", Matchers.is(batchNoOfClasses)).body("programId", Matchers.is(programId));
	}

	@Then("delete the batch Id that is created")
	public void delete_the_batch_id_that_is_created() {

		res.delete("/batches/" + id).then().assertThat().statusCode(200).log().all().extract()
				.response().asString();

	}

	@Then("validate the response message")
	public void validate_the_response_message() {

		//System.out.println("Response Message as :*******" + resMsg);
		//Assert.assertEquals(resMsg.contains("Message: Batch with Id-" + id + " deleted Successfully!"), true);

	}

}
