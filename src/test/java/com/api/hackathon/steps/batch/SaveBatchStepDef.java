package com.api.hackathon.steps.batch;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

public class SaveBatchStepDef {
	RequestSpecification req;
	RequestSpecification res;
	ValidatableResponse response;
	String resBody;
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
		HashMap<String, Object> dataBody = new HashMap<String, Object>();

		dataBody.put("batchName", batchName);
		dataBody.put("batchDescription", batchDescription);
		dataBody.put("batchStatus", batchStatus);
		dataBody.put("batchNoOfClasses", batchNoOfClasses);
		dataBody.put("programId", programId);
		response = res.when().body(JSONObject.toJSONString(dataBody)).post("/batches").then().log().all();

	}

	@Then("save BatchID")
	public void save_batch_id() {
		id = response.extract().path("batchId");

		System.out.println("***************Batch ID created is :********" + id);

	}

	@Then("validate the necessary fields {string},{string}")
	public void validate_the_necessary_fields(String batchName, String batchStatus) {
		response.assertThat().body("batchName", Matchers.is(batchName)).body("batchStatus", Matchers.is(batchStatus))
				.log().all();
	}

	@Then("Validate status code for successful batch creation as {int}")
	public void validate_status_code_for_successful_batch_creation_as(Integer int1) {
		response.assertThat().statusCode(int1);
	}

	@Then("get the batch created using the batchID and validate the status code")
	public void get_the_batch_created_using_the_batch_id_and_validate_the_status_code() {
		System.out.println("***********Get request is sent******************");
		res.when().get("/batches/batchId/" + id).then().assertThat().statusCode(200).log().all();
	}

	@Then("delete the batch created  and validate the status code")
	public void delete_the_batch_created_and_validate_the_status_code() {
		System.out.println("**************Delete request is sent************************");
		res.when().delete("/batches/" + id).then().log().all().extract().response();
	}

}
