package com.api.hackathon.steps.program;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SaveProgramStepDef {

    private static final String BASE_URL = "http://lms-backend-service.herokuapp.com/lms/";
    private static Response saveProgramResp;

    private static String jsonString;

    private static String requestPath;

    private static int statusCode;


    @Given("A Service with URL \\(Save Program)")
    public void a_service_with_url_save_program() {

        // declare Base URI
        RestAssured.baseURI = BASE_URL;

        // Add Given from rest assured
        RequestSpecification request = RestAssured.given();
        // Request Path Set
         requestPath = "/saveprogram";
        // Prepare JSON Request Body

        //Add Save program End point or URI Path
        saveProgramResp = request.get(requestPath);



        statusCode = saveProgramResp.getStatusCode();
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
