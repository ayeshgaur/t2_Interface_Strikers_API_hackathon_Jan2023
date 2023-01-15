package com.api.hackathon.steps.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UpdateProgramByProgramName {
    private static final String BASE_URL = "http://lms-backend-service.herokuapp.com/lms/";
    RequestSpecification req;
    Response response;

    @Given("A Service with Url Update Program")
    public void a_service_with_url_update_program() {
            req = new RequestSpecBuilder().setBaseUri(BASE_URL).setContentType(ContentType.JSON).build();
            req = given().spec(req);
    }

    @When("PUT request is made after updating any of the fields {string}, {string}, {string} with programName as a parameter")
    public void put_request_is_made_after_updating_any_of_the_fields_with_program_name_as_a_parameter(String programName, String programDescription, String programStatus) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime now = LocalDateTime.now();
        HashMap<String, Object> dataBody = new HashMap<String, Object>();

        dataBody.put("programName", programName);
        dataBody.put("programDescription", programDescription);
        dataBody.put("programStatus", programStatus);
        dataBody.put("creationTime", dtf.format(now));
        dataBody.put("lastModTime", dtf.format(now));
        response = req.when().body(JSONObject.toJSONString(dataBody)).put("program/Jan190545-InterfaceStrikers-SDAT6090");
        System.out.println(response.asString());
    }

    @Then("Validate {string}, {string}")
    public void validate(String programName, String programStatus) {
        response.then()
                .assertThat()
                .body("programName", Matchers.is(programName))
                .body("programStatus", Matchers.is(programStatus))
                .log().all();
    }
    @Then("Validate status code after update by programName")
    public void validate_status_code_after_update_by_program_name() {
        int actualCode = response.then().extract().statusCode();
        Assert.assertEquals(200, actualCode);
    }
}
