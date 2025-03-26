package requestBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import common.ExcelReader;
import common.LoggerLoad;
import common.TestContext;
import common.Utils;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Program_POJO;
import payload.User_POJO;
import payload.User_PUT_POJO;
import payload.User_UpdatePgmBatch_PUT_POJO;
import payload.User_UpdateRole_PUT_POJO;

public class UserRequest {
    
	private User_POJO user_POJO;
	private User_PUT_POJO update_user_POJO;
	private User_UpdateRole_PUT_POJO updateUserRole_POJO;
	private User_UpdatePgmBatch_PUT_POJO user_UpdatePgmBatch_PUT_POJO;
	private RequestSpecification requestspecification;
	private Response response;

	public UserRequest() {
		this.user_POJO = new User_POJO();
		this.update_user_POJO = new User_PUT_POJO();
		this.updateUserRole_POJO = new User_UpdateRole_PUT_POJO();
		this.user_UpdatePgmBatch_PUT_POJO = new User_UpdatePgmBatch_PUT_POJO();

	}

	public void userPostRequsetBody(String sheetName, String testCaseID) throws IOException {
		// Fetch test data from Excel
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);

		// Handle userComments
		user_POJO.setUserComments(testData.get("userComments"));

		// Handle userEduPg
		user_POJO.setUserEduPg(testData.get("userEduPg"));

		// Handle userEduUg
		user_POJO.setUserEduUg(testData.get("userEduUg"));

		// Handle first and last names
		user_POJO.setUserFirstName(testData.get("userFirstName"));
		user_POJO.setUserLastName(testData.get("userLastName"));

		// Handle LinkedIn URL
		user_POJO.setUserLinkedinUrl(testData.get("userLinkedinUrl"));

		// Handle location and middle name
		user_POJO.setUserLocation(testData.get("userLocation"));
		user_POJO.setUserMiddleName(testData.get("userMiddleName"));

		// Handle phone number
		user_POJO.setUserPhoneNumber(testData.get("userPhoneNumber"));

		// Handle userRoleMaps (List of roles)
		String roleIdStr = testData.get("roleId");
		String roleStatusStr = testData.get("userRoleStatus");
		if (roleIdStr != null && roleStatusStr != null) {
			user_POJO.setUserRoleMaps(List.of(new User_POJO.UserRoleMap(roleIdStr, roleStatusStr)));
		} else {
			LoggerLoad.info("RoleId or UserRoleStatus is empty or null");
		}

		// Handle timezone and visa status
		user_POJO.setUserTimeZone(testData.get("userTimeZone"));
		user_POJO.setUserVisaStatus(testData.get("userVisaStatus"));

