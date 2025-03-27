package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import requestBuilder.ClassRequest;
import requestBuilder.CommonRequest;
import requestBuilder.LoginandLogoutRequest;
import common.ExcelReader;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginandLogout_Step {
    private RequestSpecification requestSpecification;
    private Response response;
    private LoginandLogoutRequest loginRequestandlogout;
    private CommonRequest commonRequest;

    
    public LoginandLogout_Step() {
      
        this.loginRequestandlogout = new LoginandLogoutRequest(); // Use the testContext here
        this.commonRequest = new CommonRequest();
    }

    @Given("The Admin creates POST request for login")
    public void the_admin_creates_post_request_for_login() {
        requestSpecification = loginRequestandlogout.setRequestSpecification();
    }
// TC_01_login Valid Credentials
    
    @When("The Admin sends HTTPS POST request for valid credentials scenarios as input {string} and {string}")
    public void the_admin_sends_https_post_request_for_valid_credentials_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
    	loginRequestandlogout.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequestandlogout.getResponse();
    }

    @Then("The Admin get valid credentials response code and message as {string} and {string}")
    public void the_admin_get_valid_credentials_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
        this.response = loginRequestandlogout.getResponse();
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
    	loginRequestandlogout.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequestandlogout.getResponse();
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
    	loginRequestandlogout.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequestandlogout.getResponse();
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
    	loginRequestandlogout.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequestandlogout.getResponse();
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
    	loginRequestandlogout.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequestandlogout.getResponse();
        
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
    	loginRequestandlogout.loginPost(sheetName, testCaseID, requestSpecification);
        this.response = loginRequestandlogout.getResponse();
       
    }

    @Then("The Admin get empty password response code and message as {string} and {string}")
    public void the_admin_get_empty_password_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
    	 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
         commonRequest.validateStatusCode(response, testData);
         commonRequest.validateStatusLine(response, testData);
         commonRequest.validateResponseTime(response);
          
    } 
  //-------------------------------------------------------------------------------------------------------------------------------------------------
    //TC_01_logout Invalid Endpoint  

	   @When("The Admin sends HTTPS GET request for Invalid Endpoint scenarios as input {string} and {string}")
	   public void the_admin_sends_https_get_request_for_invalid_endpoint_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		   loginRequestandlogout.logoutGet(sheetName, testCaseID, requestSpecification);
	        this.response = loginRequestandlogout.getResponse();	 
	  }
	   
	   @Then("The Admin gets response code and message as {string} and {string} for logout")
	   public void the_admin_gets_response_code_and_message_as_and_for_logout(String sheetName, String testCaseID) throws IOException {
		   Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	         commonRequest.validateStatusCode(response, testData);
	         commonRequest.validateStatusLine(response, testData);
	         commonRequest.validateResponseTime(response);
	   }
	 //-------------------------------------------------------------------------------------------------------------------------------------------------
	    //TC_02_logout valid Successfull
	   

	   @When("The Admin sends HTTPS GET request for logout as {string} and {string}")
	   public void the_admin_sends_https_get_request_for_logout_as_and(String sheetName, String testCaseID) throws IOException {
		   loginRequestandlogout.logoutGet(sheetName, testCaseID, requestSpecification);
	        this.response = loginRequestandlogout.getResponse();
		  }

	  @Then("The Admin gets response code and message as {string} and {string} for successfull logout")
	   public void the_admin_gets_response_code_and_message_as_and_for_successfull_logout(String sheetName, String testCaseID) throws IOException {
		   Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	        commonRequest.validateStatusCode(response, testData);
	        commonRequest.validateStatusLine(response, testData);
	        commonRequest.validateResponseTime(response);
	       
		   
}
	  
	  //Logout Noauth
	  @Given("Admin is on base url with no auth")
	  public void admin_is_on_base_url_with_no_auth() {
	  	RequestSpecification invalidRequestSpecifications= commonRequest.basewithNoauth();
	  	 TestContext.setRequestSpecification("invalidRequestSpecification", invalidRequestSpecifications);
	  	 
	  }
	  @When("The Admin sends HTTPS GET request for logout as {string} and {string} for no auth")
			  public void the_admin_sends_https_get_request_for_logout_as_and_for_no_auth(String sheetName, String testCaseID) throws IOException {
		  loginRequestandlogout.logoutGet(sheetName, testCaseID, requestSpecification);
	        this.response = loginRequestandlogout.getResponse();
		   
		}
		
		@Then("The Admin gets response code and message as {string} and {string} for logout for no auth")
		public void the_admin_gets_response_code_and_message_as_and_for_logout_for_no_auth(String sheetName, String testCaseID) throws IOException {
			 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		        commonRequest.validateStatusCode(response, testData);
		        commonRequest.validateStatusLine(response, testData);
		   
		}
		
		
		}
















