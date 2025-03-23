package requestBuilder;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import common.ConfigReader;
import common.ExcelReader;
import common.LoggerLoad;
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
	
			 String batchIdUseCases = testData.get("batchIdUseCase");
			    // Set batchId based on its specific use case
			    if ("valid".equalsIgnoreCase(batchIdUseCases)) {
			        class_POJO.setBatchId(11881);
			        // String BatchId = Utils.get("ValidBatchId", String.class); 
			    } else {
			    	String batchIdStr = testData.get("batchId");

			    	if (batchIdStr != null && !batchIdStr.trim().isEmpty()) {
			    	    class_POJO.setBatchId((int)Double.parseDouble(batchIdStr));
			    	} else {
			    	    LoggerLoad.info(" BatchId is empty or null");
			    	}
			    }
			    
			    String classNostr = testData.get("classNo");

		    	if (classNostr != null && !classNostr.trim().isEmpty()) {
		    		class_POJO.setClassNo((int) Double.parseDouble(testData.get("classNo")));
		    	} else {
		    	    LoggerLoad.info(" classNo is empty or null");
		    	}

			    
			    
			    class_POJO.setClassDate(testData.get("classDate"));
			    class_POJO.setClassTopic(testData.get("classTopic"));
			    class_POJO.setClassStatus(testData.get("classStatus"));
			    
			    String classStaffIdUseCase = testData.get("classStaffIdUseCase");
			    if ("valid".equalsIgnoreCase(classStaffIdUseCase)) {
			        class_POJO.setClassStaffId("U108");
			     // String setClassStaffId = Utils.get("ValidsetClassStaffId", String.class);
			    } else {
			    	
			    	class_POJO.setClassStaffId(testData.get("classStaffId"));
			    	
			  			    }

			   
			    class_POJO.setClassDescription(testData.get("ClassDescription"));
			    class_POJO.setClassComments(testData.get("classComments"));
			    class_POJO.setClassNotes(testData.get("classNotes"));
			    class_POJO.setClassRecordingPath(testData.get("classRecordingPath"));

			    if ("empty".equalsIgnoreCase(testData.get("usecase"))) {
			    	class_POJO.setClassScheduledDates(new ArrayList<>()); // Set an empty list	

			    }else {
			    String classScheduledDatesStr = testData.get("classScheduledDates");
			        LoggerLoad.info("Debug: The key 'classScheduledDates' is missing. Available keys: " + testData.keySet());
			    String[] datesArray = classScheduledDatesStr.split(",");
			    List<String> classScheduledDates = Arrays.asList(datesArray);
			    class_POJO.setClassScheduledDates(classScheduledDates);		
			    }
			    
			    }		 
		 
	 public Class_POJO getclassRequestBody() {  
	        return class_POJO;
	    }
	 	 
	 
	 
	 
	 
//------------------------------------------------------------------------------------------------------------------------------------------------------------
	 
	
	
	 public void setEndpointPostClass(String sheetName, String testCaseID) throws IOException {
		 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
	        	class_POJO.setEndpoint(testData.get("Endpoint"));  // Set endpoint in user_POJO
	        } else {
	        	String method = testData.get("Method");

	        	switch (method.toLowerCase()) {
	        	    case "post":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_POST_CreateNew.getPath());
	        	        break;
	        	    case "class_get_allclasslist":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_GET_AllClassList.getPath());
	        	        break;
	        	    case "class_get_allclasses_forparticular_student":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_GET_allClasses_forParticular_Student.getPath());
	        	        break;
	        	    case "class_get_classrecordings_bybatchid":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_GET_ClassRecordings_byBatchId.getPath());
	        	        break;
	        	    case "class_get_classdetails_byclassid":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_GET_ClassDetails_byClassId.getPath());
	        	        break;
	        	    case "class_get_byclasstopic":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_GET_byClassTopic.getPath());
	        	        break;
	        	    case "class_get_allclasses_bybatchid":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_GET_allClasses_byBatchId.getPath());
	        	        break;
	        	    case "class_get_allclasses_bystaffid":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_GET_allClasses_byStaffId.getPath());
	        	        break;
	        	    case "class_get_allrecordings":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_GET_allrecordings.getPath());
	        	        break;
	        	    case "class_get_classrecordings_byclassid":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_GET_ClassRecordings_byClassId.getPath());
	        	        break;
	        	    case "class_put_newclass":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_PUT_NewClass.getPath());
	        	        break;
	        	    case "class_put_class_recording_path":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_PUT_Class_Recording_path.getPath());
	        	        break;
	        	    case "class_delete_byclassid":
	        	        class_POJO.setEndpoint(enumPackage.Endpoint.Class_Delete_byClassId.getPath());
	        	        break;
	        	    default:
	        	        LoggerLoad.info("Unknown method -> " + method);
	        	        throw new IllegalArgumentException("Invalid method: " + method);
	        	}
	        }

	        LoggerLoad.info(" Endpoint set to -> " + class_POJO.getEndpoint());
	    }


	    public String getEndpoint() {
	        return class_POJO.getEndpoint();
	    }
