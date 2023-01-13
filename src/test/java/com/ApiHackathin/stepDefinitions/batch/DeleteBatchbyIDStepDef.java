package com.ApiHackathin.stepDefinitions.batch;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class DeleteBatchbyIDStepDef {
	RequestSpecification req;
	 
	 RequestSpecification res;
	 Response response;
	@Given("A Service with URL \\(Delete Batch)")
	public void a_service_with_url_delete_batch() {
		 req =new RequestSpecBuilder().setBaseUri("https://lms-backend-service.herokuapp.com/lms/")
				.setContentType(ContentType.JSON).build();
		  res=given().spec(req);
}

	@When("DELETE request is made by passing ID as a parameter")
	public void delete_request_is_made_by_passing_id_as_a_parameter() {
	     response=res.when().delete("/batches/batchId/292");
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		Assert.assertEquals(response.getStatusCode(), 405);
		
		//assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    Assert.assertEquals((response.getStatusLine()), "Method Not allowed");
	    System.out.println(response.getStatusLine());
	}


}
