package stepDefinitions;

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
		final String CSID_LIST_KEY = "csId_list";
		classRequest.deleteClassforcleanup(CSID_LIST_KEY);
	   
	}

	@Then("The Admin gets {int} {string}")
	public void the_admin_gets(Integer int1, String string) {
	    
	}

	
	
	
	
	
	
	
	
	
	
	

}
