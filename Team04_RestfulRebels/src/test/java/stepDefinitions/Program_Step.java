package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import requestBuilder.CommonRequest;
import requestBuilder.LoginandLogoutRequest;
import requestBuilder.ProgramRequest;
import common.ExcelReader;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Program_Step {
    private RequestSpecification requestSpecification;
    private Response response;
    private CommonRequest commonRequest;
    private ProgramRequest programRequest;
    private LoginandLogoutRequest loginRequest;
    
    public Program_Step() {
  
        this.commonRequest = new CommonRequest();
        this.programRequest = new ProgramRequest();
        this.loginRequest = new LoginandLogoutRequest();
    }

    
    @Given("Admin is on base url with valid auth")
    public void admin_is_on_base_url_with_valid_auth() {
    	
    	RequestSpecification validRequestSpecification= commonRequest.basewithValidauth();
    //	TestContext.setRequestSpecification(requestSpecification);
        TestContext.setRequestSpecification("validRequestSpecification", validRequestSpecification);

    }

    @When("The Admin sends HTTPS POST request for valid data scenarios as input {string} and {string} for Program")
    public void the_admin_sends_https_post_request_for_valid_data_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    	
    	programRequest.programPost(sheetName, testCaseID, requestSpecification);
        this.response = programRequest.getResponse(); // Capture response for validations
       
    }

    @Then("The Admin get valid data response code and message as {string} and {string} for Program")
    public void the_admin_get_valid_data_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
    	 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
         commonRequest.validateStatusCode(response, testData);

       
    }

@When("The Admin sends HTTPS POST request for invalid endpoint scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_post_request_for_invalid_endpoint_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.programPost(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); // Capture response for validations
}

@Then("The Admin get invalid endpoint response code and message as {string} and {string} for Program")
public void the_admin_get_invalid_endpoint_response_code_and_message_as_and_for_program(String string, String string2) {
    
}

    
    
    
 
    }
