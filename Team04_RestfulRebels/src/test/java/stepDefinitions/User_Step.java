package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import requestBuilder.ClassRequest;
import requestBuilder.CommonRequest;
import requestBuilder.UserRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Class_POJO;
import payload.User_POJO;

import java.io.IOException;
import java.util.Map;

import common.ExcelReader;
import common.Utils;



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
public void the_admin_get_valid_data_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	User_POJO expectedClassData = userRequest.getuserRequestBody();
	 commonRequest.validateStatusCode(response, testData);
	 commonRequest.validateStatusLine(response, testData);
	 UserRequest.validateDataUserPost(expectedClassData, response);
	 commonRequest.validateSchema(response, "/Schema/User/CreateNewUser_Post.json");
}
@When("The Admin sends HTTPS POST request for mandatory fields scenarios as input {string} and {string} for User")
public void the_admin_sends_https_post_request_for_mandatory_fields_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.userPost(sheetName, testCaseID, requestSpecification);
	 this.response = userRequest.getResponse();  
}

@Then("The Admin get mandatory fields response code and message as {string} and {string} for User")
public void the_admin_get_mandatory_fields_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
   commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS POST request for additional fields scenarios as input {string} and {string} for User")
public void the_admin_sends_https_post_request_for_additional_fields_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.userPost(sheetName, testCaseID, requestSpecification);
	 this.response = userRequest.getResponse();  
}

@Then("The Admin get additional fields response code and message as {string} and {string} for User")
public void the_admin_get_additional_fields_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
  commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS POST request for invalid data scenarios as input {string} and {string} for User")
public void the_admin_sends_https_post_request_for_invalid_data_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.userPost(sheetName, testCaseID, requestSpecification);
	 this.response = userRequest.getResponse();  
}

@Then("The Admin get invalid data response code and message as {string} and {string} for User")
public void the_admin_get_invalid_data_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
  commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS POST request for existing phn num scenarios as input {string} and {string} for User")
public void the_admin_sends_https_post_request_for_existing_phn_num_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.userPost(sheetName, testCaseID, requestSpecification);
	 this.response = userRequest.getResponse();  
}

@Then("The Admin get existing phn num response code and message as {string} and {string} for User")
public void the_admin_get_existing_phn_num_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
  commonRequest.validateStatusLine(response, testData);
}



@When("The Admin sends HTTPS POST request for invalid endpoint scenarios as input {string} and {string} for User")
public void the_admin_sends_https_post_request_for_invalid_endpoint_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.userPost(sheetName, testCaseID, requestSpecification);
	 this.response = userRequest.getResponse();  
}

@Then("The Admin get invalid endpoint response code and message as {string} and {string} for User")
public void the_admin_get_invalid_endpoint_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
  commonRequest.validateStatusLine(response, testData);
}



@When("The Admin sends HTTPS Get request for Get all users valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_all_users_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get all users valid response code and message as {string} and {string} for User")
public void the_admin_get_get_all_users_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
	//commonRequest.validateSchema(response, "Schema/User/user_get_allusers.json");
	 
}

@When("The Admin sends HTTPS Get request for Get by user id valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_by_user_id_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get by user id valid response code and message as {string} and {string} for User")
public void the_admin_get_get_by_user_id_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
	 commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS Get request for Get all users with roles valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_all_users_with_roles_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get all users with roles valid response code and message as {string} and {string} for User")
public void the_admin_get_get_all_users_with_roles_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 commonRequest.validateStatusCode(response, testData);
	 commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS Get request for Get all active users valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_all_active_users_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get all active users valid response code and message as {string} and {string} for User")
public void the_admin_get_get_all_active_users_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}
@When("The Admin sends HTTPS Get request for Get emails of all users valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_emails_of_all_users_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get emails of all users valid response code and message as {string} and {string} for User")
public void the_admin_get_get_emails_of_all_users_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS Get request for Get all roles valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_all_roles_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get all roles valid response code and message as {string} and {string} for User")
public void the_admin_get_get_all_roles_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
	//commonRequest.validateSchema(response, "/Schema/User/Get_AllUsers.json");
}

