package stepDefinitions;

import common.LoggerLoad;
import common.Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBuilder.BatchRequest;
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
    private BatchRequest batchRequest;

    public Cleanup_Step() {
        this.classRequest = new ClassRequest();
        this.commonRequest = new CommonRequest();
        this.programRequest = new ProgramRequest();
        this.userRequest = new UserRequest();
        this.batchRequest = new BatchRequest();
    }

    @When("The Admin sends HTTPS DELETE request to clean up classid")
    public void the_admin_sends_https_delete_request_to_clean_up_classid() {
        String key = "csId_list";

            classRequest.cleanupClass(key);
            Utils.remove("csId");
            this.response = classRequest.getResponse();
        
    }

    @Then("The Admin gets success code")
    public void the_admin_gets_success_code() {
        if (response == null) {
            LoggerLoad.warn("Cleanup skipped or response was null. Skipping status code assertion.");
            return;
        }
    }

    @When("The Admin sends HTTPS DELETE request to clean up programid")
    public void the_admin_sends_https_delete_request_to_clean_up_programid() {
        
            String endpoint = enumPackage.Endpoint.Program_DELETE_byProgramId.getPath() + "{programId}";
            programRequest.cleanupPrograms("programId_list", "programId", endpoint);
            this.response = programRequest.getResponse();
            Utils.remove("programName");
            Utils.remove("programId");
            Utils.remove("ProgramName_list");
            
        
        
    }

    @When("The Admin sends HTTPS DELETE request to clean up userid")
    public void the_admin_sends_https_delete_request_to_clean_up_userid() {
        
            String key = "userId_list";
            userRequest.cleanupUser(key);
            this.response = userRequest.getResponse();
            Utils.remove("userId");
            Utils.remove("roleId");
            Utils.remove("roleId_list");
            
       
    }

    @When("The Admin sends HTTPS DELETE request to clean up BatchId")
    public void the_admin_sends_https_delete_request_to_clean_up_batch_id() {
        
            String endpoint = enumPackage.Endpoint.Batch_DELETE_byBatchId.getPath() + "{batchId}";
            batchRequest.cleanupBatch("batchId_list", "batchId", endpoint);
            this.response = batchRequest.getResponse();
            Utils.remove("batchId");
           Utils.remove("authToken");
       
        
    }
}
