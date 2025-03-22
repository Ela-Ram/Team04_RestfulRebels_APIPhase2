package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import common.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBuilder.ClassRequest;
import requestBuilder.CommonRequest;

public class Class_Step {
	private RequestSpecification requestSpecification;
    private Response response;
    private ClassRequest classRequest;
    private CommonRequest commonRequest;
    
	public Class_Step() {
        this.classRequest = new ClassRequest(); 
        this.commonRequest = new CommonRequest();
    }

	
	

	

@When("The Admin sends HTTPS POST request for valid data scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_valid_data_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();
    
}

@Then("The Admin get valid data response code and message as {string} and {string} for Class")
public void the_admin_get_valid_data_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
     commonRequest.validateStatusCode(response, testData);
     
    
}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
