package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import requestBuilder.CommonRequest;
import requestBuilder.UserRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;

import common.ExcelReader;



public class User_Step {
	private RequestSpecification requestSpecification;
    private Response response;
    private UserRequest userRequest;
    private CommonRequest commonRequest;
	
	public User_Step() {
        this.userRequest = new UserRequest(); 
        this.commonRequest = new CommonRequest();
    }

@When("The Admin sends HTTPS POST request for valid data scenarios as input {string} and {string} for User")
public void the_admin_sends_https_post_request_for_valid_data_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	
	userRequest.userPost(sheetName, testCaseID, requestSpecification);
	 this.response = userRequest.getResponse();  
}

@Then("The Admin get valid data response code and message as {string} and {string} for User")
public void the_admin_get_valid_data_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) {
    
}

	
	
	
	
	
	
	
	
	

}
