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
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class CreateAndSaveProgramStepDef {

    private static final String BASE_URL = "http://lms-backend-service.herokuapp.com/lms/";

    RequestSpecification req;
    RequestSpecBuilder respecb;
    Response response;

    @Given("A Service with URL Save Program")
    public void a_service_with_save_program() {
        req = new RequestSpecBuilder().setBaseUri(BASE_URL).setContentType(ContentType.JSON).build();
        req = given().spec(req);
    }

    @When("Post request is made with params {string}, {string}, {string}, creationTime, lastModTime are given")
    public void post_request_is_made_with_params_creation_time_last_mod_time_are_given(String programName, String programDescription, String programStatus) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime now = LocalDateTime.now();
        HashMap<String, Object> dataBody = new HashMap<String, Object>();
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int = rand.nextInt(1000);
        dataBody.put("programName", programName+"_"+rand_int);
        dataBody.put("programDescription", programDescription);
        dataBody.put("programStatus", programStatus);
        dataBody.put("creationTime", dtf.format(now));
        dataBody.put("lastModTime", dtf.format(now));
        response = req.when().body(JSONObject.toJSONString(dataBody)).post("saveprogram");
        System.out.println(response.asString());
    }

    @Then("Save Program ID")
    public void save_program_id() {

        int programId = response.then().extract().path("programId");
        String programName = response.then().extract().path("programName");
        try {

            ConfigReaderWriter.storeConfig("programId", String.valueOf(programId));
            ConfigReaderWriter.storeConfig("programName", programName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("actualProgramId" + programId);
    }

    @Then("Validate  {string}, {string}")
    public void validate( String programDescription, String programStatus) {
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

    @Then("Validate status code")
    public void validate_status_code() {
        int actualCode = response.then().extract().statusCode();
        Assert.assertEquals(201, actualCode);
    }

}