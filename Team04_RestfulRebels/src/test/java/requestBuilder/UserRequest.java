package requestBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.groovy.transform.sc.ListOfExpressionsExpression;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import common.ExcelReader;
import common.LoggerLoad;
import common.TestContext;
import common.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Class_POJO;
import payload.Program_POJO;
import payload.User_POJO;
import payload.User_PUT_POJO;
import payload.User_UpdatePgmBatch_PUT_POJO;
import payload.User_UpdateRole_PUT_POJO;
import payload.User_UpdateUserLoginStatus_PUT_POJO;

public class UserRequest {
    
	private User_POJO user_POJO;
	private User_PUT_POJO update_user_POJO;
	private User_UpdateRole_PUT_POJO updateUserRole_POJO;
	private User_UpdatePgmBatch_PUT_POJO user_UpdatePgmBatch_PUT_POJO;
	private User_UpdateUserLoginStatus_PUT_POJO user_UpdateUserLoginStatus_PUT_POJO;
	private RequestSpecification requestspecification;
	private Response response;

	public UserRequest() {
		this.user_POJO = new User_POJO();
		this.update_user_POJO = new User_PUT_POJO();
		this.updateUserRole_POJO = new User_UpdateRole_PUT_POJO();
		this.user_UpdatePgmBatch_PUT_POJO = new User_UpdatePgmBatch_PUT_POJO();
		this.user_UpdateUserLoginStatus_PUT_POJO = new User_UpdateUserLoginStatus_PUT_POJO();

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
		
		LoggerLoad.info("---Entering getting userId from dataStore-----");
		update_user_POJO.setUserId(Utils.get("userId", String.class));
		LoggerLoad.info("---getting userId from dataStore-----");

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
					updateUserRole_POJO.setUserRoleList(List.of(new User_UpdateRole_PUT_POJO.UserRole(roleIdStr, roleStatusStr)));
				} else {
					LoggerLoad.info("RoleId or UserRoleStatus is empty or null");
				}
		
	}
	
	public void userPutPgmBatchRequestBody(String sheetName, String testCaseID) throws IOException {
		// Fetch test data from Excel
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		
	//----------uncomment this for chaining to work-----------------	
		int storedPgmId= Utils.get("programId", Integer.class);
		//int storedPgmId = 18971;
		//int storedBatchId = 11632;
		int storedBatchId = Utils.get("batchId", Integer.class);
		String storedUserId = Utils.get("userId", String.class);
		
		if("byinvaliduserId".equalsIgnoreCase((testData.get("usecase")))){
		//	String invalidUserId = "11111";
			String invalidUserId = testData.get("invalidUserId");
			user_UpdatePgmBatch_PUT_POJO.setUserId(invalidUserId);
			
		}else if("validuserId".equalsIgnoreCase((testData.get("usecase")))) {
			user_UpdatePgmBatch_PUT_POJO.setUserId(storedUserId);
		}
		
		 user_UpdatePgmBatch_PUT_POJO.setProgramId(storedPgmId);
		
		user_UpdatePgmBatch_PUT_POJO.setRoleId(testData.get("roleId"));
		
		
		String batchStatus = testData.get("userRoleProgramBatchStatus");
		
		if (storedBatchId != 0 && batchStatus != null) {
		user_UpdatePgmBatch_PUT_POJO.setUserRoleProgramBatches(List.of(new User_UpdatePgmBatch_PUT_POJO.UserRoleProgramBatches(storedBatchId, batchStatus)));
		}else {
			LoggerLoad.info("BatchId or BatchStatus is empty or null");
		}
	}

	
	public void userPutLoginStatusRequsetBody(String sheetName, String testCaseID) throws IOException {
		// Fetch test data from Excel
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);

		
		user_UpdateUserLoginStatus_PUT_POJO.setLoginStatus(testData.get("loginStatus"));
		
		//user_UpdateUserLoginStatus_PUT_POJO.setPassword(testData.get("password"));
		
		//user_UpdateUserLoginStatus_PUT_POJO.setRoleIds(testData.get("roleId"));
		
		user_UpdateUserLoginStatus_PUT_POJO.setStatus(testData.get("status"));
		
		user_UpdateUserLoginStatus_PUT_POJO.setUserLoginEmail(testData.get("userLoginEmail"));
		
		
		
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
	
	public User_UpdateUserLoginStatus_PUT_POJO getuserbodyforUpdateLoginStatus() {
		return user_UpdateUserLoginStatus_PUT_POJO;
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
	
	public void setEndpointPutLoginStatus(String sheetName, String testCaseID) throws IOException {
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
			user_UpdateUserLoginStatus_PUT_POJO.setEndpoint(testData.get("Endpoint")); // Set endpoint in user_POJO
		} else {
			String method = testData.get("Method");
			switch (method.toLowerCase()) {
			
			case "put_byupdateuserlogin":
				user_UpdateUserLoginStatus_PUT_POJO.setEndpoint(enumPackage.Endpoint.User_PUT_UpdateUserLoginStatus.getPath());
				break;
				
			default:
				LoggerLoad.info("Unknown method -> " + method);
				throw new IllegalArgumentException("Invalid method: " + method);
			}
			}
		LoggerLoad.info(" Endpoint set to -> " + user_UpdateUserLoginStatus_PUT_POJO.getEndpoint());
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
	
	public String getEndpointforUpdateLoginStatus() {
		return user_UpdateUserLoginStatus_PUT_POJO.getEndpoint();
	}
//---------------------------------User Module POST Request------------------------------------------------
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
				LoggerLoad.info("------Fetching response------");

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
	
//-------------------------------User Module All PUT Requests------------------------------------------------------
	
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
		//String id = "U2984";
		String storedUserId = Utils.get("userId", String.class);
		//String storedRoleId = Utils.get("roleId", String.class);

		response = given()
		                .spec(requestSpecification)
		                .pathParam("uId", storedUserId)  // User ID as path parameter
		                .body(getuserbodyforUpdateRoleId())  // Request body (ensure this method is returning the valid body)
		                .when()
		                .put(getEndpointforUpdateUserRoleId() + "{uId}");  // Correct placeholders in the URL
		
		LoggerLoad.info("****** Id used: " + storedUserId);
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
			//String invalidUserId = "11111";
			String invalidUserId = testData.get("invalidUserId");
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
	
	public void updateUserLoginStatus(String sheetName, String testCaseID, RequestSpecification requestSpecification)
			throws IOException {
		userPutLoginStatusRequsetBody(sheetName, testCaseID);
		setEndpointPutLoginStatus(sheetName, testCaseID);
		requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
		if (requestSpecification == null) {
			throw new IllegalArgumentException(
					"RequestSpecification cannot be null. Ensure it is properly initialized.");
		}
		// Making the PUT request
	//	String storedUserId="";
		//String uid1 = "U2984";
		String storedUserId= Utils.get("userId", String.class);
		
		response = given().spec(requestSpecification).pathParam("uId", storedUserId).
				body(getuserbodyforUpdateLoginStatus()).when().put(getEndpointforUpdateLoginStatus() + "{uId}");
		
		
		LoggerLoad.info("****** Id used: " + storedUserId);
		LoggerLoad.info("****** Request Body: " + user_UpdateUserLoginStatus_PUT_POJO);
		LoggerLoad.info("****** Response: " + response.prettyPrint());
		LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	}

//-----------------------------------------------User Module Delete Request----------------------------------------------
	
	 public void deleteUser(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
		 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		    setEndpointPostUser(sheetName, testCaseID);  // You need to implement this to set your GET endpoint
			 
			  
			   String storedUserId = Utils.get("userId", String.class);
			   
			   if("deletebyinvaliduserId".equalsIgnoreCase((testData.get("usecase")))){
					//String invalidUserId = "11111";
					String invalidUserId = testData.get("invalidUserId");
					
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

//--------------------------------------Data Validation----------------------------------
	 
	 public static void validateDataUserPost(User_POJO expectedPOJO, Response response) {
	        // Parse the response body to extract actual values
	        JsonPath jsonPath = response.jsonPath();

	       
	        Assert.assertEquals(expectedPOJO.getUserComments(), jsonPath.getString("userComments"), "Mismatch in userComments");

	        
	        Assert.assertEquals(expectedPOJO.getUserEduPg(), jsonPath.getInt("userEduPg"), "Mismatch in userEduPg");

	       
	        Assert.assertEquals(expectedPOJO.getUserEduUg(), jsonPath.getString("userEduUg"), "Mismatch in userEduUg");

	        
	        Assert.assertEquals(expectedPOJO.getUserFirstName(), jsonPath.getString("userFirstName"), "Mismatch in userFirstName");

	       
	        Assert.assertEquals(expectedPOJO.getUserLastName(), jsonPath.getString("userLastName"), "Mismatch in userLastName");

	        
	        Assert.assertEquals(expectedPOJO.getUserLinkedinUrl(), jsonPath.getString("userLinkedinUrl"), "Mismatch in userLinkedinUrl");
	        
	        Assert.assertEquals(expectedPOJO.getUserLocation(), jsonPath.getString("userLocation"), "Mismatch in userLocation");
	        
	        Assert.assertEquals(expectedPOJO.getUserMiddleName(), jsonPath.getString("userMiddleName"), "Mismatch in userMiddleName");
	        
	        Assert.assertEquals(expectedPOJO.getUserPhoneNumber(), jsonPath.getString("userPhoneNumber"), "Mismatch in userPhoneNumber");
	        
	        Assert.assertEquals(expectedPOJO.getUserTimeZone(), jsonPath.getString("userTimeZone"), "Mismatch in userTimeZone");
	        
	        Assert.assertEquals(expectedPOJO.getUserVisaStatus(), jsonPath.getString("userVisaStatus"), "Mismatch in userVisaStatus");
	        
	        Assert.assertEquals(expectedPOJO.getUserLogin(), jsonPath.getString("userLogin"), "Mismatch in userLogin");
	        
	        
	    }
	 
//-------------------------------------------cleanUp-------------------------------------------------------	 
	 
	 public void cleanupUser(String key) {
		    // Retrieve the csId_list from the Utils (which stores a list of csIds)
		    List<Object> userId_list = Utils.get(key, List.class);

		    if (userId_list != null && !userId_list.isEmpty()) {
		       
		        for (Object userId1 : userId_list) {
		            String userId = String.valueOf(userId1);  // Convert the Object to String

		          
		            deleteUserforcleanup(userId);  // Pass only one csId at a time to delete it
		            LoggerLoad.info("Deleted csId: " + userId);
		        }

		       
		        Utils.remove(key);
		        Utils.remove("userId");
		        LoggerLoad.info("All userIds from the list have been deleted and cleaned up from the Utils.");
		    } else {
		        LoggerLoad.info("No userIds found in the list to delete.");
		    }
		}
	 public void deleteUserforcleanup(String userId) {
		 String endpoint = "/deleteByUser/{id}";
		    requestspecification = TestContext.getRequestSpecification("validRequestSpecification");

		    // Send DELETE request for the given csId. Ensure you're sending only one csId at a time.
		    response = given()
		            .spec(requestspecification)
		            .pathParam("id", userId)  // Correctly pass one csId at a time in the path
		            .when()
		            .delete(endpoint);

		    // Logging for debugging
		    LoggerLoad.info("****** DELETE Request Endpoint: " + endpoint.replace("{id}", userId));
		    LoggerLoad.info("****** Response: " + response.prettyPrint());
		    LoggerLoad.info("****** Status Code: " + response.getStatusCode());

		    if (response.getStatusCode() != 200) {
		        LoggerLoad.error("Failed to delete csId: " + userId + ". Status Code: " + response.getStatusCode());
		    } else {
		        LoggerLoad.info("Successfully deleted csId: " + userId);
		    }
		}
	 
	public Response getResponse() {
		return response;
	}

}