//Post request
		 public void classPost(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			 classPostRequestbody(sheetName, testCaseID);
		        setEndpointPostClass(sheetName, testCaseID);
			  requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			 if (requestSpecification == null) {
			        throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
			    }

		        // Making the POST request
		        response = given()
		            .spec(requestSpecification)
		            .body(getclassRequestBody())  
		            .when()
		            .post(getEndpoint());
		            
		        LoggerLoad.info("****** Request Body: " + class_POJO);
		        LoggerLoad.info("****** Response: " + response.prettyPrint());
		        LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		        
		        if (response.getContentType() != null && response.getContentType().contains("application/json")) {
		            String csId = response.jsonPath().getString("csId");  
		            if (csId != null && !csId.isEmpty()) {
		            	Utils.set("csId", csId);
		            	Utils.addToList("csId_list",csId);

		                LoggerLoad.info("Token stored successfully: " + csId);
		            } else {
		                LoggerLoad.warn("Token is missing in the response.");
		            }
		        } else {
		            LoggerLoad.warn("Response is not in JSON format. Received: " + response.getBody().asString());
		        }
		  
		        
		 }
		 
		 
		 public void classPostNoPayload(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			 
		        setEndpointPostClass(sheetName, testCaseID);
			  requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			 if (requestSpecification == null) {
			        throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
			    }

			 response = given()
				        .spec(requestSpecification)
				        .body("{}")
				        .when()
				        .post(getEndpoint());
		            
		        LoggerLoad.info("****** Request Body: " + class_POJO);
		        LoggerLoad.info("****** Response: " + response.prettyPrint());
		        LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		        
		 }
		 
		 
		 public void classPostInvalidUrl(String sheetName, String testCaseID,RequestSpecification requestSpecification) throws IOException {
			 requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
		        setEndpointPostClass(sheetName, testCaseID);

			 response = given()
				        .spec(requestspecification)
				        .when()
				        .body(getclassRequestBody())  
				        .post(getEndpoint());
		            
		        LoggerLoad.info("****** Request Body: " + class_POJO);
		        LoggerLoad.info("****** Response: " + response.prettyPrint());
		        LoggerLoad.info("****** Status Code: " + response.getStatusCode());     
		              
		 }
		//this is like just the endpoint without parameters
		 public void classGetwithoutPathParam(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			    setEndpointPostClass(sheetName, testCaseID);  // You need to implement this to set your GET endpoint
			    
			    requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			     response = given()
			            .spec(requestSpecification)
			            .when()
			            .get(getEndpoint()); // getEndpoint() should return the full URL for the GET request

			    LoggerLoad.info("****** GET Request Endpoint: " + getEndpoint());
			    LoggerLoad.info("****** Response: " + response.prettyPrint());
			    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
			}

		 public void classGetinvalidMethod(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			    setEndpointPostClass(sheetName, testCaseID);  // You need to implement this to set your GET endpoint
			    
			    requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			     response = given()
			            .spec(requestSpecification)
			            .when()
			            .post(getEndpoint()); // getEndpoint() should return the full URL for the GET request

			    LoggerLoad.info("****** GET Request Endpoint: " + getEndpoint());
			    LoggerLoad.info("****** Response: " + response.prettyPrint());
			    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
			}

		 public void classGetbyIdandTopic(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
			 setEndpointPostClass(sheetName, testCaseID); 
			 String IdValue = "";

			 if ("byBatchId".equalsIgnoreCase(testData.get("usecase"))) {
			   //  IdValue = String.valueOf((int) Double.parseDouble(Utils.get("BatchId", String.class)));
				   IdValue = "11881";
				   // String BatchId = Utils.get("ValidBatchId", String.class);
			 }else if ("byinvalidBatchId".equalsIgnoreCase(testData.get("usecase"))) {
				 IdValue = String.valueOf((int) Double.parseDouble(testData.get("batchId")));
			 }else if("byClassId".equalsIgnoreCase(testData.get("usecase"))) {
				  IdValue = Utils.get("csId", String.class);
			 }else if("byinvalidClassId".equalsIgnoreCase(testData.get("usecase"))) {
				  IdValue = testData.get("ClassId");
			 }else if("byTopic".equalsIgnoreCase(testData.get("usecase"))) {
				 IdValue = testData.get("Topic");	 
			 }else if("byinvalidTopic".equalsIgnoreCase(testData.get("usecase"))) {
				 IdValue = testData.get("Topic");
			 }
			    requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			     response = given()
			            .spec(requestSpecification)
			            .pathParam("id", IdValue)
			            .when()
			            .get("getEndpoint(){id}");
			     
			     LoggerLoad.info("****** Id used: " + IdValue);
			    LoggerLoad.info("****** GET Request Endpoint: " + getEndpoint());
			    LoggerLoad.info("****** Response: " + response.prettyPrint());
			    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
			
		 }
		 
}

		       
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 


