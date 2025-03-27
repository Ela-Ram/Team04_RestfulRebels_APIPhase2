package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;


import common.ConfigReader;
import common.ExcelReader;
import common.LoggerLoad;
import common.TestContext;
import common.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBuilder.BatchRequest;
import requestBuilder.ClassRequest;
import requestBuilder.CommonRequest;

public class Batch_Step {
	
	private RequestSpecification requestSpecification;
    private Response response;
    private BatchRequest batchRequest;
    private CommonRequest commonRequest;
    
    public Batch_Step() {
        this.batchRequest = new BatchRequest(); 
        this.commonRequest = new CommonRequest();
    }
	
    
    //TC_01_batch
	@When("The Admin sends Batch HTTPS POST request for valid data scenarios as input {string} and {string}")
	public void the_admin_sends_batch_https_post_request_for_valid_data_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		
		batchRequest.batchPost(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();

	}

	@Then("The Admin get Batch  valid data response code and message as {string} and {string}")
	public void the_admin_get_batch_valid_data_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 commonRequest.validateStatusCode(response, testData);
	     commonRequest.validateStatusLine(response, testData);
	  
	}
	
	//post-existingbatchname
	
	@When("The Admin sends Batch HTTPS POST request for existingbatchname scenarios as input {string} and {string}")
	public void the_admin_sends_batch_https_post_request_for_existingbatchname_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		
		batchRequest.batchPost(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();
	    
	}

	@Then("The Admin get Batch  existingbatchname response code and message as {string} and {string}")
	public void the_admin_get_batch_existingbatchname_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 commonRequest.validateStatusCode(response, testData);
	     commonRequest.validateStatusLine(response, testData);
	    
	}
	
	//missing mandatory fields
	
	@When("The Admin sends Batch HTTPS POST request for missing mandatory fields scenarios as input {string} and {string}")
	public void the_admin_sends_batch_https_post_request_for_missing_mandatory_fields_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		
		batchRequest.batchPost(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();
	    
	}

	@Then("The Admin get Batch  missing mandatory fields response code and message as {string} and {string}")
	public void the_admin_get_batch_missing_mandatory_fields_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 commonRequest.validateStatusCode(response, testData);
	     commonRequest.validateStatusLine(response, testData);
	    
	    
	}
	
	
	//invalid Endpoint
	
	@When("The Admin sends Batch HTTPS POST request for invalidendpoint scenarios as input {string} and {string}")
	public void the_admin_sends_batch_https_post_request_for_invalidendpoint_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchPost(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();
	    
	}

	@Then("The Admin get Batch  invalidendpoint response code and message as {string} and {string}")
	public void the_admin_get_batch_invalidendpoint_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		
		
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
		commonRequest.validateStatusLine(response, testData);
	   
	}

	
	//Missing additional fields
	
	@When("The Admin sends Batch HTTPS POST request for missingadditionfields scenarios as input {string} and {string}")
	public void the_admin_sends_batch_https_post_request_for_missingadditionfields_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		
		batchRequest.batchPost(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();
	    
	}

	@Then("The Admin get Batch  missingadditionfields response code and message as {string} and {string}")
	public void the_admin_get_batch_missingadditionfields_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 commonRequest.validateStatusCode(response, testData);
	     commonRequest.validateStatusLine(response, testData);
	}
	
	//invaliddataintherequestbody
	
	@When("The Admin sends Batch HTTPS POST request for invaliddataintherequestbody scenarios as input {string} and {string}")
	public void the_admin_sends_batch_https_post_request_for_invaliddataintherequestbody_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchPost(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();

	    	}

	@Then("The Admin get Batch  invaliddataintherequestbody response code and message as {string} and {string}")
	public void the_admin_get_batch_invaliddataintherequestbody_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 commonRequest.validateStatusCode(response, testData);
	     commonRequest.validateStatusLine(response, testData);
	}
	
	
	//inactive program id
	@When("The Admin sends Batch HTTPS POST request for inactiveprogramid scenarios as input {string} and {string}")
	public void the_admin_sends_batch_https_post_request_for_inactiveprogramid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchPost(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();
	}

	@Then("The Admin get Batch  inactiveprogramid response code and message as {string} and {string}")
	public void the_admin_get_batch_inactiveprogramid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 commonRequest.validateStatusCode(response, testData);
	     commonRequest.validateStatusLine(response, testData);
	}
	
	//get all batches
	
	@When("The Admin sends get all Batches HTTPS  request for succesfulretrieving scenarios as input {string} and {string}")
	public void the_admin_sends_get_all_batches_https_request_for_succesfulretrieving_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
	   batchRequest.getllbatcheswithoutPathParam(sheetName, testCaseID, requestSpecification);
	   this.response = batchRequest.getResponse();
	}

	@Then("The Admin get GetallBatch  succesfulretrieving response code and message as {string} and {string}")
	public void the_admin_get_getall_batch_succesfulretrieving_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
	
	//getallbatches-invalid endpoint
	@When("The Admin sends get all Batches HTTPS  request for getallbatcheswithinvalidendpoint scenarios as input {string} and {string}")
	public void the_admin_sends_get_all_batches_https_request_for_getallbatcheswithinvalidendpoint_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		 batchRequest.getllbatcheswithoutPathParam(sheetName, testCaseID, requestSpecification);
		   this.response = batchRequest.getResponse();
	}

	@Then("The Admin get GetallBatch  getallbatcheswithinvalidendpoint response code and message as {string} and {string}")
	public void the_admin_get_getall_batch_getallbatcheswithinvalidendpoint_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
	//TC_11_batch
	//getallbatchesbybatchid
	@When("The Admin sends get BatchbyBatchid HTTPS  request for succesfulretrievingbybatchid scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_batchid_https_request_for_succesfulretrievingbybatchid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
	    batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();
	    
	}

	@Then("The Admin get BatchbyBatchid  succesfulretrievingbybatchid response code and message as {string} and {string}")
	public void the_admin_get_batchby_batchid_succesfulretrievingbybatchid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
	//retrievethebatchidalredydeletedbatch
	@When("The Admin sends get BatchbyBatchid HTTPS  request for retrievethebatchidalredydeletedbatch scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_batchid_https_request_for_retrievethebatchidalredydeletedbatch_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
	   batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
	   this.response=batchRequest.getResponse();
	}
	

	@Then("The Admin get BatchbyBatchid  retrievethebatchidalredydeletedbatch response code and message as {string} and {string}")
	public void the_admin_get_batchby_batchid_retrievethebatchidalredydeletedbatch_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
	
	//retrievethebatchbyinvalidbatchid
	@When("The Admin sends get BatchbyBatchid HTTPS  request for retrievethebatchbyinvalidbatchid scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_batchid_https_request_for_retrievethebatchbyinvalidbatchid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		 batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	}

	@Then("The Admin get BatchbyBatchid  retrievethebatchbyinvalidbatchid response code and message as {string} and {string}")
	public void the_admin_get_batchby_batchid_retrievethebatchbyinvalidbatchid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
	  
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

	
	
	//byinvalidendpoint-getbybatchid
	
	@When("The Admin sends get BatchbyBatchid HTTPS  request for retrievebatchbyinvalidendpoint scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_batchid_https_request_for_retrievebatchbyinvalidendpoint_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		 batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	
	}

	@Then("The Admin get BatchbyBatchid  retrievebatchbyinvalidendpoint response code and message as {string} and {string}")
	public void the_admin_get_batchby_batchid_retrievebatchbyinvalidendpoint_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
	
	//get batch by batchname
	
	//succesfulretrievingbybatchname    //TC_08_batch
	
	@When("The Admin sends get BatchbyBatchname HTTPS  request for succesfulretrievingbybatchname scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_batchname_https_request_for_succesfulretrievingbybatchname_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	}

	@Then("The Admin get BatchbyBatchname  succesfulretrievingbybatchname response code and message as {string} and {string}")
	public void the_admin_get_batchby_batchname_succesfulretrievingbybatchname_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

	@When("The Admin sends get BatchbyBatchname HTTPS  request for retrievethebatchidalredydeletedbatch scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_batchname_https_request_for_retrievethebatchidalredydeletedbatch_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	}

	@Then("The Admin get BatchbyBatchname  retrievethebatchidalredydeletedbatch response code and message as {string} and {string}")
	public void the_admin_get_batchby_batchname_retrievethebatchidalredydeletedbatch_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

	@When("The Admin sends get BatchbyBatchname HTTPS  request for retrievethebatchbyinvalidbatchname scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_batchname_https_request_for_retrievethebatchbyinvalidbatchname_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	}

	@Then("The Admin get BatchbyBatchname  retrievethebatchbyinvalidbatchname response code and message as {string} and {string}")
	public void the_admin_get_batchby_batchname_retrievethebatchbyinvalidbatchname_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

	@When("The Admin sends get BatchbyBatchname HTTPS  request for retrievebatchbyinvalidendpoint scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_batchname_https_request_for_retrievebatchbyinvalidendpoint_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	}

	@Then("The Admin get BatchbyBatchname  retrievebatchbyinvalidendpoint response code and message as {string} and {string}")
	public void the_admin_get_batchby_batchname_retrievebatchbyinvalidendpoint_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
	
	//GetbatchbyProgramid
	
	//TC_19_batch
	@When("The Admin sends get BatchbyProgramId HTTPS  request for succesfulretrievingbyprogramid scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_program_id_https_request_for_succesfulretrievingbyprogramid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	}

	@Then("The Admin get BatchbyProgramId  succesfulretrievingbyprogramid response code and message as {string} and {string}")
	public void the_admin_get_batchby_program_id_succesfulretrievingbyprogramid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
	  
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
//TC_20_batch
	@When("The Admin sends get BatchbyProgramId HTTPS  request for retrievethebatchidbyinactiveprogramid scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_program_id_https_request_for_retrievethebatchidbyinactiveprogramid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	}

	@Then("The Admin get BatchbyProgramId  retrievethebatchidbyinactiveprogramid response code and message as {string} and {string}")
	public void the_admin_get_batchby_program_id_retrievethebatchidbyinactiveprogramid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

	
	//TC_21_batch
	@When("The Admin sends get BatchbyProgramId HTTPS  request for retrievethebatchbyinvalidprogramid scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_program_id_https_request_for_retrievethebatchbyinvalidprogramid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	}

	@Then("The Admin get BatchbyProgramId  retrievethebatchbyinvalidprogramid response code and message as {string} and {string}")
	public void the_admin_get_batchby_program_id_retrievethebatchbyinvalidprogramid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

	
	//TC_22_batch
	@When("The Admin sends get BatchbyProgramId HTTPS  request for retrievebatchbyinvalidendpoint scenarios as input {string} and {string}")
	public void the_admin_sends_get_batchby_program_id_https_request_for_retrievebatchbyinvalidendpoint_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	}

	@Then("The Admin get BatchbyProgramId  retrievebatchbyinvalidendpoint response code and message as {string} and {string}")
	public void the_admin_get_batchby_program_id_retrievebatchbyinvalidendpoint_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

	//DeleteBatchbyBaatchid

	//TC_23_batch
	@When("The Admin sends delete BatchbyBatchId HTTPS  request for succesfulbatchdeletebybatchid scenarios as input {string} and {string}")
	public void the_admin_sends_delete_batchby_batch_id_https_request_for_succesfulbatchdeletebybatchid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
	  batchRequest.deleteBatch(sheetName, testCaseID, requestSpecification);
	  this.response = batchRequest.getResponse();
	}

	@Then("The Admin get deleteBatchbyBatchId  succesfulbatchdeletebybatchid response code and message as {string} and {string}")
	public void the_admin_get_delete_batchby_batch_id_succesfulbatchdeletebybatchid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

	//TC_24_batch
	@When("The Admin sends delete BatchbyBatchId HTTPS  request for retrievethebatchbyinvalidbatchid scenarios as input {string} and {string}")
	public void the_admin_sends_delete_batchby_batch_id_https_request_for_retrievethebatchbyinvalidbatchid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.deleteBatch(sheetName, testCaseID, requestSpecification);
		  this.response = batchRequest.getResponse();
	}

	@Then("The Admin get deleteBatchbyBatchId  retrievethebatchbyinvalidbatchid response code and message as {string} and {string}")
	public void the_admin_get_delete_batchby_batch_id_retrievethebatchbyinvalidbatchid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

	//TC_25_batch
	@When("The Admin sends delete BatchbyBatchId HTTPS  request for deletebatchbyinvalidendpoint scenarios as input {string} and {string}")
	public void the_admin_sends_delete_batchby_batch_id_https_request_for_deletebatchbyinvalidendpoint_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.deleteBatch(sheetName, testCaseID, requestSpecification);
		  this.response = batchRequest.getResponse();
	}

	@Then("The Admin get deleteBatchbyBatchId  deletebatchbyinvalidendpoint response code and message as {string} and {string}")
	public void the_admin_get_delete_batchby_batch_id_deletebatchbyinvalidendpoint_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}


	
	//Update by batchid
	
	//TC_26_batch
	
	@When("The Admin sends UpdateBatchbyBatchid HTTPS POST request for successfulupdatebyvalidbatchid scenarios as input {string} and {string}")
	public void the_admin_sends_update_batchby_batchid_https_post_request_for_successfulupdatebyvalidbatchid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
	    batchRequest.batchPut(sheetName, testCaseID, requestSpecification);
	    this.response =batchRequest.getResponse();
	}

	@Then("The Admin get UpdateBatchbyBatchid  successfulupdatebyvalidbatchid response code and message as {string} and {string}")
	public void the_admin_get_update_batchby_batchid_successfulupdatebyvalidbatchid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
//TC_27_batch
	@When("The Admin sends UpdateBatchbyBatchid HTTPS POST request for updatebyinvalidbatchid scenarios as input {string} and {string}")
	public void the_admin_sends_update_batchby_batchid_https_post_request_for_updatebyinvalidbatchid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchPut(sheetName, testCaseID, requestSpecification);
	    this.response =batchRequest.getResponse();
	}

	@Then("The Admin get UpdateBatchbyBatchid  updatebyinvalidbatchid response code and message as {string} and {string}")
	public void the_admin_get_update_batchby_batchid_updatebyinvalidbatchid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
	//TC_28_batch
	@When("The Admin sends UpdateBatchbyBatchid HTTPS POST request for updatebymissingmandatoryfieldsbyvalidbatchid scenarios as input {string} and {string}")
	public void the_admin_sends_update_batchby_batchid_https_post_request_for_updatebymissingmandatoryfieldsbyvalidbatchid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		 batchRequest.batchPut(sheetName, testCaseID, requestSpecification);
		    this.response =batchRequest.getResponse();
	}

	@Then("The Admin get UpdateBatchbyBatchid  updatebymissingmandatoryfieldsbyvalidbatchid response code and message as {string} and {string}")
	public void the_admin_get_update_batchby_batchid_updatebymissingmandatoryfieldsbyvalidbatchid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
