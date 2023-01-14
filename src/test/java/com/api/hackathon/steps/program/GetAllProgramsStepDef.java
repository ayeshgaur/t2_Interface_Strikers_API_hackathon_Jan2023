package com.api.hackathon.steps.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class GetAllProgramsStepDef {
    private static final String BASE_URL = "http://lms-backend-service.herokuapp.com/lms/";
    private static Response saveProgramResp;
    private static String jsonString;
    private static String requestPath;
    private static int statusCode;
    RequestSpecification req;
    Response response;

    @Given("A a Service with {string}")
    public void a_a_service_with(String string) {
        req = new RequestSpecBuilder().setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON).build();
        req = given().spec(req);
    }
    @Given("Request is sent to extract the program body of the already created programs")
    public void request_is_sent_to_extract_the_program_body_of_the_already_created_programs() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("GET Request is made")
    public void get_request_is_made() {
      //  response = req.when().get("/allPrograms);
    }

    @Then("Validate status code for getting all programs")
    public void validate_status_code_for_getting_all_programs() {
        int actualCode = response.then().extract().statusCode();
        Assert.assertEquals(200, actualCode);
    }
}