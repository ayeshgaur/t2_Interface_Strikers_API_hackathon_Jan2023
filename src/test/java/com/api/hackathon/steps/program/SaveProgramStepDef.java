package com.api.hackathon.steps.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SaveProgramStepDef {

    private static final String BASE_URL = "http://lms-backend-service.herokuapp.com/lms/";
    private static Response saveProgramResp;
    private static String jsonString;
    private static String requestPath;
    private static int statusCode;
    RequestSpecification req;
    Response response;

    @Given("A Service with URL Save Program")
    public void a_service_with_save_program() {
        req = new RequestSpecBuilder().setBaseUri(BASE_URL + "/saveprogram").build();
        req = given().spec(req);
    }

    @When("Post request is made with params {string}, {string}, {string}, creationTime, lastModTime are given")
    public void post_request_is_made_with_params_creation_time_last_mod_time_are_given(String programName, String programDescription, String programStatus) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        HashMap<String, Object> dataBody = new HashMap<String, Object>();

        dataBody.put("programName", programName);
        dataBody.put("programDescription", programDescription);
        dataBody.put("programStatus", programStatus);
        dataBody.put("creationDate", dtf.format(now));
        dataBody.put("lastModTime", dtf.format(now));
        response = req.body(JSONObject.toJSONString(dataBody))
                .log()
                .body()
                .when().post();
    }

    @Then("Save Program ID")
    public void save_program_id() {
        String actualProgramId = response.then().extract().asString();
    }

    @Then("Validate {string}, {string}, {string}")
    public void validate(String programName, String programDescription, String programStatus) {
        String actualBody = String.valueOf(response.then().extract().body().asString());
        HashMap<String, Object> dataBody = new HashMap<String, Object>();
        dataBody.get(programName);
        dataBody.get(programDescription);
        dataBody.get(programStatus);
        String expectedBody = String.valueOf(dataBody);
        Assert.assertEquals(expectedBody, actualBody);
    }

    @Then("Validate status code")
    public void validate_status_code() {
        int actualCode = response.then().extract().statusCode();
        Assert.assertEquals(201, actualCode);
    }

    @Given("A Service with URL GET Program by Id")
    public void a_service_with_url_get_program_by_id() {
        req = new RequestSpecBuilder().setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON).build();
        req = given().spec(req);
    }

    @When("GET Request is made")
    public void get_request_is_made() {
        response = req.when().get("/programs/920");
    }

    @Then("Validate the ProgramName, Program Description and Program Status for the given Program ID")
    public void validate_the_program_name_program_description_and_program_status_for_the_given_program_id() {
        // Write code here that turns the phrase above into concrete actions
        response.then().log().all();
    }

    @Then("Validate status code after execution")
    public void validate_status_code_after_execution() {
        int actualCode = response.then().extract().statusCode();
        Assert.assertEquals(200, actualCode);

    }
}