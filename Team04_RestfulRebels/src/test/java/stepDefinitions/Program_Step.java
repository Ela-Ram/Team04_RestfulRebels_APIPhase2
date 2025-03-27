package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import requestBuilder.ClassRequest;
import requestBuilder.CommonRequest;
import requestBuilder.LoginandLogoutRequest;
import requestBuilder.ProgramRequest;
import common.ExcelReader;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Class_POJO;
import payload.Program_POJO;

public class Program_Step {
    private RequestSpecification requestSpecification;
    private Response response;
    private CommonRequest commonRequest;
    private ProgramRequest programRequest;
    private LoginandLogoutRequest loginRequest;
    
    public Program_Step() {
  
        this.commonRequest = new CommonRequest();
        this.programRequest = new ProgramRequest();
        this.loginRequest = new LoginandLogoutRequest();
    }

    
    @Given("Admin is on base url with valid auth")
    public void admin_is_on_base_url_with_valid_auth() {
    	
    	RequestSpecification validRequestSpecification= commonRequest.basewithValidauth();
    	//TestContext.setRequestSpecification(requestSpecification);
        TestContext.setRequestSpecification("validRequestSpecification", validRequestSpecification);

    }
    
    //------------------POST request valid data--------------

    @When("The Admin sends HTTPS POST request for valid data scenarios as input {string} and {string} for Program")
    public void the_admin_sends_https_post_request_for_valid_data_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    	
    	programRequest.programPost(sheetName, testCaseID, requestSpecification);
        this.response = programRequest.getResponse(); // Capture response for validations
       
    }

    @Then("The Admin get valid data response code and message as {string} and {string} for Program")
    public void the_admin_get_valid_data_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
    	 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
    	 Program_POJO expectedprogramData = programRequest.getProgramRequestBody();
         commonRequest.validateStatusCode(response, testData);
         commonRequest.validateStatusLine(response, testData);
         commonRequest.validateContentType(response, testData);
         commonRequest.validateResponseTime(response);
         commonRequest.validateSchema(response, "Schema/program/createprogramSchema.json");
         ProgramRequest.validateDataForProgram(expectedprogramData, response);

       
    }
    
    //------------POST request for invalid endpoint-----------
    
    @When("The Admin sends HTTPS POST request for invalid endpoint scenarios as input {string} and {string} for Program")
    public void the_admin_sends_https_post_request_for_invalid_endpoint_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    	programRequest.programPost(sheetName, testCaseID, requestSpecification);
    	 this.response = programRequest.getResponse();
    	
    }

    @Then("The Admin get invalid endpoint response code and message as {string} and {string} for Program")
    public void the_admin_get_invalid_endpoint_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
    	commonRequest.validateStatusCode(response, testData);
    	commonRequest.validateStatusLine(response, testData);
        commonRequest.validateResponseTime(response);

        }
    //--------------POST request for existing ProgramName------------
    
    @When("The Admin sends HTTPS POST request for existing ProgramName scenarios as input {string} and {string} for Program")
    public void the_admin_sends_https_post_request_for_existing_program_name_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    	programRequest.programPost(sheetName, testCaseID, requestSpecification);
        this.response = programRequest.getResponse(); 
        
    }

    @Then("The Admin get existing ProgramName response code and message as {string} and {string} for Program")
    public void the_admin_get_existing_program_name_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
    	commonRequest.validateStatusCode(response, testData);
    	commonRequest.validateStatusLine(response, testData);
        commonRequest.validateResponseTime(response);
        
    }

    //---------------POST request for invalid Method------------------
    
    @When("The Admin sends HTTPS POST request for invalid Method scenarios as input {string} and {string} for Program")
    public void the_admin_sends_https_post_request_for_invalid_method_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
        programRequest.programPost(sheetName, testCaseID, requestSpecification);
        this.response = programRequest.getResponse(); 
    }

    @Then("The Admin get invalid Method response code and message as {string} and {string} for Program")
    public void the_admin_get_invalid_method_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
       	commonRequest.validateStatusCode(response, testData);
    	commonRequest.validateStatusLine(response, testData);
        commonRequest.validateResponseTime(response);
    }

    //------------------POST request for invalid RequestBody-----------------
    
    @When("The Admin sends HTTPS POST request for invalid RequestBody scenarios as input {string} and {string} for Program")
    public void the_admin_sends_https_post_request_for_invalid_request_body_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    	programRequest.programPost(sheetName, testCaseID, requestSpecification);
        this.response = programRequest.getResponse(); 
        
    }

    @Then("The Admin get invalid RequestBody response code and message as {string} and {string} for Program")
    public void the_admin_get_invalid_request_body_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
    	commonRequest.validateStatusCode(response, testData);
    	commonRequest.validateStatusLine(response, testData);
        commonRequest.validateResponseTime(response);
        
    }

    //---------------------POST request for missingMandatoryField--------------------
    
    @When("The Admin sends HTTPS POST request for missingMandatoryField scenarios as input {string} and {string} for Program")
    public void the_admin_sends_https_post_request_for_missing_mandatory_field_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    	programRequest.programPost(sheetName, testCaseID, requestSpecification);
        this.response = programRequest.getResponse(); 
        
    }

    @Then("The Admin get missingMandatoryField response code and message as {string} and {string} for Program")
    public void the_admin_get_missing_mandatory_field_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
    	commonRequest.validateStatusCode(response, testData);
    	commonRequest.validateStatusLine(response, testData);
        commonRequest.validateResponseTime(response);
        
    }
    
    //-------------------POST request for missingAdditionalField--------------

    @When("The Admin sends HTTPS POST request for missingAdditionalField scenarios as input {string} and {string} for Program")
    public void the_admin_sends_https_post_request_for_missing_additional_field_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    	programRequest.programPost(sheetName, testCaseID, requestSpecification);
        this.response = programRequest.getResponse();
        
    }

    @Then("The Admin get missingAdditionalField response code and message as {string} and {string} for Program")
    public void the_admin_get_missing_additional_field_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
    	commonRequest.validateStatusCode(response, testData);
        commonRequest.validateStatusLine(response, testData);
        commonRequest.validateContentType(response, testData);
        commonRequest.validateResponseTime(response);
        commonRequest.validateSchema(response, "Schema/program/createprogramSchema.json");
    }
    
    //----------------POST request for No Payload----------------------
    
    @When("The Admin sends HTTPS POST request for No Payload scenarios as input {string} and {string} for Program")
    public void the_admin_sends_https_post_request_for_no_payload_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    	programRequest.programPostNoPayload(sheetName, testCaseID, requestSpecification);
        this.response = programRequest.getResponse();
        
    }

    @Then("The Admin get No Payload response code and message as {string} and {string} for Program")
    public void the_admin_get_no_payload_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
   
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
    	commonRequest.validateStatusCode(response, testData);
    	commonRequest.validateStatusLine(response, testData);
        commonRequest.validateResponseTime(response);
    }
    
    
    
    
    
  //*************************  ProgramGetFunctionality****************
    
    //--------------Get_allPrograms valid----------------
    
    @When("The Admin sends HTTPS Get request for Get_allPrograms valid scenarios as input {string} and {string} for program")
    public void the_admin_sends_https_get_request_for_get_all_programs_valid_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    programRequest.GetallProgramandGetallprogramswithUsers(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
       
    }

    @Then("The Admin get Get_allPrograms valid response code and message as {string} and {string} for get program")
    public void the_admin_get_get_all_programs_valid_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
         commonRequest.validateStatusCode(response, testData);
         commonRequest.validateStatusLine(response, testData);
         commonRequest.validateContentType(response, testData);
         commonRequest.validateResponseTime(response);
         commonRequest.validateSchema(response, "Schema/program/getallprogramSchema.json");
         
        
       
    }

    //----------------Get_allPrograms invalid Endpoint-----------------
    
    

