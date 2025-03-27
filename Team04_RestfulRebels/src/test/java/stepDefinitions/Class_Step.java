package stepDefinitions;

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
import payload.Class_POJO;
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

	//TC_01_class Post Valid
@When("The Admin sends HTTPS POST request for valid data scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_valid_data_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
   
}

@Then("The Admin get valid data response code and message as {string} and {string} for Class")
public void the_admin_get_valid_data_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	Class_POJO expectedClassData = classRequest.getclassRequestBody();
	 commonRequest.validateStatusCode(response, testData);
     commonRequest.validateStatusLine(response, testData);
     commonRequest.validateContentType(response, testData);
     commonRequest.validateResponseTime(response);
     commonRequest.validateSchema(response, "Schema/Class/CreateClassSchema_Post.json");
     ClassRequest.validateDataClassPost(expectedClassData, response);
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_02_class Post Class Mandatory fields

@When("The Admin sends HTTPS POST request for mandatory fields scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_mandatory_fields_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
   
}

@Then("The Admin get mandatory fields response code and message as {string} and {string} for Class")
public void the_admin_get_mandatory_fields_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	Class_POJO expectedClassData = classRequest.getclassRequestBody();
	 commonRequest.validateStatusCode(response, testData);
     commonRequest.validateStatusLine(response, testData);
     commonRequest.validateContentType(response, testData);
     commonRequest.validateResponseTime(response);
     commonRequest.validateSchema(response, "Schema/Class/CreateClassSchema_Post.json");
     ClassRequest.validateDataClassPost(expectedClassData, response);
	   
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_03_class Post Class Additional fields

@When("The Admin sends HTTPS POST request for additional fields scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_additional_fields_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
 
}

@Then("The Admin get additional fields response code and message as {string} and {string} for Class")
public void the_admin_get_additional_fields_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
   
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
// TC_04_class Post Class Invalid Data

@When("The Admin sends HTTPS POST request for invalid data scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_invalid_data_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
    
}

@Then("The Admin get invalid data response code and message as {string} and {string} for Class")
public void the_admin_get_invalid_data_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);

    
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
// TC_05_class Post Class Existing Class Topic

@When("The Admin sends HTTPS POST request for existing class topic scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_existing_class_topic_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
    
}

@Then("The Admin get existing class topic response code and message as {string} and {string} for Class")
public void the_admin_get_existing_class_topic_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_06_class invalid endpoint	

@When("The Admin sends HTTPS POST request for invalid endpoint scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_invalid_endpoint_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
    
}

@Then("The Admin get invalid endpoint response code and message as {string} and {string} for Class")
public void the_admin_get_invalid_endpoint_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);

}
//----------------------------------------------------------------------------------------------------------------------------------------------------------	
// TC_07_class Scenario without payload

@When("The Admin sends HTTPS POST request for no payload scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_post_request_for_no_payload_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPostNoPayload( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
    
}

@Then("The Admin get no payload response code and message as {string} and {string} for Class")
public void the_admin_get_no_payload_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);

    
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_01_class_put Mandatory fields put operation with valid classId

@When("The Admin sends HTTPS PUT request for mandatory fields scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_for_mandatory_fields_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPut( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();  
    
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_02_class_put Mandatory fields put operation with invalid classId


@When("The Admin sends HTTPS PUT request for invalid classId scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_for_invalid_class_id_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPut( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();     
}
@Then("The Admin get invalid classId response code and message as {string} and {string} for Class")
public void the_admin_get_invalid_class_id_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_03_class_put Additional fields put operation 

@When("The Admin sends HTTPS PUT request for additional fields scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_for_additional_fields_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPut( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();     
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_04_class_put invalid data
@When("The Admin sends HTTPS PUT request for invalid data scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_for_invalid_data_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPut( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();  
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_05_class_put invalid data Topic


@When("The Admin sends HTTPS PUT request for invalid Topic scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_for_invalid_topic_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPut( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();  
   
}

@Then("The Admin get invalid Topic response code and message as {string} and {string} for Class")
public void the_admin_get_invalid_topic_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
   
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_06_class_put invalid Endpoint
@When("The Admin sends HTTPS PUT request for invalid endpoint scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_for_invalid_endpoint_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPut( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();  
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_07_class_put deleted BatchId in request Body

@When("The Admin sends HTTPS PUT request for invalid BatchID scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_for_invalid_batch_id_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPut( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
}

@Then("The Admin get invalid BatchID response code and message as {string} and {string} for Class")
public void the_admin_get_invalid_batch_id_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);

   }

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_08_class_put  deleted ClassId in endpoint

@When("The Admin sends HTTPS PUT request for Deleted ClassId scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_for_deleted_class_id_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPut( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();   
}

@Then("The Admin get Deleted ClassId response code and message as {string} and {string} for Class")
public void the_admin_get_deleted_class_id_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);

}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_09_classAllRecord_put valid class recording path

@When("The Admin sends HTTPS PUT request for valid class_get_allrecordings scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_for_valid_class_get_allrecordings_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPutRecordingpath( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();   
    
}

