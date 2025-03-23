package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;


import common.ConfigReader;
import common.ExcelReader;
import common.TestContext;
import common.Utils;
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

	//Post Valid
@When("The Admin sends HTTPS POST request for valid data scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_valid_data_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
   
}

@Then("The Admin get valid data response code and message as {string} and {string} for Class")
public void the_admin_get_valid_data_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
     commonRequest.validateStatusLine(response, testData);
    
}

@When("The Admin sends HTTPS POST request for mandatory fields scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_mandatory_fields_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
   
}

@Then("The Admin get mandatory fields response code and message as {string} and {string} for Class")
public void the_admin_get_mandatory_fields_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	   
}

@When("The Admin sends HTTPS POST request for additional fields scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_additional_fields_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); // Capture response for validations
 
    
}

@Then("The Admin get additional fields response code and message as {string} and {string} for Class")
public void the_admin_get_additional_fields_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) {
   
}


@When("The Admin sends HTTPS POST request for invalid data scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_invalid_data_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); // Capture response for validations
    
}

@Then("The Admin get invalid data response code and message as {string} and {string} for Class")
public void the_admin_get_invalid_data_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) {
    
}


@When("The Admin sends HTTPS POST request for existing class topic scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_existing_class_topic_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); // Capture response for validations
    
}

@Then("The Admin get existing class topic response code and message as {string} and {string} for Class")
public void the_admin_get_existing_class_topic_response_code_and_message_as_and_for_class(String string, String string2) {
    
}
	

@When("The Admin sends HTTPS POST request for invalid endpoint scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_invalid_endpoint_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); // Capture response for validations
    
}

@Then("The Admin get invalid endpoint response code and message as {string} and {string} for Class")
public void the_admin_get_invalid_endpoint_response_code_and_message_as_and_for_class(String string, String string2) {
    
}
	
//Scenario without payload

@When("The Admin sends HTTPS POST request for no payload scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_no_payload_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPostNoPayload( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); // Capture response for validations
    
}

@Then("The Admin get no payload response code and message as {string} and {string} for Class")
public void the_admin_get_no_payload_response_code_and_message_as_and_for_class(String string, String string2) {
    
}

//Get all class


@When("The Admin sends HTTPS Get request for Get all class valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_all_class_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetwithoutPathParam(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
    
}

@Then("The Admin get Get all class valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_all_class_valid_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) {
    
}

//Get all class invalid endpoint

@When("The Admin sends HTTPS Get request for Get all class invalid Endpoint scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_all_class_invalid_endpoint_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetwithoutPathParam(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
   
}

@Then("The Admin get Get all class invalid Endpoint response code and message as {string} and {string} for Class")
public void the_admin_get_get_all_class_invalid_endpoint_response_code_and_message_as_and_for_class(String string, String string2) {
   
}
//Get all class invalid method


@When("The Admin sends HTTPS Get request for Get all class invalid method scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_all_class_invalid_method_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetinvalidMethod(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
	
}

@Then("The Admin get Get all class invalid method response code and message as {string} and {string} for Class")
public void the_admin_get_get_all_class_invalid_method_response_code_and_message_as_and_for_class(String string, String string2) {
    
}

//get class recordings by batchid


@When("The Admin sends HTTPS Get request for Get class recordings by BatchId valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_recordings_by_batch_id_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetbyIdandTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

@Then("The Admin get Get class recordings by BatchId valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_recordings_by_batch_id_valid_response_code_and_message_as_and_for_class(String string, String string2) {
    
}

//get class recordings by invalid batchid
@When("The Admin sends HTTPS Get request for Get class recordings by BatchId invalid BatchId scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_recordings_by_batch_id_invalid_batch_id_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetbyIdandTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

@Then("The Admin get Get class recordings by BatchId invalid BatchId response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_recordings_by_batch_id_invalid_batch_id_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) {
    
}

//get class recordings by invalid endpoint

@When("The Admin sends HTTPS Get request for Get class recordings by BatchId invalid Endpoint scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_recordings_by_batch_id_invalid_endpoint_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetbyIdandTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

@Then("The Admin get Get class recordings by BatchId invalid Endpoint response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_recordings_by_batch_id_invalid_endpoint_response_code_and_message_as_and_for_class(String string, String string2) {
   
}

//get class recordings by invalid method
@When("The Admin sends HTTPS Get request for Get class recordings by BatchId invalid method scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_recordings_by_batch_id_invalid_method_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetinvalidMethod(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
  
}

@Then("The Admin get Get class recordings by BatchId invalid method response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_recordings_by_batch_id_invalid_method_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) {
   
}
//get class by topicvalid


@When("The Admin sends HTTPS Get request for Get class by Topic valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_by_topic_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetbyIdandTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
    
}

@Then("The Admin get Get class by Topic valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_by_topic_valid_response_code_and_message_as_and_for_class(String string, String string2) {
   
}
//get class by topic invalid
@When("The Admin sends HTTPS Get request for Get class by Topic invalid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_by_topic_invalid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetbyIdandTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

@Then("The Admin get Get class by Topic invalid response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_by_topic_invalid_response_code_and_message_as_and_for_class(String string, String string2) {
   
}
//get class by topic invalid method

@When("The Admin sends HTTPS Get request for Get class by Topic invalid method scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_by_topic_invalid_method_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	
	classRequest.classGetinvalidMethod(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
   
}

@Then("The Admin get Get class by Topic invalid method response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_by_topic_invalid_method_response_code_and_message_as_and_for_class(String string, String string2) {
   
}

	

}
