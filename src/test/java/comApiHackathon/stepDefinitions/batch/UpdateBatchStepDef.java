package comApiHackathon.stepDefinitions.batch;

import io.restassured.RestAssured;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class UpdateBatchStepDef
{
	RequestSpecification req;
	RequestSpecification res;
	Response response;
	Response response1;

@Given("A Service URL with URI path")
public void a_service_url_with()
{
	req = new RequestSpecBuilder()
			.setBaseUri("http://lms-backend-service.herokuapp.com/lms/")
			.setContentType(ContentType.JSON).build();
	res = RestAssured.given()
			.spec(req)
			.log()
			.all();
}

@When ("Put request is made as parameters at Path {string}, {string}, {string}, {string}, {string},{string},{string} are modified")
public void are_modified(String batchId, String batchName, String batchDescription, String batchStatus, String batchNoOfClasses, String programId, String programName)
{
	response = (Response) res.body("{\"batchId\":\"     "+batchId+"\",\"batchName\":\""+ batchName + "\", \"batchDescription\": \"" + batchDescription + "\",         \"batchStatus\": \"" +batchStatus+     "\",\"batchNoOfClasses\": \" " +batchNoOfClasses+"\", \"programId\": \" " +programId+ "\",           \"programName\":\" "          +programName+ "\"}").when().put("/batches/788");
	System.out.println("before");
	response.body().print();
	System.out.println("after");

}

@Then("Validate response status code")
public void validate_response_status_code()
{
     System.out.println("The response code - " +response
    		 .getStatusCode());
     Assert.assertEquals(response
    		 .getStatusCode(),200);
     if(response.getStatusCode()==200)
     {
    	 System.out.println("Your update is successful");
     }
 }

@Then("Validate {string}, {string}, {string}, {string}, {string},{string},{string}")
public void validate(String batchId, String batchName, String batchDescription, String batchStatus, String batchNoOfClasses, String programId, String programName)
{
	
	System.out.println("The batch name in my response is "+ response1.asString());
 //response.then().
// assertThat()
// 				//.body(("batchId") ,Matchers.is(bId))
//		     .body(("batchName") ,Matchers.equalTo(bname))
//		     .body("batchDescription" ,Matchers.equalTo(bdesc))
//		     .body("batchStatus" ,Matchers.equalTo(bstatus))
//		     //.body("batchNoOfClasses" ,Matchers.equalTo(bNoOfClasses))
//		     //.body("programId" ,Matchers.equalTo(progId))
//		     .body("programName" ,Matchers.equalTo(progName)).log().all();
// 


}

}
 