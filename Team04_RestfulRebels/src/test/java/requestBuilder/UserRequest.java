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

public class UserRequest {
    
    private User_POJO user_POJO;  
    private RequestSpecification requestspecification;
    private Response response;

    public UserRequest() {
        this.user_POJO = new User_POJO();

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

    public User_POJO getuserRequestBody() {
        return user_POJO;
    }
    
    
    public void setEndpointPostUser(String sheetName, String testCaseID) throws IOException {
		 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
	        	user_POJO.setEndpoint(testData.get("Endpoint"));  // Set endpoint in user_POJO
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
       	        
       	    case "get_emailsof_alluserswith_Activestatus":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_emailsofalluserswithActivestatus.getPath());
       	        break;
       	        
       	    case "get_allRoles":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_AllRoles.getPath());
       	        break;
       	        
       	    case "get_userinformation_byUserId":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_Userinformation_byUserId.getPath());
       	        break;
       	        
       	    case "get_all_usersWithRoles":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_all_UsersWithRoles.getPath());
       	        break;
       	    
       	    case "get_countof_active_and_inActiveUsers":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_CountOfActiveandInActiveUsers.getPath());
       	        break;
       	        
       	    case "get_userby_programBatches":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_Userby_ProgramBatches.getPath());
       	        break;
       	        
       	    case "get_usersfor_program":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_UsersforProgram.getPath());
       	        break;
       	        
       	    case "get_userBy_roleId":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_UserBy_RoleId.getPath());
       	        break;
       	        
       	    case "get_userByRoleId_V2":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_GET_UserByRoleId_V2.getPath());
       	        break;
       	        
       	    case "put_byUserId":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_PUT_byUserId.getPath());
       	        break;
       	        
       	    case "put_byRoleId":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_PUT_byRoleId.getPath());
       	        break;
       	        
       	    case "put_byUserRolePgmBatchStatus":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_PUT_byUserRolePgmBatchStatus.getPath());
       	        break;
       	        
       	    case "put_updateUserLoginStatus":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_PUT_UpdateUserLoginStatus.getPath());
       	        break;
       	        
       	    case "delete_byUserId":
       	        user_POJO.setEndpoint(enumPackage.Endpoint.User_DELETE_ByUserId.getPath());
       	        break;
       	       
       	    default:
       	        LoggerLoad.info("Unknown method -> " + method);
       	        throw new IllegalArgumentException("Invalid method: " + method);
       	     
	        	}
   }
		 
		 LoggerLoad.info(" Endpoint set to -> " + user_POJO.getEndpoint());
}
   public String getEndpoint() {
       return user_POJO.getEndpoint();
   }
   
    
    
   public void userPost(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
		 userPostRequsetBody(sheetName, testCaseID);
	        setEndpointPostUser(sheetName, testCaseID);
		  requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
		 if (requestSpecification == null) {
		        throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
		    }

	        // Making the POST request
	        response = given()
	            .spec(requestSpecification)
	            .body(getuserRequestBody())  
	            .when()
	            .post(getEndpoint());
	            
	        LoggerLoad.info("****** Request Body: " + user_POJO);
	        LoggerLoad.info("****** Response: " + response.prettyPrint());
	        LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	        
	     /*   if (response.getContentType() != null && response.getContentType().contains("application/json")) {
	            try {
	                String csId = response.jsonPath().getString("csId");
	                if (csId != null && !csId.isEmpty()) {
	                    Utils.set("csId", csId);
	                    Utils.addToList("csId_list", csId);
	                    LoggerLoad.info("csId stored successfully: " + csId);
	                } else {
	                    LoggerLoad.warn("csId is missing in the response.");
	                }
	            } catch (JsonPathException e) {
	                LoggerLoad.error("Failed to parse JSON response: " + e.getMessage());
	            }
	        } else {
	            LoggerLoad.warn("Response is not in JSON format. Received: " + response.getBody().asString());
	        }	*/	  
	        
	 }
	 
    
    
   public Response getResponse() {
       return response;
   }
    
    
    
    
    
    
}