@Then("The Admin get valid class_get_allrecordings response code and message as {string} and {string} for Class")
public void the_admin_get_valid_class_get_allrecordings_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_10_classAllRecord_put invalid classid in the requestBody class recording path

@When("The Admin sends HTTPS PUT request for invalidData allrecordings scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_for_invalidData_allrecordings_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
    
	classRequest.classPutRecordingpath( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();   	
}

@Then("The Admin get invalidData allrecordings response code and message as {string} and {string} for Class")
public void the_admin_get_invalidData_allrecordings_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
}
//TC_11_classAllRecord_put is glued to the previous step just the differnt testdata
//TC_12_class_put invalid Method is glued to the previous step just the differnt testdata
//TC_13_class_put invalid Endpoint is glued to the previous step just the differnt testdata


//--------------------------------------------------------------------------------------------------------------------------------------------------
// TC_01_class_get Get all class


@When("The Admin sends HTTPS Get request for Get all class valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_all_class_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetAll(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
    
}

@Then("The Admin get Get all class valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_all_class_valid_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    commonRequest.validateContentType(response, testData);
  //  commonRequest.validateSchema(response, "Schema/Class/class_get_allclasslistSchema.json");
    
}


//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_04_class_get get class recordings by batchid


@When("The Admin sends HTTPS Get request for Get class recordings by BatchId valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_recordings_by_batch_id_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

@Then("The Admin get Get class recordings by BatchId valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_recordings_by_batch_id_valid_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
 commonRequest.validateStatusLine(response, testData);
 commonRequest.validateResponseTime(response);
 commonRequest.validateContentType(response, testData);
 commonRequest.validateSchema(response, "Schema/Class/class_get_classrecordings_bybatchid.json");
 
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_08_class_get get class by topicvalid


@When("The Admin sends HTTPS Get request for Get class by Topic valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_by_topic_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
 
}

@Then("The Admin get Get class by Topic valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_by_topic_valid_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
 commonRequest.validateStatusCode(response, testData);
 commonRequest.validateStatusLine(response, testData);
 commonRequest.validateResponseTime(response);
 commonRequest.validateContentType(response, testData);
 commonRequest.validateSchema(response, "Schema/Class/class_get_classrecordings_bybatchid.json");

}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_02_class_get request for Get all class invalid Endpoint
@When("The Admin sends HTTPS Get request for Get all class invalid Endpoint scenarios as input {string} and {string} for Class invalid")
public void the_admin_sends_https_get_request_for_get_all_class_invalid_endpoint_scenarios_as_input_and_for_class_invalid(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetAll(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
    
}

@Then("The Admin get response code and message as {string} and {string} for Class invalid")
public void the_admin_get_response_code_and_message_as_and_for_class_invalid(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
	 commonRequest.validateStatusLine(response, testData);
	 commonRequest.validateResponseTime(response);
   
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_12_class_get Get class by classId valid


@When("The Admin sends HTTPS Get request for Get class by classId valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_by_class_id_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

@Then("The Admin get Get class by classId valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_by_class_id_valid_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
	 commonRequest.validateStatusLine(response, testData);
	 commonRequest.validateResponseTime(response);
	 commonRequest.validateContentType(response, testData);
	// commonRequest.validateSchema(response, "Schema/Class/class_get_classrecordings_bybatchid.json");

  
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_13_class_get Get request for Get class by BatcId valid

@When("The Admin sends HTTPS Get request for Get class by BatcId valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_by_batc_id_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

@Then("The Admin get Get class by BatcId valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_by_batc_id_valid_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
	 commonRequest.validateStatusLine(response, testData);
	 commonRequest.validateResponseTime(response);
	 commonRequest.validateContentType(response, testData);
	// commonRequest.validateSchema(response, "Schema/Class/class_get_classrecordings_bybatchid.json");
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_14_class_get Get class by staffId valid

@When("The Admin sends HTTPS Get request for Get class by staffId valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_class_by_staff_id_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

@Then("The Admin get Get class by staffId valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_class_by_staff_id_valid_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
	 commonRequest.validateStatusLine(response, testData);
	 commonRequest.validateResponseTime(response);
	 commonRequest.validateContentType(response, testData);
	// commonRequest.validateSchema(response, "Schema/Class/class_get_classrecordings_bybatchid.json");
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_15_class_get Get all recordings valid
@When("The Admin sends HTTPS Get request for Get all recordings valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_all_recordings_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetAll(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

@Then("The Admin get Get all recordings valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_all_recordings_valid_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
	 commonRequest.validateStatusLine(response, testData);
	 commonRequest.validateResponseTime(response);
	 commonRequest.validateContentType(response, testData);
	// commonRequest.validateSchema(response, "Schema/Class/class_get_classrecordings_bybatchid.json");
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_16_class_get Get request for Get recordings by classId valid
@When("The Admin sends HTTPS Get request for Get recordings by classId valid scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_get_request_for_get_recordings_by_class_id_valid_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
  }

@Then("The Admin get Get recordings by classId valid response code and message as {string} and {string} for Class")
public void the_admin_get_get_recordings_by_class_id_valid_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
	 commonRequest.validateStatusLine(response, testData);
	 commonRequest.validateResponseTime(response);
	 commonRequest.validateContentType(response, testData);
	// commonRequest.validateSchema(response, "Schema/Class/class_get_classrecordings_bybatchid.json");
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_03_class_get Get all class invalid method

@When("The Admin sends HTTPS Get request for Get all class invalid method scenarios as input {string} and {string} for Class invalid")
public void the_admin_sends_https_get_request_for_get_all_class_invalid_method_scenarios_as_input_and_for_class_invalid(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetAll(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}




@When("The Admin sends HTTPS Get request for scenarios as input {string} and {string} for Class invalid")
public void the_admin_sends_https_get_request_for_scenarios_as_input_and_for_class_invalid(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}





//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_01_class_del Delete by valid classId

@When("The Admin sends HTTPS Delete request for valid classID scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_delete_request_for_valid_class_id_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.deleteClass(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
	 
}

@Then("The Admin  response code and message as {string} and {string} for Class")
public void the_admin_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_02_class_del Delete by va invalid Endpoint

@When("The Admin sends HTTPS Delete request for invalid Endpoint scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_delete_request_for_invalid_endpoint_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.deleteClass(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse(); 
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//TC_03_class_del Delete by va invalid classId

@When("The Admin sends HTTPS Delete request for invalid classId scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_delete_request_for_invalid_class_id_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	
	classRequest.deleteClass(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();


}

//-------------------------------------------------------------------------------------------------------------------------------------------------
// TC_01_class_noAuth Unauthorized Scenarios createclass


@When("The Admin sends createclass request with no auth as input {string} and {string} for class")
public void the_admin_sends_createclass_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
	
    
}
@Then("The Admin gets response code and message as {string} and {string} for class")
public void the_admin_gets_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
}

//--------------------------------------------------------------------------------------------------------------------------------------------------

//TC_02_class_noAuth Unauthorized Scenarios class_get_allclasslist
@When("The Admin sends class_get_allclasslist request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_get_allclasslist_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetAll(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
    
}
//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_03_class_noAuth Unauthorized class_get_classrecordings_bybatchid


@When("The Admin sends class_get_classrecordings_bybatchid request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_get_classrecordings_bybatchid_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
    
}
//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_04_class_noAuth Unauthorized class_get_classdetails_byclassid

@When("The Admin sends class_get_classdetails_byclassid request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_get_classdetails_byclassid_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
   
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_05_class_noAuth Unauthorized class_get_allclasses_bybatchid

@When("The Admin sends class_get_allclasses_bybatchid request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_get_allclasses_bybatchid_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();

}

//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_06_class_noAuth Unauthorized class_get_allclasses_bystaffid

@When("The Admin sends class_get_allclasses_bystaffid request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_get_allclasses_bystaffid_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_07_class_noAuth Unauthorized class_get_allrecordings

@When("The Admin sends class_get_allrecordings request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_get_allrecordings_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetAll(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
    
}
//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_08_class_noAuth Unauthorized class_get_classrecordings_byclassid
@When("The Admin sends class_get_classrecordings_byclassid request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_get_classrecordings_byclassid_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}
//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_09_class_noAuth Unauthorized class_get_byclasstopic
@When("The Admin sends class_get_byclasstopic request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_get_byclasstopic_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classGetByIdAndTopic(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_10_class_noAuth Unauthorized class_put_newclass

@When("The Admin sends class_put_newclass request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_put_newclass_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPut( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();  
}
//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_11_class_noAuth Unauthorized class_put_class_recording_path

@When("The Admin sends class_put_class_recording_path request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_put_class_recording_path_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPutRecordingpath( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();   
    
}
//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_12_class_noAuth Unauthorized class_delete_byclassid

@When("The Admin sends class_delete_byclassid request with no auth as input {string} and {string} for class")
public void the_admin_sends_class_delete_byclassid_request_with_no_auth_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.deleteClass(sheetName, testCaseID, requestSpecification);
	this.response = classRequest.getResponse();
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
//Post invalid url


@Given("Admin is on base url with Invalid URL")
public void admin_is_on_base_url_with_invalid_url() {
	RequestSpecification invalidURLRequestSpecifications= commonRequest.basewithInvalidUrl();
	 TestContext.setRequestSpecification("invalidURLRequestSpecification", invalidURLRequestSpecifications);
}

@When("The Admin sends Class Post request with invalid url as input {string} and {string}")
public void the_admin_sends_class_post_request_with_invalid_url_as_input_and(String sheetName, String testCaseID) throws IOException {
	classRequest.classPost(sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse(); 
   
	
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
//TC_01_class_chaining put request to change the status to active 
@When("The Admin sends HTTPS PUT request as input {string} and {string} for Class")
public void the_admin_sends_https_put_request_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	classRequest.classPut( sheetName, testCaseID, requestSpecification);
    this.response = classRequest.getResponse();  
}



}
