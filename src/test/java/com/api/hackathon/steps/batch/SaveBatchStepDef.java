package com.api.hackathon.steps.batch;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import com.api.hackathon.utils.ConfigReaderWriter;

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
		 // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int = rand.nextInt(1000);
        
		dataBody.put("batchName", batchName+"_"+rand_int);
		dataBody.put("batchDescription", batchDescription);
		dataBody.put("batchStatus", batchStatus);
		dataBody.put("batchNoOfClasses", batchNoOfClasses);
		dataBody.put("programId", programId);
		response = res.when().body(JSONObject.toJSONString(dataBody)).post("/batches").then().log().all();

	}

	@Then("save BatchID")
	public void save_batch_id() {
		int batchid = response.extract().path("batchId");

		System.out.println("***************Batch ID created is :********" + batchid);

		String batchName = response.extract().path("batchName");
        try {

            ConfigReaderWriter.storeConfig("batchId", String.valueOf(batchid));
            ConfigReaderWriter.storeConfig("batchName", batchName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("actualbatchId" + id);
	}

	@Then("validate the necessary fields {string},{string}")
	public void validate_the_necessary_fields(String batchDescription, String batchStatus) {
		response.assertThat().body("batchDescription", Matchers.is(batchDescription)).body("batchStatus", Matchers.is(batchStatus))
				.log().all();
	}

	@Then("Validate status code for successful batch creation as {int}")
	public void validate_status_code_for_successful_batch_creation_as(Integer int1) {
		response.assertThat().statusCode(int1);
	}

	

}
