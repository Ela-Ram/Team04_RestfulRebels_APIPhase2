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

public class Cleanup_Step {
	
	private RequestSpecification requestSpecification;
    private Response response;
    private ClassRequest classRequest;
    private CommonRequest commonRequest;

	
	public Cleanup_Step() {
        this.classRequest = new ClassRequest(); 
        this.commonRequest = new CommonRequest();
    }
	
	
	
	@When("The Admin sends HTTPS DELETE request to clean up classid")
	public void the_admin_sends_https_delete_request_to_clean_up_classid() {
		String key = "csId_list"; 

        // Call the cleanupClass method to clean up the class IDs
		 classRequest.cleanupClass(key);
		 Utils.remove("csId");
	   
	}
	
	@Then("The Admin gets suceess code")
	public void the_admin_gets_suceess_code() {
		int actualStatusCode = response.getStatusCode();
	    Assert.assertEquals(actualStatusCode, 200, "Expected status code 200, but got: " + actualStatusCode);

	}


		
	
	
	
	
	
	
	
	
	

}
