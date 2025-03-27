package requestBuilder;
	
import common.ConfigReader;
import common.ExcelReader;
import common.LoggerLoad;
import common.TestContext;
import common.Utils;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import payload.Login_POJO;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.Map;

	@Getter
	@Setter
	public class LoginandLogoutRequest {
	

	    private Login_POJO login_POJO;  
	    private RequestSpecification requestspecification;
	    private Response response;
	
	    
	    public LoginandLogoutRequest() {
	        this.login_POJO = new Login_POJO();
	    }

	    public void setCredentials(String sheetName, String testCaseID) throws IOException {
	        // Read authType from Excel (valid/invalid)
	        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	        String authType = testData.get("authType");

	        if ("valid".equalsIgnoreCase(authType)) {
	            login_POJO.setUserLoginEmailId(ConfigReader.getProperty("email"));
	            login_POJO.setPassword(ConfigReader.getProperty("password"));
	        } else {
	            login_POJO.setUserLoginEmailId(testData.get("username"));
	            login_POJO.setPassword(testData.get("password"));
	        }
	    }

	    public Login_POJO getLoginRequestBody() {  
	        return login_POJO;
	    }
	    public void setEndpoint(String sheetName, String testCaseID) throws IOException {
	        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);

	        if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
	            login_POJO.setEndpoint(testData.get("Endpoint"));  
	        } else {
	        	String method = testData.get("Method");
	         	switch (method.toLowerCase()) {
	         	    case "login":
	         	        login_POJO.setEndpoint(enumPackage.Endpoint.Login_POST.getPath());
	         	        break;
	         	    case "logout":
	         	    	login_POJO.setEndpoint(enumPackage.Endpoint.Logout_Get.getPath());
	                break;
	        }
	        }
	    }
     	
	    public String getEndpoint() {
	        return login_POJO.getEndpoint();  
	    }

	    
	    public void loginPost(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
	        setCredentials(sheetName, testCaseID);
	        setEndpoint(sheetName, testCaseID);

	        // Making the POST request
	        response = given()
	            .spec(requestSpecification)
	            .body(getLoginRequestBody())  
	            .when()
	            .post(getEndpoint())
	            .then()
	            .extract()
	            .response();

	        LoggerLoad.info("****** Request Body: " + login_POJO);
	        LoggerLoad.info("****** Response: " + response.prettyPrint());
	        LoggerLoad.info("****** Status Code: " + response.getStatusCode());

	       
	        if (response.getContentType() != null && response.getContentType().contains("application/json")) {
	            String token = response.jsonPath().getString("token");  
	            if (token != null && !token.isEmpty()) {
	              //	ConfigReader.setProperty("auth_token", token);
	            	Utils.set("authToken", token);
	            	

	                LoggerLoad.info("Token stored successfully: " + token);
	            } else {
	                LoggerLoad.warn("Token is missing in the response.");
	            }
	        } else {
	        	LoggerLoad.warn("Response is not in JSON format. Received: " + response.getBody().asString());
	        }
	    }
	    
	    
	    public RequestSpecification setRequestSpecification() {
	        return given()
	                .baseUri(ConfigReader.getProperty("Base_Url"))
	                .header("Accept", "application/json")
	                .contentType("application/json");
	    }   
	    
	    public void logoutGet(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
		    Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		    setEndpoint(sheetName, testCaseID);  // You need to implement this to set your GET/POST endpoint

		    if ("no".equalsIgnoreCase(testData.get("authType"))) {
		        requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
		    } else if ("yes".equalsIgnoreCase(testData.get("authType"))) {
		        requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
		    } else if ("invalidurl".equalsIgnoreCase(testData.get("authType"))) {
		        requestSpecification = TestContext.getRequestSpecification("invalidURLRequestSpecification");
		    }

		    if (requestSpecification == null) {
		        throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
		    }

		    if("invalid".equalsIgnoreCase(testData.get("Http"))) {
		        response = given()
		            .spec(requestSpecification)
		            .when()
		            .post(getEndpoint());  
		    } else  {
		        response = given()
		            .spec(requestSpecification)
		            .when()
		            .get(getEndpoint());
		      
		    } 

		   
		    LoggerLoad.info("****** Request Endpoint: " + getEndpoint());
		    LoggerLoad.info("****** Response: " + response.prettyPrint());
		    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		}
	    public  void validateSchemaLoginPost(Response response, String schemaPath) {
	        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
	    }
	   
}
