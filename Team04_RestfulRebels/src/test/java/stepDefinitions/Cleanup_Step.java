package stepDefinitions;

import org.testng.Assert;

import common.LoggerLoad;
import common.Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBuilder.ClassRequest;
import requestBuilder.CommonRequest;
import requestBuilder.ProgramRequest;
import requestBuilder.UserRequest;

public class Cleanup_Step {
	
	private RequestSpecification requestSpecification;
    private Response response;
    private ClassRequest classRequest;
    private CommonRequest commonRequest;
    private ProgramRequest programRequest;
    private UserRequest userRequest;
	
	public Cleanup_Step() {
        this.classRequest = new ClassRequest(); 
        this.commonRequest = new CommonRequest();
        this.programRequest = new ProgramRequest();
        this.userRequest = new UserRequest();
    }

	
	@When("The Admin sends HTTPS DELETE request to clean up classid")
	public void the_admin_sends_https_delete_request_to_clean_up_classid() {
		String key = "csId_list"; 
			
        // Call the cleanupClass method to clean up the class IDs
		 classRequest.cleanupClass(key);
		 Utils.remove("csId");
		 this.response = classRequest.getResponse();
	   
	}
	
	@Then("The Admin gets success code")
	public void the_admin_gets_success_code() {
	    if (response == null) {
	        LoggerLoad.error("Response is null. API call might have failed or was never executed.");
	        throw new AssertionError("Response is null - cannot assert status code.");
	    }

	    int actualStatusCode = response.getStatusCode();
	    LoggerLoad.info("Received Status Code: " + actualStatusCode);
	    Assert.assertEquals(actualStatusCode, 200, "Expected status code 200, but got: " + actualStatusCode);
	}


	@When("The Admin sends HTTPS DELETE request to clean up programid")
	public void the_admin_sends_https_delete_request_to_clean_up_programid() {
		String endpoint = enumPackage.Endpoint.Program_DELETE_byProgramId.getPath() + "{programid}";
		programRequest.cleanupPrograms("programId_list", "programid", endpoint);
		Utils.remove("programName");
		Utils.remove("programId");
		 this.response = programRequest.getResponse();
	}

	
	@When("The Admin sends HTTPS DELETE request to clean up userid")
	public void the_admin_sends_https_delete_request_to_clean_up_userid() {
		String key = "userId_list"; 
		
        // Call the cleanupUser method to clean up the user IDs
		 userRequest.cleanupUser(key);
		 Utils.remove("userId");
		 this.response = userRequest.getResponse();
	   
	}
		
	
	
	
	
	
	
	
	
	

}
