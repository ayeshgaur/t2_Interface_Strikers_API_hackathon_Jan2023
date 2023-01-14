package com.api.hackathon.steps.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;

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
        req = new RequestSpecBuilder().setBaseUri(BASE_URL).setContentType(ContentType.JSON).build();
        req = given().spec(req);
    }

    @When("Post request is made with params {string}, {string}, {string}, creationTime, lastModTime are given")
    public void post_request_is_made_with_params_creation_time_last_mod_time_are_given(String programName, String programDescription, String programStatus) {
       //2023-01-14T18:05:15.391Z
//        SimpleDateFormat dtf = new SimpleDateFormat(
//                "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime now = LocalDateTime.now();
        HashMap<String, Object> dataBody = new HashMap<String, Object>();

        dataBody.put("programName", programName);
        dataBody.put("programDescription", programDescription);
        dataBody.put("programStatus", programStatus);
        dataBody.put("creationTime", dtf.format(now));
        dataBody.put("lastModTime", dtf.format(now));
        response = req.when().body(JSONObject.toJSONString(dataBody)).post("saveprogram");
        System.out.println(response.asString());
    }

    @Then("Save Program ID")
    public void save_program_id() {

        String actualProgramId = response.then().extract().body().asString();

    }

    @Then("Validate {string}, {string}, {string}")
    public void validate(String programName, String programDescription, String programStatus) {

        response.then()
                .assertThat()
                .body("programName", Matchers.is(programName))
                .body("programDescription", Matchers.is(programDescription))
                .body("programStatus", Matchers.is(programStatus))
                .log().all();

    }

    @Then("Validate status code")
    public void validate_status_code() {
        int actualCode = response.then().extract().statusCode();
        Assert.assertEquals(201, actualCode);
    }

}