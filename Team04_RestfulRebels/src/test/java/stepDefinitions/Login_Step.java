package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import requestBuilder.ClassRequest;
import requestBuilder.CommonRequest;
import requestBuilder.LoginRequest;
import common.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login_Step {
    private RequestSpecification requestSpecification;
    private Response response;
    private LoginRequest loginRequest;
    private CommonRequest commonRequest;

    
    public Login_Step() {
      
        this.loginRequest = new LoginRequest(); // Use the testContext here
        this.commonRequest = new CommonRequest();
    }

    @Given("The Admin creates POST request for login")
    public void the_admin_creates_post_request_for_login() {
        requestSpecification = loginRequest.setRequestSpecification();
    }
// TC_01_login Valid Credentials
    
    @When("The Admin sends HTTPS POST request for valid credentials scenarios as input {string} and {string}")
    public void the_admin_sends_https_post_request_for_valid_credentials_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
        loginRequest.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequest.getResponse();
    }

    @Then("The Admin get valid credentials response code and message as {string} and {string}")
    public void the_admin_get_valid_credentials_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
        this.response = loginRequest.getResponse();
        String token = response.jsonPath().getString("token");
        commonRequest.validateStatusCode(response, testData);
        commonRequest.validateStatusLine(response, testData);
        commonRequest.validateContentType(response, testData);
        commonRequest.validateResponseTime(response);
        commonRequest.validateSchema(response, "Schema/Login/LoginSchema.json");
        Assert.assertFalse(token.trim().isEmpty(), "Token should not be empty");
        
         }
//-------------------------------------------------------------------------------------------------------------------------------------------------
    //TC_02_login Invalid Username
    
    @When("The Admin sends HTTPS POST request for invalid username scenarios as input {string} and {string}")
    public void the_admin_sends_https_post_request_for_invalid_username_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
        loginRequest.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequest.getResponse();
    }

    @Then("The Admin get invalid username response code and message as {string} and {string}")
    public void the_admin_get_invalid_username_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
        commonRequest.validateStatusCode(response, testData);
        commonRequest.validateStatusLine(response, testData);
        commonRequest.validateResponseTime(response);
        commonRequest.validateErrorMessage(response, testData);
    }
  //-------------------------------------------------------------------------------------------------------------------------------------------------
    //TC_03_login Invalid Password
    
    @When("The Admin sends HTTPS POST request for invalid password scenarios as input {string} and {string}")
    public void the_admin_sends_https_post_request_for_invalid_password_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
        loginRequest.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequest.getResponse();
    }

    @Then("The Admin get invalid password response code and message as {string} and {string}")
    public void the_admin_get_invalid_password_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
        commonRequest.validateStatusCode(response, testData);
        commonRequest.validateStatusLine(response, testData);
        commonRequest.validateResponseTime(response);
        commonRequest.validateErrorMessage(response, testData);
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    // TC_04_login Invalid Endpoint
    
    @When("The Admin sends HTTPS POST request for invalid Endpoint scenarios as input {string} and {string}")
    public void the_admin_sends_https_post_request_for_invalid_endpoint_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
        loginRequest.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequest.getResponse();
    }

    @Then("The Admin get invalid Endpoint response code and message as {string} and {string}")
    public void the_admin_get_invalid_endpoint_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
        commonRequest.validateStatusCode(response, testData);
        commonRequest.validateStatusLine(response, testData);
        commonRequest.validateResponseTime(response);
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    // TC_05_login empty username
    
    @When("The Admin sends HTTPS POST request for empty username scenarios as input {string} and {string}")
    public void the_admin_sends_https_post_request_for_empty_username_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
    	loginRequest.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequest.getResponse();
        
    }

    @Then("The Admin get empty username response code and message as {string} and {string}")
    public void the_admin_get_empty_username_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
    	  Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
          commonRequest.validateStatusCode(response, testData);
          commonRequest.validateStatusLine(response, testData);
          commonRequest.validateResponseTime(response);
          commonRequest.validateErrorMessage(response, testData);  
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    //TC_06_login empty Password
    @When("The Admin sends HTTPS POST request for empty password scenarios as input {string} and {string}")
    public void the_admin_sends_https_post_request_for_empty_password_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
    	loginRequest.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequest.getResponse();
       
    }

    @Then("The Admin get empty password response code and message as {string} and {string}")
    public void the_admin_get_empty_password_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
    	 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
         commonRequest.validateStatusCode(response, testData);
         commonRequest.validateStatusLine(response, testData);
         commonRequest.validateResponseTime(response);
          
    }  
}
