//TC_29_batch
	@When("The Admin sends UpdateBatchbyBatchid HTTPS POST request for invaliddataintherequestbody scenarios as input {string} and {string}")
	public void the_admin_sends_update_batchby_batchid_https_post_request_for_invaliddataintherequestbody_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		 batchRequest.batchPut(sheetName, testCaseID, requestSpecification);
		    this.response =batchRequest.getResponse();
	}

	@Then("The Admin get UpdateBatchbyBatchid  invaliddataintherequestbody response code and message as {string} and {string}")
	public void the_admin_get_update_batchby_batchid_invaliddataintherequestbody_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
//TC_30_batch
	@When("The Admin sends UpdateBatchbyBatchid HTTPS POST request for invalid endpoint scenarios as input {string} and {string}")
	public void the_admin_sends_update_batchby_batchid_https_post_request_for_invalid_endpoint_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		 batchRequest.batchPut(sheetName, testCaseID, requestSpecification);
		    this.response =batchRequest.getResponse();
	}

	@Then("The Admin get UpdateBatchbyBatchid  invalid endpoint response code and message as {string} and {string}")
	public void the_admin_get_update_batchby_batchid_invalid_endpoint_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    
	}
	//TC_31_batch
	@When("The Admin sends UpdateBatchbyBatchid HTTPS POST request for updatebyinactiveprogramidbyvalidbatchid scenarios as input {string} and {string}")
	public void the_admin_sends_update_batchby_batchid_https_post_request_for_updatebyinactiveprogramidbyvalidbatchid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchPut(sheetName, testCaseID, requestSpecification);
	    this.response =batchRequest.getResponse();
	}

	@Then("The Admin get UpdateBatchbyBatchid  updatebyinactiveprogramidbyvalidbatchid response code and message as {string} and {string}")
	public void the_admin_get_update_batchby_batchid_updatebyinactiveprogramidbyvalidbatchid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}
