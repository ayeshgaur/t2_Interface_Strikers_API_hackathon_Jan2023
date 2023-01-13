package comApiHackathon.stepDefinitions.program;

import io.cucumber.java.en.*;

import io.restassured.RestAssured;

public class SaveProgramStepDef {

    private static final String BASE_URL = "http://lms-backend-service.herokuapp.com/lms/";

    @Given("A Service with URL \\(Save Program)")
    public void a_service_with_url_save_program() {
        RestAssured.baseURI = BASE_URL;
        throw new io.cucumber.java.PendingException();
    }

    @Given("Request body at {string}")
    public void request_body_at(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("{string} are modified")
    public void are_modified(String string) {
        // Write code here that turns the phrase above into concrete actions
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

    @Given("A Service with {string} \\(GET Program by Id)")
    public void a_service_with_get_program_by_id(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
