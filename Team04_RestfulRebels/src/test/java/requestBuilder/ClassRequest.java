package requestBuilder;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import common.ConfigReader;
import common.ExcelReader;
import common.TestContext;
import common.Utils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import payload.Class_POJO;
import payload.Login_POJO;

@Getter
@Setter
public class ClassRequest {
	 private Class_POJO class_POJO;  
	    private RequestSpecification requestspecification;
	    private Response response;
	
	public ClassRequest() {
        this.class_POJO = new Class_POJO();
    }
	
	
	public void classPostRequestbody(String sheetName, String testCaseID) throws IOException {
		 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		// Separate use cases for batchId and classStaffId
		    
		
		// Separate use cases for batchId and classStaffId
		    String batchIdUseCases = testData.get("batchIdUseCase");
		   

		    // Set batchId based on its specific use case
		    if ("valid".equalsIgnoreCase(batchIdUseCases)) {
		        class_POJO.setBatchId(123);
		    } else if("notvalid".equalsIgnoreCase(batchIdUseCases)) {
		        class_POJO.setBatchId(Integer.parseInt(testData.get("batchId")));
		    }
		  //  class_POJO.setClassNo((int) Double.parseDouble(testData.get("classNo")));
		  //  class_POJO.setClassNo(testData.get("classNo"));
		    class_POJO.setClassDate(testData.get("classDate"));
		    class_POJO.setClassTopic(testData.get("classTopic"));
		    class_POJO.setClassStatus(testData.get("classStatus"));
		    
		    String classStaffIdUseCases = testData.get("classStaffIdUseCase");
		    // Set classStaffId based on its specific use case
		    if ("valid".equalsIgnoreCase(classStaffIdUseCases)) {
		        class_POJO.setClassStaffId("U123");
		    } else {
		        class_POJO.setClassStaffId(testData.get("classStaffId"));
		    }

		   
		    class_POJO.setClassDescription(testData.get("ClassDescription"));
		    class_POJO.setClassComments(testData.get("classComments"));
		    class_POJO.setClassNotes(testData.get("classNotes"));
		    class_POJO.setClassRecordingPath(testData.get("classRecordingPath"));

		    // Handle classScheduledDates
		    String date1 = testData.getOrDefault("classScheduledDates_1", "").trim();
		    String date2 = testData.getOrDefault("classScheduledDates_2", "").trim();

		    List<String> classScheduledDates = new ArrayList<>();

		    if (!date1.isEmpty()) classScheduledDates.add(date1);
		    if (!date2.isEmpty()) classScheduledDates.add(date2);

		    // Store in POJO
		    class_POJO.setClassScheduledDates(classScheduledDates);

	}

	 public Class_POJO getclassRequestBody() {  
	        return class_POJO;
	    }
	
	
	 public void setEndpointClass(String sheetName, String testCaseID) throws IOException {
	        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	     
	        	if ("valid".equalsIgnoreCase(testData.get("Endpointusecase"))) {
		        String method = testData.get("Method");
		        
		            
		        switch (method.toLowerCase()) {
		            case "post":
		                String Class_POST_CreateNew = enumPackage.Endpoint.Class_POST_CreateNew.getPath(); 
		                class_POJO.setEndpoint(Class_POST_CreateNew); 
		                break;

		           
		           
		            default:
		                // Handle the case when the method doesn't match any predefined ones
		                System.out.println("Unknown method: " + method);
		                break;
		        }
	        	}
		        else if("invalid Endpoint".equalsIgnoreCase(testData.get("Endpointusecase"))) { 
		        class_POJO.setEndpoint(testData.get("Endpoint"));
		        
		    }
		
	 }
		public String getEndpointclass() {
		    return class_POJO.getEndpoint();  
		}

		 public void classPost(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			 classPostRequestbody(sheetName, testCaseID);
		        setEndpointClass(sheetName, testCaseID);
			  requestSpecification = TestContext.getRequestSpecification();
			 if (requestSpecification == null) {
			        throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
			    }

			  

		        // Making the POST request
		        response = given()
		            .spec(requestSpecification)
		            .body(getclassRequestBody())  
		            .when()
		            .post("/end");
		            
		        
		      
		        System.out.println("****** Request Body: " + class_POJO);
		        System.out.println("****** Response: " + response.prettyPrint());
		        System.out.println("****** Status Code: " + response.getStatusCode());

		       
	/*	        if (response.getContentType() != null && response.getContentType().contains("application/json")) {
		            String token = response.jsonPath().getString("token");  
		            if (token != null && !token.isEmpty()) {
		              //	ConfigReader.setProperty("auth_token", token);
		            	Utils.set("authToken", token);
		                System.out.println("Token stored successfully: " + token);
		            } else {
		                System.out.println("Token is missing in the response.");
		            }
		        } else {
		            System.out.println("Response is not in JSON format. Received: " + response.getBody().asString());
		        }*/
		    }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