		// Handle user login details
		String loginEmail = testData.get("userLoginEmail");
		String loginStatus = testData.get("loginStatus");
		if (loginEmail != null && loginStatus != null) {
			user_POJO.setUserLogin(new User_POJO.UserLogin(loginStatus, loginEmail));
		} else {
			LoggerLoad.info("LoginEmail or LoginStatus is empty or null");
		}
	}

	public void userPutRequestBody(String sheetName, String testCaseID) throws IOException {
		// Fetch test data from Excel
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);

		// Handle userComments
		update_user_POJO.setUserComments(testData.get("userComments"));

		// Handle userEduPg
		update_user_POJO.setUserEduPg(testData.get("userEduPg"));

		// Handle userEduUg
		update_user_POJO.setUserEduUg(testData.get("userEduUg"));

		// Handle first and last names
		update_user_POJO.setUserFirstName(testData.get("userFirstName"));
		update_user_POJO.setUserLastName(testData.get("userLastName"));
		
		System.out.println("---Entering getting userId from dataStore-----");
		update_user_POJO.setUserId(Utils.get("userId", String.class));
		System.out.println("---getting userId from dataStore-----");

		//Utils.get("userId", user_POJO.setUpdateUserId("updateUserId"));

		// Handle LinkedIn URL
		update_user_POJO.setUserLinkedinUrl(testData.get("userLinkedinUrl"));

		// Handle location and middle name
		update_user_POJO.setUserLocation(testData.get("userLocation"));
		update_user_POJO.setUserMiddleName(testData.get("userMiddleName"));

		
		update_user_POJO.setUserLoginEmail(testData.get("userLoginEmail"));
		
		update_user_POJO.setUserPhoneNumber(testData.get("userPhoneNumber"));
		
		update_user_POJO.setUserVisaStatus(testData.get("userVisaStatus"));
		
		update_user_POJO.setUserTimeZone(testData.get("userTimeZone"));
		

	}

	public void userPutRoleIdBody(String sheetName, String testCaseID) throws IOException {
		// Fetch test data from Excel
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		
		
		
		// Handle userRoleMaps (List of roles)
				String roleIdStr = testData.get("roleId");
				String roleStatusStr = testData.get("userRoleStatus");
				if (roleIdStr != null && roleStatusStr != null) {
					updateUserRole_POJO.setUserRoleList(List.of(new User_UpdateRole_PUT_POJO.UserRoleList(roleIdStr, roleStatusStr)));
				} else {
					LoggerLoad.info("RoleId or UserRoleStatus is empty or null");
				}
		
	}
	
	public void userPutPgmBatchRequestBody(String sheetName, String testCaseID) throws IOException {
		// Fetch test data from Excel
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		
		
		//int storedPgmId= Utils.get("programId", Integer.class);
		int storedPgmId = 18971;
		int storedBatchId = 11632;
	//	int storedBatchId = Utils.get("batchId", Integer.class);
		String storedUserId = Utils.get("userId", String.class);
		
		
		//Handle pgmId
	/*	String programIdString = testData.get("programId");
		try {
		    // Try to convert the String to int
		    int programId = Integer.parseInt(programIdString);
		    user_UpdatePgmBatch_PUT_POJO.setProgramId(programId);
		} catch (NumberFormatException e) {
		    // Handle the case where the programId is not a valid integer
		    System.out.println("Invalid programId value: " + programIdString);
		    // Optionally, you can throw a custom exception or handle it as needed
		    
		}*/
		
		if("byinvaliduserId".equalsIgnoreCase((testData.get("usecase")))){
			String invalidUserId = "11111";
			user_UpdatePgmBatch_PUT_POJO.setUserId(invalidUserId);
			
		}else if("validuserId".equalsIgnoreCase((testData.get("usecase")))) {
			user_UpdatePgmBatch_PUT_POJO.setUserId(storedUserId);
		}
		
		 user_UpdatePgmBatch_PUT_POJO.setProgramId(storedPgmId);
		
		user_UpdatePgmBatch_PUT_POJO.setRoleId(testData.get("roleId"));
		
		
		
		
		
		
		 
		
		 
		
	/*	String batchidStr = testData.get("batchId");
		int batchId = 0;
		try {
		    // Try to convert the String to int
		     batchId = Integer.parseInt(batchidStr);
		    user_UpdatePgmBatch_PUT_POJO.setProgramId(batchId);
		} catch (NumberFormatException e) {
		    // Handle the case where the programId is not a valid integer
		    System.out.println("Invalid programId value: " + batchidStr);
		    // Optionally, you can throw a custom exception or handle it as needed
		    
		}*/
		
		String batchStatus = testData.get("userRoleProgramBatchStatus");
		
		if (storedBatchId != 0 && batchStatus != null) {
		user_UpdatePgmBatch_PUT_POJO.setUserRoleProgramBatches(List.of(new User_UpdatePgmBatch_PUT_POJO.UserRoleProgramBatches(storedBatchId, batchStatus)));
		}else {
			LoggerLoad.info("BatchId or BatchStatus is empty or null");
		}
	}

	
	public User_POJO getuserRequestBody() {
		return user_POJO;
	}
	
	public User_PUT_POJO getuserbodyforUpdate() {
		return update_user_POJO;
	}
	
	public User_UpdateRole_PUT_POJO getuserbodyforUpdateRoleId() {
		return updateUserRole_POJO;
	}
	
	public User_UpdatePgmBatch_PUT_POJO getuserbodyforUpdatePgmBatch() {
		return user_UpdatePgmBatch_PUT_POJO;
	}

	public void setEndpointPostUser(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
			user_POJO.setEndpoint(testData.get("Endpoint")); // Set endpoint in user_POJO
		} else {
			String method = testData.get("Method");
			switch (method.toLowerCase()) {
			case "post":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_POST.getPath());
				break;

			case "get_all_users":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_AllUsers.getPath());
				break;

			case "get_all_active_users":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_AllActiveUser.getPath());
				break;

			case "get_emailsof_alluserswith_activestatus":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_emailsofalluserswithActivestatus.getPath());
				break;

			case "get_allroles":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_AllRoles.getPath());
				break;

			case "get_userinformation_byuserid":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_Userinformation_byUserId.getPath());
				break;

			case "get_all_userswithroles":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_all_UsersWithRoles.getPath());
				break;

			case "get_countof_active_and_inactiveusers":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_CountOfActiveandInActiveUsers.getPath());
				break;

			case "get_userby_programbatches":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_Userby_ProgramBatches.getPath());
				break;

			case "get_usersfor_program":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_UsersforProgram.getPath());
				break;

			case "get_userby_roleid":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_UserBy_RoleId.getPath());
				break;

			case "get_userbyroleid_v2":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_UserByRoleId_V2.getPath());
				break;

			case "deletebyuserid":
				user_POJO.setEndpoint(enumPackage.Endpoint.User_DELETE_ByUserId.getPath());
				break;

			default:
				LoggerLoad.info("Unknown method -> " + method);
				throw new IllegalArgumentException("Invalid method: " + method);

			}
		}
		
			LoggerLoad.info(" Endpoint set to -> " + user_POJO.getEndpoint());
		}
		
	

	public void setEndpointPutUser(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
			update_user_POJO.setEndpoint(testData.get("Endpoint")); // Set endpoint in user_POJO
		} else {
			String method = testData.get("Method");
			switch (method.toLowerCase()) {
			case "put_byuserid":
				update_user_POJO.setEndpoint(enumPackage.Endpoint.User_PUT_byUserId.getPath());
				break;


			case "put_byuserrolepgmbatchStatus":
				update_user_POJO.setEndpoint(enumPackage.Endpoint.User_PUT_byUserRolePgmBatchStatus.getPath());
				break;

			case "put_updateuserloginstatus":
				update_user_POJO.setEndpoint(enumPackage.Endpoint.User_PUT_UpdateUserLoginStatus.getPath());
				break;
				
			default:
				LoggerLoad.info("Unknown method -> " + method);
				throw new IllegalArgumentException("Invalid method: " + method);
			}
			}
		LoggerLoad.info(" Endpoint set to -> " + update_user_POJO.getEndpoint());
			}
	
	
	public void setEndpointPutUserRoleId(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
			updateUserRole_POJO.setEndpoint(testData.get("Endpoint")); // Set endpoint in user_POJO
		} else {
			String method = testData.get("Method");
			switch (method.toLowerCase()) {
			case "put_byroleid":
				updateUserRole_POJO.setEndpoint(enumPackage.Endpoint.User_PUT_byRoleId.getPath());
				break;
				
			default:
				LoggerLoad.info("Unknown method -> " + method);
				throw new IllegalArgumentException("Invalid method: " + method);
			}
			}
		LoggerLoad.info(" Endpoint set to -> " + updateUserRole_POJO.getEndpoint());
			}
	
	public void setEndpointPutUserPgmBatch(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
			user_UpdatePgmBatch_PUT_POJO.setEndpoint(testData.get("Endpoint")); // Set endpoint in user_POJO
		} else {
			String method = testData.get("Method");
			switch (method.toLowerCase()) {


			case "put_byuserrolepgmbatchstatus":
				user_UpdatePgmBatch_PUT_POJO.setEndpoint(enumPackage.Endpoint.User_PUT_byUserRolePgmBatchStatus.getPath());
				break;

				
			default:
				LoggerLoad.info("Unknown method -> " + method);
				throw new IllegalArgumentException("Invalid method: " + method);
			}
			}
		LoggerLoad.info(" Endpoint set to -> " + user_UpdatePgmBatch_PUT_POJO.getEndpoint());
			}
	
	
	public String getEndpoint() {
		return user_POJO.getEndpoint();
	}
	
	public String getEndpointforUpdateUser() {
		return update_user_POJO.getEndpoint();
	}
	
	public String getEndpointforUpdateUserRoleId() {
		return updateUserRole_POJO.getEndpoint();
	}
	
	public String getEndpointforUpdateUserPgmBatch() {
		return user_UpdatePgmBatch_PUT_POJO.getEndpoint();
	}

	public void userPost(String sheetName, String testCaseID, RequestSpecification requestSpecification)
			throws IOException {
		userPostRequsetBody(sheetName, testCaseID);
		setEndpointPostUser(sheetName, testCaseID);
		requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
		if (requestSpecification == null) {
			throw new IllegalArgumentException(
					"RequestSpecification cannot be null. Ensure it is properly initialized.");
		}

		// Making the POST request
		response = given().spec(requestSpecification).body(getuserRequestBody()).when().post(getEndpoint());

		LoggerLoad.info("****** Request Body: " + user_POJO);
		LoggerLoad.info("****** Response: " + response.prettyPrint());
		LoggerLoad.info("****** Status Code: " + response.getStatusCode());

		if (response.getContentType() != null && response.getContentType().contains("application/json")) {
			try {
				System.out.println("------Fetching response------");

				String userId = response.jsonPath().getString("user.userId");
				String roleId = response.jsonPath().getString("roles[0].roleId");
				// List<String> roleIds = response.jsonPath().getList("roles.roleId");

				if (userId != null && !userId.isEmpty() && roleId != null && !roleId.isEmpty()) {

					Utils.set("userId", userId);
					Utils.set("roleId", roleId);

					Utils.addToList("userId_list", userId);
					Utils.addToList("roleId_list", roleId);

					LoggerLoad.info("userId stored successfully: " + userId);
					LoggerLoad.info("userId stored successfully: " + roleId);
				} else {
					LoggerLoad.warn("userId is missing in the response.");
					LoggerLoad.warn("roleId is missing in the response.");
				}
			} catch (JsonPathException e) {
				LoggerLoad.error("Failed to parse JSON response: " + e.getMessage());
			}
		} else {
			LoggerLoad.warn("Response is not in JSON format. Received: " + response.getBody().asString());
		}

	}

	public void getAllUsers(String sheetName, String testCaseID, RequestSpecification requestSpecification)
			throws IOException {
		setEndpointPostUser(sheetName, testCaseID); // You need to implement this to set your GET endpoint

		requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
		response = given().spec(requestSpecification).when().get(getEndpoint()); // getEndpoint() should return the full
																					// URL for the GET request

		LoggerLoad.info("****** GET Request Endpoint: " + getEndpoint());
		LoggerLoad.info("****** Response: " + response.prettyPrint());
		LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	}

	public void updateUserByUserId(String sheetName, String testCaseID, RequestSpecification requestSpecification)
			throws IOException {
		userPutRequestBody(sheetName, testCaseID);
		setEndpointPutUser(sheetName, testCaseID);
		requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
		if (requestSpecification == null) {
			throw new IllegalArgumentException(
					"RequestSpecification cannot be null. Ensure it is properly initialized.");
		}
		// Making the PUT request
	//	String storedUserId="";
		String storedUserId= Utils.get("userId", String.class);
		
		response = given().spec(requestSpecification).pathParam("uId", storedUserId).
				body(getuserbodyforUpdate()).when().put(getEndpointforUpdateUser() + "{uId}");
		
		
		LoggerLoad.info("****** Id used: " + storedUserId);
		LoggerLoad.info("****** Request Body: " + update_user_POJO);
		LoggerLoad.info("****** Response: " + response.prettyPrint());
		LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	}

	public void updateUserByInvalidUserId(String sheetName, String testCaseID, RequestSpecification requestSpecification)
			throws IOException {
		userPutRequestBody(sheetName, testCaseID);
		setEndpointPutUser(sheetName, testCaseID);
		requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
		if (requestSpecification == null) {
			throw new IllegalArgumentException(
					"RequestSpecification cannot be null. Ensure it is properly initialized.");
		}
		// Making the PUT request
	//	String storedUserId="";
		String storedUserId= Utils.get("userId", String.class);
		
		response = given().spec(requestSpecification).pathParam("uId", storedUserId).
				body(getuserbodyforUpdate()).when().put(getEndpointforUpdateUser() + "{uId}" + 00);
		
		
		LoggerLoad.info("****** Id used: " + storedUserId);
		LoggerLoad.info("****** Request Body: " + update_user_POJO);
		LoggerLoad.info("****** Response: " + response.prettyPrint());
		LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	}
	
	public void updateUserByUserRoleId(String sheetName, String testCaseID, RequestSpecification requestSpecification)
			throws IOException {
		userPutRoleIdBody(sheetName, testCaseID);
		setEndpointPutUserRoleId(sheetName, testCaseID);
		requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
		if (requestSpecification == null) {
			throw new IllegalArgumentException(
					"RequestSpecification cannot be null. Ensure it is properly initialized.");
		}
		// Making the PUT request
	//	String storedUserId="";
		String storedUserId = Utils.get("userId", String.class);
		String storedRoleId = Utils.get("roleId", String.class);

		response = given()
		                .spec(requestSpecification)
		                .pathParam("rId", storedRoleId)  // Role ID as path parameter
		                .pathParam("uId", storedUserId)  // User ID as path parameter
		                .body(getuserbodyforUpdateRoleId())  // Request body (ensure this method is returning the valid body)
		                .when()
		                .put(getEndpointforUpdateUserRoleId() + "{rId}/{uId}");  // Correct placeholders in the URL
		
		LoggerLoad.info("****** Id used: " + storedRoleId);
		LoggerLoad.info("****** Request Body: " + updateUserRole_POJO);
		LoggerLoad.info("****** Response: " + response.prettyPrint());
		LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	}

	public void updateUserByPgmBatch(String sheetName, String testCaseID, RequestSpecification requestSpecification)
			throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		userPutPgmBatchRequestBody(sheetName, testCaseID);
		setEndpointPutUserPgmBatch(sheetName, testCaseID);
		String storedUserId = Utils.get("userId", String.class);
		
		
		requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
		if (requestSpecification == null) {
			throw new IllegalArgumentException(
					"RequestSpecification cannot be null. Ensure it is properly initialized.");
		}
		// Making the PUT request
	//	String storedUserId="";
		//String storedPgmId= Utils.get("pgmId", String.class);
		//String storedBatchId = Utils.get("batchId", String.class);
		//byinvaliduserId
		
		if("byinvaliduserId".equalsIgnoreCase((testData.get("usecase")))){
			String invalidUserId = "11111";
			user_UpdatePgmBatch_PUT_POJO.setUserId(invalidUserId);
			response = given().spec(requestSpecification).pathParam("invaliduserId", invalidUserId).
					body(getuserbodyforUpdatePgmBatch()).when().put(getEndpointforUpdateUserPgmBatch() + "{invaliduserId}");
			
		}else if("validuserId".equalsIgnoreCase((testData.get("usecase")))) {
			user_UpdatePgmBatch_PUT_POJO.setUserId(storedUserId);
			response = given().spec(requestSpecification).pathParam("uId", storedUserId).
					body(getuserbodyforUpdatePgmBatch()).when().put(getEndpointforUpdateUserPgmBatch() + "{uId}");
			
		}else if("missingfield".equalsIgnoreCase((testData.get("usecase")))) {
			user_UpdatePgmBatch_PUT_POJO.setUserId(storedUserId);
			response = given().spec(requestSpecification).pathParam("uId", storedUserId).
					body(getuserbodyforUpdatePgmBatch()).when().put(getEndpointforUpdateUserPgmBatch() + "{uId}");
			
		}
		LoggerLoad.info("****** Id used: " + storedUserId);
		LoggerLoad.info("****** Request Body: " + user_UpdatePgmBatch_PUT_POJO);
		LoggerLoad.info("****** Response: " + response.prettyPrint());
		LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	}
	
	 public void deleteUser(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
		 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		    setEndpointPostUser(sheetName, testCaseID);  // You need to implement this to set your GET endpoint
			 
			  
			   String storedUserId = Utils.get("userId", String.class);
			   
			   if("deletebyinvaliduserId".equalsIgnoreCase((testData.get("usecase")))){
					String invalidUserId = "11111";
					
					requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
				     response = given()
				            .spec(requestSpecification)
				            .pathParam("id", invalidUserId)
				            .when()
				            .delete(getEndpoint() + "{id}"); 
				    	
			   }else if("deletebyvaliduserId".equalsIgnoreCase((testData.get("usecase")))) {
				   
				   requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
				     response = given()
				            .spec(requestSpecification)
				            .pathParam("id", storedUserId)
				            .when()
				            .delete(getEndpoint() + "{id}"); 
			   }
					
					
					
			   
		   
		    
		    
		     LoggerLoad.info("****** DELETE Request Endpoint: " + getEndpoint().replace("{id}", storedUserId));
		    LoggerLoad.info("****** Response: " + response.prettyPrint());
		    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		}
	 	 
	
	public Response getResponse() {
		return response;
	}

}

