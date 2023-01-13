package com.api.hackathon.steps.batch;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.junit.Assert;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class PostandPutBatchStepDef {
	RequestSpecification req;
	  RequestSpecification res;
	 Response response;
	 String resBody;String id;
	 private static String jsonString;
	 JsonPath js;
	 @Given("A Service with URL \\(Create Batch)")
	 public void a_service_with_url_create_batch() {
		 req =new RequestSpecBuilder().setBaseUri("https://lms-backend-service.herokuapp.com/lms/")
					.setContentType(ContentType.JSON).build();
			  res=given().spec(req).log().all();
	 }

	 @When("POST request is made with parameters at path {string},{string},{string},{string},{string}")
	 public void post_request_is_made_with_parameters_at_path(String batchName, String batchDescription, String batchStatus, String batchNoOfClasses, String programId) {
		 response= (Response) res.body("{ \"batchName\": \""+batchName+"\", \"batchDescription\": \""+batchDescription+"\", \"batchStatus\": \""+batchStatus+"\", "
					+ "\"batchNoOfClasses\": \""+batchNoOfClasses+"\","
					+ " \"programId\": \""+programId+"\" }"). when().post("/batches");
				 //.then().log().all().assertThat().statusCode(201);
			
	 }


@Then("validate the status code")
public void validate_the_status_code() {
	Assert.assertEquals(response.getStatusCode(), 201);
	
	    //res.when().delete("/batches/"+id);
}
@Then("save the batch ID")
public void save_the_batch_id() {
	//String resBody=response.then().assertThat().statusCode(201).log().all().extract().response().asString();
	response.then().assertThat().statusCode(201).log().all().extract().response().asString();
	/*
	 * jsonString=response.asString(); js=new JsonPath(resBody);
	 * id=js.getString("batchId"); given().when().delete("/batches/"+id);
	 */
	
	   
	 
}
/*
 * @Given("Provide the BatchID to be deleted") public void
 * provide_the_batch_id_to_be_deleted() { //res=given().spec(req).log().all();
 * //JsonPath js=new JsonPath(resBody); //String id=js.getString("batchId"); }
 */

/*
 * @When("DELETE request is made") public void delete_request_is_made() {
 * //res.when().delete("/batches/"+id); }
 */

/*
 * @Given("A Service with URL \\(Get Batch)") public void
 * a_service_with_url_get_batch() { //res=given().spec(req).log().all(); }
 * 
 * @When("GET request is made") public void get_request_is_made() { //
 * response=(Response) res.when().get("/batches/batchId/"+
 * id).then().log().all().assertThat().statusCode(200); }
 */

}
