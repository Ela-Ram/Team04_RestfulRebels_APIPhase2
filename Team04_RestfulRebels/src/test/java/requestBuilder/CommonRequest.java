package requestBuilder;

	

import common.ConfigReader;
import common.TestContext;
import common.Utils;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Login_POJO;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;

public class CommonRequest {
    private RequestSpecification requestspecification;
    private Response response;
    

    
    public RequestSpecification basewithValidauth() {
       String token = Utils.get("authToken", String.class); // Retrieve token
        if (token == null || token.isEmpty()) {
            throw new IllegalStateException("Token is null or empty");
        }
        return given()
                .baseUri(ConfigReader.getProperty("Base_Url"))
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .contentType("application/json");
        	
    }

    // Call this function for requests without authentication
    public RequestSpecification basewithNoauth() {
    return given()
    		.baseUri(ConfigReader.getProperty("Base_Url"))
    		.header("Accept", "application/json")
    		.contentType("application/json");
}
 
    

		
	    public  void validateStatusCode(Response response, Map<String, String> testData) {
	        int expectedStatusCode = (int) Double.parseDouble(testData.get("expectedStatuscode"));
	        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code mismatch!");
	    }
	
	    public  void validateStatusLine(Response response, Map<String, String> testData) {
	        String expectedStatusLine = testData.get("expectedStatusLine");
	        Assert.assertEquals(response.getStatusLine(), expectedStatusLine, "Status line mismatch!");
	    }
	
	    public  void validateContentType(Response response, Map<String, String> testData) {
	        String expectedContentType = testData.get("expectedContentType");
	        Assert.assertEquals(response.getContentType(), expectedContentType, "Content-Type mismatch!");
	    }
	    	//should be in particular request builder
	    public  void validateSchema(Response response, String schemaPath) {
	        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
	    }
	
	    public  void validateErrorMessage(Response response, Map<String, String> testData) {
	        String expectedMessage = testData.get("expectedErrorMessage");
	        String actualMessage = response.jsonPath().getString("message");
	        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch!");
	    }
	

}