@When("The Admin sends HTTPS Get request for Get_allPrograms invalid Endpoint scenarios as input {string} and {string} for program invalid")
public void the_admin_sends_https_get_request_for_get_all_programs_invalid_endpoint_scenarios_as_input_and_for_program_invalid(String sheetName, String testCaseID) throws IOException {
	programRequest.GetallProgramandGetallprogramswithUsers(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
}

@Then("The Admin get response code and message as {string} and {string} for get program invalid")
public void the_admin_get_response_code_and_message_as_and_for_get_program_invalid(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
   
}
   
    //----------------Get_allPrograms invalid Method-----------------
@When("The Admin sends HTTPS Get request for Get_allPrograms invalid Method scenarios as input {string} and {string} for program invalid")
public void the_admin_sends_https_get_request_for_get_all_programs_invalid_method_scenarios_as_input_and_for_program_invalid(String sheetName, String testCaseID) throws IOException {
	programRequest.GetallProgramandGetallprogramswithUsers(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
}

    //--------Get_allPrograms_Users valid-------------------
    
    @When("The Admin sends HTTPS Get request for Get_allPrograms_Users valid scenarios as input {string} and {string} for program")
    public void the_admin_sends_https_get_request_for_get_all_programs_users_valid_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    	programRequest.GetallProgramandGetallprogramswithUsers(sheetName, testCaseID, requestSpecification);
        this.response = programRequest.getResponse();
       
    }

    @Then("The Admin get Get_allPrograms_Users valid response code and message as {string} and {string} for get program")
    public void the_admin_get_get_all_programs_users_valid_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
       
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
        commonRequest.validateStatusCode(response, testData);
        commonRequest.validateStatusLine(response, testData);
        commonRequest.validateContentType(response, testData);
        commonRequest.validateResponseTime(response);
        commonRequest.validateSchema(response, "Schema/program/getProgrambyallUsers.json");
    	
    }
    
    //--------------Get_allPrograms_Users invaid Endpoint-----------

