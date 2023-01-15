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

public class GetProgramDetailsById {

    private static final String BASE_URL = "http://lms-backend-service.herokuapp.com/lms/";
    private static Response saveProgramResp;
    private static String jsonString;
    private static String requestPath;
    private static int statusCode;
    RequestSpecification req;
    Response response;

    @Given("A Service with URL GET Program by Id")
    public void a_service_with_url_get_program_by_id() {
        req = new RequestSpecBuilder().setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON).build();
        req = given().spec(req);
    }

    @When("GET Request is made with programID")
    public void get_request_is_made_with_programID() {

        response = req.when().get("/programs/2567");
    }

    @Then("Validate the ProgramName, Program Description and Program Status for the given Program ID")
    public void validate_the_program_name_program_description_and_program_status_for_the_given_program_id() {

        response.then().log().all();
    }

    @Then("Validate status code after execution")
    public void validate_status_code_after_execution() {
        int actualCode = response.then().extract().statusCode();
        Assert.assertEquals(200, actualCode);

    }
}

