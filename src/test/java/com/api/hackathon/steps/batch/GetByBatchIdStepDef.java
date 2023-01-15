package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.*;

import org.junit.Assert;


public class GetByBatchIdStepDef {
	
	
	RequestSpecification req;
	Response res;
	
	@Given("a service with baseURI {string}")
	public void a_service_with_base_url_to_fetch_batch_by_id(String baseURI) {
		System.out.println("baseURI: "+baseURI);
		req = new RequestSpecBuilder()
				.setBaseUri(baseURI)
				.setContentType(ContentType.JSON).build();
	    
	}

	@When("^get by batch id request is made with endpoint (.*?) and batch id (.*?)$")
	public void get_by_batch_id_request_is_made(String endpoint, String batchId) {
	    
		String uri = endpoint.replaceAll("\"", "").concat(batchId.toString());
		res=given().spec(req).when().get(uri);
	}

	@Then("validate response status code")
	public void validate_response_status_code() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.getBody().asString());
	}

	@Then("^validate response body (.*?), (.*?), (.*?), (\\d+), (\\d+)$")
	public void validate_response_body(String batchName, String batchDesc, String batchStatus, Integer batchNoOfClasses, Integer programId) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		res.then().body("batchName", equalTo(batchName));
		res.then().body("batchDescription", equalTo(batchDesc));
		res.then().body("batchStatus", equalTo(batchStatus));
		res.then().body("batchNoOfClasses", equalTo(batchNoOfClasses));
		res.then().body("programId", equalTo(programId));
		//Assert.assertEquals(res.body(), 200);
	}

	
	
}
