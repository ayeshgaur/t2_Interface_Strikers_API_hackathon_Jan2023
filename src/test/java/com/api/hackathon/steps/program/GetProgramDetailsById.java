package com.api.hackathon.steps.program;

import com.api.hackathon.utils.ConfigReaderWriter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class GetProgramDetailsById {

    private static final String BASE_URL = "http://lms-backend-service.herokuapp.com/lms/";
    RequestSpecification req;
    Response response;

    @Given("A Service with URL GET Program by Id")
    public void a_service_with_url_get_program_by_id() {
        req = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
        req = given().spec(req);
    }

    @When("GET Request is made with programID")
    public void get_request_is_made_with_programID() {
        String programId = ConfigReaderWriter
                .loadConfig()
                .getProperty("programId");

        response = req.when().get("/programs/"+ programId);
        System.out.println("programId"+ programId);
    }

    @Then("Validate fields {string}, {string}")
    public void validate ( String programDescription, String programStatus) {
        String programName = ConfigReaderWriter
                .loadConfig()
                .getProperty("programName");
        response.then()
                .assertThat()
                .body("programName", Matchers.is(programName))
                .body("programDescription", Matchers.is(programDescription))
                .body("programStatus", Matchers.is(programStatus))
                .log().all();
    }

    @Then("Validate status code after execution")
    public void validate_status_code_after_execution() {
        int actualCode = response.then().extract().statusCode();
        Assert.assertEquals(200, actualCode);

    }
}