@When("The Admin sends HTTPS Get request for Get count of A\\/I users valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_count_of_a_i_users_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get count of A\\/I users valid response code and message as {string} and {string} for User")
public void the_admin_get_get_count_of_a_i_users_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS Get request for Get user by pgm batches valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_user_by_pgm_batches_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get user by pgm batches valid response code and message as {string} and {string} for User")
public void the_admin_get_get_user_by_pgm_batches_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS Get request for Get users for program valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_users_for_program_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get users for program valid response code and message as {string} and {string} for User")
public void the_admin_get_get_users_for_program_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS Get request for Get users by role id valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_users_by_role_id_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get users by role id valid response code and message as {string} and {string} for User")
public void the_admin_get_get_users_by_role_id_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS Get request for Get users by role id V2 valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_get_users_by_role_id_v2_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.getAllUsers(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get Get users by role id V2 valid response code and message as {string} and {string} for User")
public void the_admin_get_get_users_by_role_id_v2_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}


@When("The Admin sends HTTPS Put request for update user by userid valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_update_user_by_userid_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.updateUserByUserId(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
	
}

@Then("The Admin get update user by userid valid response code and message as {string} and {string} for User")
public void the_admin_get_update_user_by_userid_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}
@When("The Admin sends HTTPS Put request for update user by userid invalid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_update_user_by_userid_invalid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.updateUserByInvalidUserId(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get update user by userid invalid response code and message as {string} and {string} for User")
public void the_admin_get_update_user_by_userid_invalid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS Put request for update user by userid missing required field scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_update_user_by_userid_missing_required_field_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.updateUserByUserId(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get update user by userid missing required field response code and message as {string} and {string} for User")
public void the_admin_get_update_user_by_userid_missing_required_field_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}
@When("The Admin sends HTTPS Put request for update userrole status valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_update_userrole_status_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.updateUserByUserRoleId(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get update userrole status valid response code and message as {string} and {string} for User")
public void the_admin_get_update_userrole_status_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS Put request for assign user to pgm batch valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_assign_user_to_pgm_batch_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.updateUserByPgmBatch(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get assign user to pgm batch valid response code and message as {string} and {string} for User")
public void the_admin_get_assign_user_to_pgm_batch_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}


@When("The Admin sends HTTPS Put request for assign user to pgm batch invalid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_get_request_for_assign_user_to_pgm_batch_invalid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.updateUserByPgmBatch(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get assign user to pgm batch invalid response code and message as {string} and {string} for User")
public void the_admin_get_assign_user_to_pgm_batch_invalid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}
	
@When("The Admin sends HTTPS Put request for assign user to pgm batch missing required field scenarios as input {string} and {string} for User")
public void the_admin_sends_https_put_request_for_assign_user_to_pgm_batch_missing_required_field_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.updateUserByPgmBatch(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get assign user to pgm batch missing required field response code and message as {string} and {string} for User")
public void the_admin_get_assign_user_to_pgm_batch_missing_required_field_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
	commonRequest.validateStatusLine(response, testData);
}

//------------------------Delete--------------------
	
	
@When("The Admin sends HTTPS Delete request for valid userID scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_delete_request_for_valid_user_id_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	userRequest.deleteUser(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
	 Utils.remove("userId");
}

@Then("The Admin get <Endpoint> valid userID response code and message as {string} and {string} for Class")
public void the_admin_get_endpoint_valid_user_id_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
   
}
	
@When("The Admin sends HTTPS Delete request for invalid userID scenarios as input {string} and {string} for Class")
public void the_admin_sends_https_delete_request_for_invalid_user_id_scenarios_as_input_and_for_class(String sheetName, String testCaseID) throws IOException {
	userRequest.deleteUser(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get <Endpoint> invalid userID response code and message as {string} and {string} for Class")
public void the_admin_get_endpoint_invalid_user_id_response_code_and_message_as_and_for_class(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
}

@When("The Admin sends HTTPS Put request for update user login valid scenarios as input {string} and {string} for User")
public void the_admin_sends_https_put_request_for_update_user_login_status_valid_scenarios_as_input_and_for_user(String sheetName, String testCaseID) throws IOException {
	userRequest.updateUserLoginStatus(sheetName, testCaseID, requestSpecification);
	this.response = userRequest.getResponse();
}

@Then("The Admin get update user login valid response code and message as {string} and {string} for User")
public void the_admin_get_update_user_login_status_valid_response_code_and_message_as_and_for_user(String sheetName, String testCaseID) throws IOException {
	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	commonRequest.validateStatusCode(response, testData);
    commonRequest.validateStatusLine(response, testData);
}



}

	
	
	
	
	
	
	
	
	

