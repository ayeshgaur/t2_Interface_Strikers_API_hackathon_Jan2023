package com.api.hackathon.steps.batch;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Assert;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteBatchStepDef {
	RequestSpecification req;
	RequestSpecification res;
	Response response;
	int id = 584;

	@Given("A Service with URL \\(Delete Batch)")
	public void a_service_with_url_delete_batch() {
		req = new RequestSpecBuilder().setBaseUri("https://lms-backend-service.herokuapp.com/lms/")
				.setContentType(ContentType.JSON).build();
		res = given().spec(req);

	}

	@When("DELETE request is made by passing ID as a parameter")
	public void delete_request_is_made_by_passing_id_as_a_parameter() {
		response = res.when().delete("/batches/" + id).then().extract().response();
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Then("validate the error message")
	public void validate_the_error_message() {
		response.then().log().all().assertThat().statusCode(400).body("errorCode",
				Matchers.equalTo("ENTITY_DOES_NOT_EXIST"));

	}

}