@When("The Admin sends HTTPS Get request for Get_allPrograms_Users invaid Endpoint scenarios as input {string} and {string} for program invalid")
public void the_admin_sends_https_get_request_for_get_all_programs_users_invaid_endpoint_scenarios_as_input_and_for_program_invalid(String sheetName, String testCaseID) throws IOException {
	programRequest.GetallProgramandGetallprogramswithUsers(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
}
    //------------------------Get_allPrograms_Users invalid Method------------------------

@When("The Admin sends HTTPS Get request for Get_allPrograms_Users invalid Method scenarios as input {string} and {string} for program invalid")
public void the_admin_sends_https_get_request_for_get_all_programs_users_invalid_method_scenarios_as_input_and_for_program_invalid(String sheetName, String testCaseID) throws IOException {
	programRequest.GetallProgramandGetallprogramswithUsers(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
}
        //------------------Get_Program_ProgramId valid ProgramId---------------------

    @When("The Admin sends HTTPS Get request for Get_Program_ProgramId valid ProgramId scenarios as input {string} and {string} for program")
    public void the_admin_sends_https_get_request_for_get_program_program_id_valid_program_id_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    programRequest.GetProgramByProgramId(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
       
    }

    @Then("The Admin get Get_Program_ProgramId valid ProgramId response code and message as {string} and {string} for get program")
    public void the_admin_get_get_program_program_id_valid_program_id_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
    	commonRequest.validateStatusCode(response, testData);
    	commonRequest.validateContentType(response, testData);
        commonRequest.validateResponseTime(response);
        commonRequest.validateSchema(response, "Schema/program/createprogramSchema.json");
       
    }
    
   //--------------------------Get_Program_ProgramId invalid ProgramId---------------
    
    @When("The Admin sends HTTPS Get request for Get_Program_ProgramId invalid ProgramId scenarios as input {string} and {string} for program invalid")
    public void the_admin_sends_https_get_request_for_get_program_program_id_invalid_program_id_scenarios_as_input_and_for_program_invalid(String sheetName, String testCaseID) throws IOException {
    	programRequest.GetProgramByProgramId(sheetName, testCaseID, requestSpecification);
    	this.response = programRequest.getResponse();
    }

    
    //-------------Get_Program_ProgramId invaid Endpoint-----------

    @When("The Admin sends HTTPS Get request for Get_Program_ProgramId invaid Endpoint scenarios as input {string} and {string} for program invalid")
    public void the_admin_sends_https_get_request_for_get_program_program_id_invaid_endpoint_scenarios_as_input_and_for_program_invalid(String sheetName, String testCaseID) throws IOException {
    	programRequest.GetProgramByProgramId(sheetName, testCaseID, requestSpecification);
    	this.response = programRequest.getResponse();
    }

       
    
    
    
    
  //****************************************        Put Program         ************************************************************************************** 
    
  //----------------PUT request for valid update byProgrameName------- 

@When("The Admin sends HTTPS PUT request for valid update byProgrameName scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_valid_update_by_programe_name_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
    
}

@Then("The Admin get valid update byProgrameName response code and message as {string} and {string} for update Program")
public void the_admin_get_valid_update_by_programe_name_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	Program_POJO expectedprogramData = programRequest.getProgramRequestBody();
    commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateContentType(response, testData);
    commonRequest.validateResponseTime(response);
    commonRequest.validateSchema(response, "Schema/program/createprogramSchema.json");
    ProgramRequest.validateDataForProgram(expectedprogramData, response);
    
}

//---------------update by invalid ProgramName inPath----------------

@When("The Admin sends HTTPS PUT request for update by invalid ProgramName inPath scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_invalid_program_name_in_path_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
    
}


