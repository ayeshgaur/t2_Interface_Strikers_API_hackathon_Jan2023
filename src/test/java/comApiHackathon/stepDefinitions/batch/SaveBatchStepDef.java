package comApiHackathon.stepDefinitions.batch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;

public class SaveBatchStepDef {
	
	@Given("A Service with URL \\(Save Batch)")
	public void a_service_with_url_save_batch() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2"). //specify the end point
		then().
			statusCode(200). //verify if status code is 200
			
		
		throw new io.cucumber.java.PendingException();
	}

	@When("{string} are created with reference to programId")
	public void are_created_with_reference_to_program_id(String string) {

		
		throw new io.cucumber.java.PendingException();
	}

	@When("{string} request is made")
	public void request_is_made(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Save {string}")
	public void save(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Validate status code")
	public void validate_status_code() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Validate {string}")
	public void validate(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("A Service with {string} \\(batch by Id)")
	public void a_service_with_batch_by_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
