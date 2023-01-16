
package com.api.hackathon.steps.batch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import java.util.HashMap;

public class UpdateBatchStepDef {
	private static final String BASE_URL = "http://lms-backend-service.herokuapp.com/lms/";
	RequestSpecification req;
	RequestSpecification res;
	ValidatableResponse response;

	@Given("A Service with URL Update Batch")
	public void a_service_with_url_update_batch() {
		req = new RequestSpecBuilder().setBaseUri(BASE_URL).setContentType(ContentType.JSON).build();
		res = given().spec(req);
	}

	@When("Put request is made as parameters at Path {string}, {string}, {string}, {string}, {string},{string},{string} are modified")
	public void put_request_is_made_as_parameters_at_path_are_modified(String batchId, String batchName,
			String batchDescription, String batchStatus, String batchNoOfClasses, String programId,
			String programName) {
		HashMap<String, Object> dataBody = new HashMap<String, Object>();

		dataBody.put("batchId", batchId);
		dataBody.put("batchName", batchName);
		dataBody.put("batchDescription", batchDescription);
		dataBody.put("batchStatus", batchStatus);
		dataBody.put("batchNoOfClasses", batchNoOfClasses);
		dataBody.put("programId", programId);
		dataBody.put("programName", programName);
		response = res.when().body(JSONObject.toJSONString(dataBody)).put("/batches/" + batchId).then().log().all();
		// System.out.println(response.asString());
	}

	@Then("Validate status code after update")
	public void validate_status_code_after_update() {
		response.assertThat().statusCode(200);
	}

}