@Then("The Admin get update by invalid ProgramName inPath response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_invalid_program_name_in_path_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData); 
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}

//--------------------update by missing ProgramName---------------

@When("The Admin sends HTTPS PUT request for update by missing ProgramName scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_missing_program_name_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
   programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification); 
   this.response = programRequest.getResponse(); 
}

@Then("The Admin get update by missing ProgramName response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_missing_program_name_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}

//------------------update by invalid ProgramNameField-----------------

@When("The Admin sends HTTPS PUT request for update by invalid ProgramNameField scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_invalid_program_name_field_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification); 
	   this.response = programRequest.getResponse(); 
}

@Then("The Admin get update by invalid ProgramNameField response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_invalid_program_name_field_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
    
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
}

//--------------------update by invalid ProgramDescrip------------------

@When("The Admin sends HTTPS PUT request for update by invalid ProgramDescrip scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_invalid_program_descrip_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification); 
	   this.response = programRequest.getResponse(); 
    
}

@Then("The Admin get update by invalid ProgramDescrip response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_invalid_program_descrip_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData); 
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}

//--------------PUT request for update status---------------
@When("The Admin sends HTTPS PUT request for update status scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_status_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification); 
	   this.response = programRequest.getResponse(); 
    
}

@Then("The Admin get update status response code and message as {string} and {string} for update Program")
public void the_admin_get_update_status_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateContentType(response, testData);
    commonRequest.validateResponseTime(response);
    commonRequest.validateSchema(response, "Schema/program/createprogramSchema.json");
    
}

//--------update by invalidEndpoint------------------------

@When("The Admin sends HTTPS PUT request for update by invalidEndpoint scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_invalid_endpoint_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification); 
	   this.response = programRequest.getResponse(); 
    
}

@Then("The Admin get update by invalidEndpoint response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_invalid_endpoint_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData); 
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}
//-----------------update by missingMandatoryField-----------------

@When("The Admin sends HTTPS PUT request for update by missingMandatoryField scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_missing_mandatory_field_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification); 
	   this.response = programRequest.getResponse(); 
    
}

@Then("The Admin get update by missingMandatoryField response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_missing_mandatory_field_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData); 
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
}

//--------------valid update program byprogramId ---------------

@When("The Admin sends HTTPS PUT request for valid update program byprogramId scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_valid_update_program_byprogram_id_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
    
    
}

@Then("The Admin get valid update program byprogramId response code and message as {string} and {string} for update Program")
public void the_admin_get_valid_update_program_byprogram_id_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
    
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	Program_POJO expectedprogramData = programRequest.getProgramRequestBody();
    commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateContentType(response, testData);
    commonRequest.validateResponseTime(response);
    commonRequest.validateSchema(response, "Schema/program/createprogramSchema.json");
    ProgramRequest.validateDataForProgram(expectedprogramData, response);
}

//----------------update by invalid ProgramIdinPath---------------

@When("The Admin sends HTTPS PUT request for update by invalid ProgramIdinPath scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_invalid_program_idin_path_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
}

@Then("The Admin get update by invalid ProgramIdinPath response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_invalid_program_idin_path_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
    
}

//--------------------update by invalid Postbody---------------
@When("The Admin sends HTTPS PUT request for update by invalid Postbody scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_invalid_postbody_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
    
}

@Then("The Admin get update by invalid Postbody response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_invalid_postbody_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}

//---------------update by without payload---------------------

@When("The Admin sends HTTPS PUT request for update by without payload scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_without_payload_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.programUpdateNoPayload(sheetName, testCaseID, requestSpecification);
	this.response = programRequest.getResponse(); 
}

@Then("The Admin get update by without payload response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_without_payload_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}
//-------------------update by invalid Method-------------------

@When("The Admin sends HTTPS PUT request for update by invalid Method scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_invalid_method_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
	this.response = programRequest.getResponse(); 
}

@Then("The Admin get update by invalid Method response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_invalid_method_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData); 
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}

//-----------------update by missing ProgramId inPath-------------

@When("The Admin sends HTTPS PUT request for update by missing ProgramId inPath scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_by_missing_program_id_in_path_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
    
    
}

@Then("The Admin get update by missing ProgramId inPath response code and message as {string} and {string} for update Program")
public void the_admin_get_update_by_missing_program_id_in_path_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}

///***********update to change the staus active******************

@When("The Admin sends HTTPS PUT request for update status active byprogramId scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_update_status_active_byprogram_id_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
}

@Then("The Admin get update status active byprogramId response code and message as {string} and {string} for update Program")
public void the_admin_get_update_status_active_byprogram_id_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData); 
	commonRequest.validateContentType(response, testData);
    commonRequest.validateResponseTime(response);
    
    
}