//TC_32_batch
	@When("The Admin sends UpdateBatchbyBatchid HTTPS POST request for updatebydeletedbatchid scenarios as input {string} and {string}")
	public void the_admin_sends_update_batchby_batchid_https_post_request_for_updatebydeletedbatchid_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchPut(sheetName, testCaseID, requestSpecification);
	    this.response =batchRequest.getResponse();
	}

	@Then("The Admin get UpdateBatchbyBatchid  updatebydeletedbatchid response code and message as {string} and {string}")
	public void the_admin_get_update_batchby_batchid_updatebydeletedbatchid_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

//TC_10_batch
	
	@When("The Admin sends get all Batches HTTPS  request for getallbatcheswithsearchstring scenarios as input {string} and {string}")
	public void the_admin_sends_get_all_batches_https_request_for_getallbatcheswithsearchstring_scenarios_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.getllbatcheswithsearchString(sheetName, testCaseID, requestSpecification,"Team4");
		   this.response = batchRequest.getResponse();
	}

	@Then("The Admin get GetallBatch  getallbatcheswithsearchstring response code and message as {string} and {string}")
	public void the_admin_get_getall_batch_getallbatcheswithsearchstring_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	    commonRequest.validateContentType(response, testData);
	}

	
	
	//TC_01_batch_noAuth
	
	@When("The Admin sends batch createbatchnoauth request with no auth as input {string} and {string}")
	public void the_admin_sends_batch_createbatchnoauth_request_with_no_auth_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchPost(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();
	}

	@Then("The Admin gets batch response code and message as {string} and {string}")
	public void the_admin_gets_batch_response_code_and_message_as_and(String sheetName, String testCaseID) throws IOException {
		
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		commonRequest.validateStatusCode(response, testData);
	    commonRequest.validateStatusLine(response, testData);
	    commonRequest.validateResponseTime(response);
	   
	}
	
	//TC_02_batch_noAuth
	@When("The Admin sends batch getallbatchesnoauth request with no auth as input {string} and {string}")
	public void the_admin_sends_batch_getallbatchesnoauth_request_with_no_auth_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		   this.response=batchRequest.getResponse();
	}

	
	//TC_03_batch_noAuth batchbybatchidnoauth
	@When("The Admin sends batch getbatchbybatchidsnoauth request with no auth as input {string} and {string}")
	public void the_admin_sends_batch_getbatchbybatchidsnoauth_request_with_no_auth_as_input_and(String sheetName, String testCaseID) throws IOException {
		 batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
		    this.response = batchRequest.getResponse();
	}
	
	//TC_04_batch_noAuth
	@When("The Admin sends batch getbatchbybatchnamessnoauth request with no auth as input {string} and {string}")
	public void the_admin_sends_batch_getbatchbybatchnamessnoauth_request_with_no_auth_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();
	}
	//TC_05_batch_noAuth
	@When("The Admin sends batch getbatchbyprogramidsnoauth request with no auth as input {string} and {string}")
	public void the_admin_sends_batch_getbatchbyprogramidsnoauth_request_with_no_auth_as_input_and(String sheetName, String testCaseID) throws IOException {
		batchRequest.batchGetbybatchidbatchnameprogramid(sheetName, testCaseID, requestSpecification);
	    this.response = batchRequest.getResponse();
	}
	//TC_06_batch_noAuth--//updatebybatchid
	
	@When("The Admin sends batch updatebatchbybatchidsnoauth request with no auth as input {string} and {string}")
	public void the_admin_sends_batch_updatebatchbybatchidsnoauth_request_with_no_auth_as_input_and(String sheetName, String testCaseID) throws IOException {
		 batchRequest.batchPut(sheetName, testCaseID, requestSpecification);
		    this.response =batchRequest.getResponse();
	}
	//TC_07_batch_noAuth
	@When("The Admin sends batch deletebatchbybatchidsnoauth request with no auth as input {string} and {string}")
	public void the_admin_sends_batch_deletebatchbybatchidsnoauth_request_with_no_auth_as_input_and(String sheetName, String testCaseID) throws IOException {
		 batchRequest.deleteBatch(sheetName, testCaseID, requestSpecification);
		  this.response = batchRequest.getResponse();
	}
}