@When("The Admin sends HTTPS PUT request for valid update byProgrameName invalidmethod scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_put_request_for_valid_update_by_programe_name_invalidmethod_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
}

@Then("The Admin get valid update byProgrameName invalidmethod response code and message as {string} and {string} for update Program")
public void the_admin_get_valid_update_by_programe_name_invalidmethod_response_code_and_message_as_and_for_update_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData); 
	commonRequest.validateContentType(response, testData);
    commonRequest.validateResponseTime(response);
    
}


//*************************************Delete Program************************************************************************************
    


@When("The Admin sends HTTPS DELETE request for delete valid ProgramId scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_delete_request_for_delete_valid_program_id_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.DeleteByProgrameNameandId(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
    
}


@Then("The Admin get response code and message as {string} and {string} for delete Program")
public void the_admin_get_response_code_and_message_as_and_for_delete_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}

@When("The Admin sends HTTPS DELETE request for delete Invalid ProgramId scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_delete_request_for_delete_invalid_program_id_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.DeleteByProgrameNameandId(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
    
    
}

@When("The Admin sends HTTPS DELETE request for delete valid ProgramName scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_delete_request_for_delete_valid_program_name_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.DeleteByProgrameNameandId(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
    
}

@When("The Admin sends HTTPS DELETE request for delete Invalid ProgramName scenarios as input {string} and {string} for Program")
public void the_admin_sends_https_delete_request_for_delete_invalid_program_name_scenarios_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.DeleteByProgrameNameandId(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
}


//------------------------------------------------------------------------------------------------------------------------------------------------------
//put to change status

@When("The Admin sends HTTPS PUT request to change status as {string} and {string} for Program")
public void the_admin_sends_https_put_request_to_change_status_as_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification); 
	   this.response = programRequest.getResponse(); 
    
}


//----------------------------------------------------------------------------------------------------------------------------------------------

//TC_01_program_noAuth Unauthorized Scenarios createprogram



@When("The Admin sends createprogram request with no auth as input {string} and {string} for program")
public void the_admin_sends_createprogram_request_with_no_auth_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.programPost(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
    
}

@Then("The Admin gets response code and message as {string} and {string} for program")
public void the_admin_gets_response_code_and_message_as_and_for_program(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
    commonRequest.validateResponseTime(response);
    
}

@When("The Admin sends program_get_allprogramlist request with no auth as input {string} and {string} for program")
public void the_admin_sends_program_get_allprogramlist_request_with_no_auth_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.GetallProgramandGetallprogramswithUsers(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
    
}

@When("The Admin sends program_get_Get_allPrograms_Users request with no auth as input {string} and {string} for program")
public void the_admin_sends_program_get_get_all_programs_users_request_with_no_auth_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.GetallProgramandGetallprogramswithUsers(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
    
}

@When("The Admin sends program_Get_Program_ProgramId request with no auth as input {string} and {string} for program")
public void the_admin_sends_program_get_program_program_id_request_with_no_auth_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.GetProgramByProgramId(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
    
}

@When("The Admin sends program_put_byProgramId request with no auth as input {string} and {string} for program")
public void the_admin_sends_program_put_by_program_id_request_with_no_auth_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
}

@When("The Admin sends program_put_byprogramName request with no auth as input {string} and {string} for program")
public void the_admin_sends_program_put_byprogram_name_request_with_no_auth_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.updateByProgramIdandProgramName(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
    
}

@When("The Admin sends program_delete_byProgramId request with no auth as input {string} and {string} for program")
public void the_admin_sends_program_delete_by_program_id_request_with_no_auth_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.DeleteByProgrameNameandId(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
    
}

@When("The Admin sends program_delete_byprogramName request with no auth as input {string} and {string} for program")
public void the_admin_sends_program_delete_byprogram_name_request_with_no_auth_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
    
	programRequest.DeleteByProgrameNameandId(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse();
}


//--------------------------------------------------------------------------------------------------------------------------
//invalid url
@When("The Admin sends createclass request with invalid url as input {string} and {string} for program")
public void the_admin_sends_createclass_request_with_invalid_url_as_input_and_for_program(String sheetName, String testCaseID) throws IOException {
	programRequest.programPost(sheetName, testCaseID, requestSpecification);
    this.response = programRequest.getResponse(); 
    
}




















    }