package requestBuilder;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ConfigReader;
import common.ExcelReader;
import common.LoggerLoad;
import common.TestContext;
import common.Utils;
import enumPackage.Endpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import payload.Class_POJO;
import payload.Class_Put_POJO;


@Getter
@Setter
public class ClassRequest {
	 private Class_POJO class_POJO;  
	 private Class_Put_POJO class_Put_POJO;
	    private RequestSpecification requestspecification;
	    private Response response;
	
	public ClassRequest() {
        this.class_POJO = new Class_POJO();
        this.class_Put_POJO = new Class_Put_POJO();
    }
	

	//Constructing Request Body		 
	public void classPostRequestbody(String sheetName, String testCaseID) throws IOException {
	    Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);

	    // BatchId handling
	    String batchIdUseCases = testData.get("batchIdUseCase");
	    if ("valid".equalsIgnoreCase(batchIdUseCases)) {
	    	String BatchId = Utils.get("batchId", String.class);
	    	class_POJO.setBatchId((int) Double.parseDouble(BatchId));
	       
	    } else {
	        String batchIdStr = testData.get("batchId");
	        if (batchIdStr != null && !batchIdStr.trim().isEmpty()) {
	            class_POJO.setBatchId((int) Double.parseDouble(batchIdStr));
	        } else {
	            LoggerLoad.info("BatchId is empty or null");
	        }
	    }

	    
	    String classNostr = testData.get("classNo");
	    if (classNostr != null && !classNostr.trim().isEmpty()) {
	        class_POJO.setClassNo((int) Double.parseDouble(classNostr));
	    } else {
	        LoggerLoad.info("classNo is empty or null");
	    }

	    class_POJO.setClassDate(testData.get("classDate"));
	    class_POJO.setClassTopic(testData.get("classTopic"));
	    class_POJO.setClassStatus(testData.get("classStatus"));

	    
	    String classStaffIdUseCase = testData.get("classStaffIdUseCase");
	    if ("valid".equalsIgnoreCase(classStaffIdUseCase)) {
	    	String StaffId = Utils.get("userId", String.class);
	    	class_POJO.setClassStaffId(StaffId);
	       // class_POJO.setClassStaffId("U108");// remove this after chaining is implemebted
	    } else {
	        class_POJO.setClassStaffId(testData.get("classStaffId"));
	    }

	   
	    class_POJO.setClassDescription(testData.get("ClassDescription"));
	    class_POJO.setClassComments(testData.get("classComments"));
	    class_POJO.setClassNotes(testData.get("classNotes"));
	    class_POJO.setClassRecordingPath(testData.get("classRecordingPath"));

	   
	    String classScheduledDatesStr = testData.get("classScheduledDates");
	    if (classScheduledDatesStr == null || classScheduledDatesStr.trim().isEmpty()) {
	        LoggerLoad.info("classScheduledDates is empty or null, setting default empty list");
	        class_POJO.setClassScheduledDates(new ArrayList<>());
	    } else {
	        String[] datesArray = classScheduledDatesStr.split(",");
	        List<String> classScheduledDates = Arrays.asList(datesArray);
	        class_POJO.setClassScheduledDates(classScheduledDates);
	    }
	}

	public Class_POJO getclassRequestBody() {
	    return class_POJO;
	}
//------------------------------------------------------------------------------------------------------------------------------------------------
	//Requestbody for put
	
	public void classPutRequestbody(String sheetName, String testCaseID) throws IOException {
	    Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	    class_Put_POJO.setClassRecordingPath(testData.get("classRecordingPath"));
	    
	
	    if ("invalidCsId".equalsIgnoreCase(testData.get("usecase"))) {
	        class_Put_POJO.setCsId((int)Double.parseDouble(testData.get("csId")));  // Corrected
	    } else {
	        
	    	class_Put_POJO.setCsId(Integer.parseInt(Utils.get("csId", String.class)));
	    }
	}

	public Class_Put_POJO getClassPutRequestbody() {
	    return class_Put_POJO;
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------
	 
	
	
	 public void setEndpointPostClass(String sheetName, String testCaseID) throws IOException {
		 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
	        	class_POJO.setEndpoint(testData.get("Endpoint"));  // Set endpoint in user_POJO
	        } else {
	        	String method = testData.get("method");

	        	if (method == null || method.trim().isEmpty()) {
	        	    LoggerLoad.error("Method is missing or empty in test data.");
	        	    throw new IllegalArgumentException("Missing method value.");
	        	}

	        	switch (method.trim().toLowerCase()) {

	      
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
	    
//----------------------------------------------------------------------------------------------------------------------------------------------------	    
//Post request
		 public void classPost(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
			 classPostRequestbody(sheetName, testCaseID);
		        setEndpointPostClass(sheetName, testCaseID);
		        
		       
		       
		        if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
				    requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
				    }else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
				    	 requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
				    }else if ("invalidurl".equalsIgnoreCase(testData.get("authType"))) {
				    	requestSpecification = TestContext.getRequestSpecification("invalidURLRequestSpecification");
				    }
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
		        }		  
		        
		 }
		 
//----------------------------------------------------------------------------------------------------------------------------------------------------
	//Post without Payload	 
		 
		 public void classPostNoPayload(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		        setEndpointPostClass(sheetName, testCaseID);
		        if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
				    requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
				    }else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
				    	 requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
				    }else if ("invalidurl".equalsIgnoreCase(testData.get("authType"))) {
				    	requestSpecification = TestContext.getRequestSpecification("invalidURLRequestSpecification");
				    }
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

//------------------------------------------------------------------------------------------------------------------------------------------------
		 public void classGetAll(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			    Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
			    setEndpointPostClass(sheetName, testCaseID);  // You need to implement this to set your GET/POST endpoint

			    
			    if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
			        requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
			    } else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
			        requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			    } else if ("invalidurl".equalsIgnoreCase(testData.get("authType"))) {
			        requestSpecification = TestContext.getRequestSpecification("invalidURLRequestSpecification");
			    }

			    // Ensure the requestSpecification is not null
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
//-------------------------------------------------------------------------//----------------------------------------------------------------------		 
		 public void classGetByIdAndTopic(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			    Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
			    setEndpointPostClass(sheetName, testCaseID);  

			    String IdValue = "";
			    String usecase = testData.get("usecase");
			   
			    if ("byBatchId".equalsIgnoreCase(usecase)) {
			    	IdValue = Utils.get("batchId", String.class);
			      // IdValue = "11546";  //Remove this after chaining is implemented
			    } else if ("byinvalidBatchId".equalsIgnoreCase(usecase)) {
			        IdValue = String.valueOf((int) Double.parseDouble(testData.get("batchId")));
			    } else if ("byClassId".equalsIgnoreCase(usecase)) {
			        IdValue = Utils.get("csId", String.class);  
			    } else if ("byinvalidClassId".equalsIgnoreCase(usecase)) {
			        IdValue = testData.get("ClassId");
			    } else if ("byTopic".equalsIgnoreCase(usecase) || "byinvalidTopic".equalsIgnoreCase(usecase)) {
			        IdValue = testData.get("classTopic");
			    } else if ("byStaffId".equalsIgnoreCase(usecase)){
			    	IdValue = Utils.get("UserId", String.class);
			      //  IdValue = "U108";  //Remove this after chaining is implemented
			    }else if("	".equalsIgnoreCase(usecase)) {
			    	IdValue = testData.get("classStaffId");
			    }


			    if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
			        requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
			    } else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
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
			            .pathParam("id", IdValue)
			            .when()
			            .delete(getEndpoint() + "{id}"); 
			    } else {
			        response = given()
			            .spec(requestSpecification)
			            .pathParam("id", IdValue)
			            .when()
			            .get(getEndpoint() + "{id}"); 
			         
			    } 

			   
			    LoggerLoad.info("****** Id used: " + IdValue);
			    LoggerLoad.info("****** Request Endpoint: " + getEndpoint());
			    LoggerLoad.info("****** Response: " + response.prettyPrint());
			    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
			}


		 
		//------------------------------------------------------------------------------------------------------------------------------------------------------
		 //Delete Class 
		 
		 public void deleteClass(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			 String csId;
			    setEndpointPostClass(sheetName, testCaseID);  // You need to implement this to set your GET endpoint
			    Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
			    if ("invalidClassId".equalsIgnoreCase(testData.get("usecase"))) {
			    	
			    	 csId = testData.get("ClassId");
			    }else {
			    
				    csId = Utils.get("csId", String.class);
			    }
			    

			    if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
				    requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
				    }else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
				    	 requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
				    }else if ("invalidurl".equalsIgnoreCase(testData.get("authType"))) {
				    	requestSpecification = TestContext.getRequestSpecification("invalidURLRequestSpecification");
				    }
			     response = given()
			            .spec(requestSpecification)
			            .pathParam("id", csId)
			            .when()
			            .delete(getEndpoint() + "{id}"); 
			    
			    
			     LoggerLoad.info("****** DELETE Request Endpoint: " + getEndpoint() + csId);
			    LoggerLoad.info("****** Response: " + response.prettyPrint());
			    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
			}

//------------------------------------------------------------------------------------------------------------------------------------------------------		 
		// Put class
		 public void classPut(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			 String csId;
			 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
			 classPostRequestbody(sheetName, testCaseID);
		        setEndpointPostClass(sheetName, testCaseID);
		       
		        if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
				    requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
				    }else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
				    	 requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
				    }else if ("invalidurl".equalsIgnoreCase(testData.get("authType"))) {
				    	requestSpecification = TestContext.getRequestSpecification("invalidURLRequestSpecification");
				    }
			 if (requestSpecification == null) {
			        throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
			    }
			 
		 if ("byinvalidClassId".equalsIgnoreCase(testData.get("usecase"))) {
		    	 csId = testData.get("ClassId");
		    }else {
			    csId = Utils.get("csId", String.class);
		    }

		       
		        response = given()
		            .spec(requestSpecification)
		            .pathParam("id", csId)
		            .body(getclassRequestBody())  	
		            .when()
		            .put(getEndpoint() + "{id}");
		            									
		        LoggerLoad.info("****** Request Body: " + class_POJO);
		        LoggerLoad.info("****** Response: " + response.prettyPrint());
		        LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		        		        
		 } 


		
//--------------------------------------------------------------------------------------------------------------------------------------------------
		 public void classPutRecordingpath(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
			    String csId;
			    Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
			    
			    // Set the request body for class update
			    classPutRequestbody(sheetName, testCaseID);
			    setEndpointPostClass(sheetName, testCaseID);

			   
			    if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
			        requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
			    } else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
			        requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			    } else if ("invalidurl".equalsIgnoreCase(testData.get("authType"))) {
			        requestSpecification = TestContext.getRequestSpecification("invalidURLRequestSpecification");
			    }

			    // Ensure requestSpecification is valid
			    if (requestSpecification == null) {
			        throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
			    }

			    
			    if ("byinvalidClassId".equalsIgnoreCase(testData.get("usecase"))) {
			        csId = testData.get("ClassId");
			    } else {
			        csId = Utils.get("csId", String.class);
			    }
			    

			    if("invalid".equalsIgnoreCase(testData.get("Http"))) {
			        response = given()
			            .spec(requestSpecification)
			            .pathParam("id", csId)
			            .body(getClassPutRequestbody())  
			            .when()
			            .delete(getEndpoint() + "{id}");
			    } else {
			        response = given()
			            .spec(requestSpecification)
			            .pathParam("id", csId)
			            .body(getClassPutRequestbody())  
			            .when()
			            .put(getEndpoint() + "{id}");
			    }
			    // Log the request body, response, and status code
			    LoggerLoad.info("****** Request Body: " + class_POJO);
			    LoggerLoad.info("****** Response: " + response.prettyPrint());
			    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
			}

		 
		 
		 
//------------------------------------------------------------------------------------------------------------------------------------------------------
		 public static void validateDataClassPost(Class_POJO expectedPOJO, Response response) {
		        // Parse the response body to extract actual values
		        JsonPath jsonPath = response.jsonPath();

		        // Validate batchId
		        Assert.assertEquals(expectedPOJO.getBatchId(), jsonPath.getInt("batchId"), "Mismatch in batchId");

		        // Validate classNo
		        Assert.assertEquals(expectedPOJO.getClassNo(), jsonPath.getInt("classNo"), "Mismatch in classNo");

		        // Validate classDate
		        Assert.assertEquals(expectedPOJO.getClassDate(), jsonPath.getString("classDate"), "Mismatch in classDate");

		        // Validate classTopic
		        Assert.assertEquals(expectedPOJO.getClassTopic(), jsonPath.getString("classTopic"), "Mismatch in classTopic");

		        // Validate classStatus
		        Assert.assertEquals(expectedPOJO.getClassStatus(), jsonPath.getString("classStatus"), "Mismatch in classStatus");

		        // Validate classStaffId
		        Assert.assertEquals(expectedPOJO.getClassStaffId(), jsonPath.getString("classStaffId"), "Mismatch in classStaffId");

		        // Validate classScheduledDates as lists (order matters)
		        List<String> expectedScheduledDates = expectedPOJO.getClassScheduledDates();
		        List<String> actualScheduledDates = jsonPath.getList("classScheduledDates");

		        Assert.assertEquals(expectedScheduledDates.size(), actualScheduledDates.size(), "Mismatch in classScheduledDates size");

		        // Loop through and compare each scheduled date
		        for (int i = 0; i < expectedScheduledDates.size(); i++) {
		            Assert.assertEquals(expectedScheduledDates.get(i), actualScheduledDates.get(i), "Mismatch in classScheduledDates at index " + i);
		        }
		    }
		 
//-------------------------------------------------------------------------------------------------------------------------------------------------------
		 public void cleanupClass(String key) {
			    // Retrieve the csId_list from the Utils (which stores a list of csIds)
			    List<Object> csId_list = Utils.get(key, List.class);

			    if (csId_list != null && !csId_list.isEmpty()) {
			        for (Object csId1 : csId_list) {
			            String csId = String.valueOf(csId1);  // Convert the Object to String

			            deleteClassforcleanup(csId);  // Pass only one csId at a time to delete it
			            System.out.println("Deleted csId: " + csId);
			        }
			        Utils.remove(key);
			        Utils.remove("csId");
			        System.out.println("All csIds from the list have been deleted and cleaned up from the Utils.");
			    } else {
			        System.out.println("No csIds found in the list to delete.");
			    }
			}


		 public void deleteClassforcleanup(String csId) {
			 String endpoint = "/deleteByClass/{id}";
			    requestspecification = TestContext.getRequestSpecification("validRequestSpecification");
			    response = given()
			            .spec(requestspecification)
			            .pathParam("id", csId)  // Correctly pass one csId at a time in the path
			            .when()
			            .delete(endpoint);

			    LoggerLoad.info("****** DELETE Request Endpoint: " + endpoint.replace("{id}", csId));
			    LoggerLoad.info("****** Response: " + response.prettyPrint());
			    LoggerLoad.info("****** Status Code: " + response.getStatusCode());

			    if (response.getStatusCode() != 200) {
			        LoggerLoad.error("Failed to delete csId: " + csId + ". Status Code: " + response.getStatusCode());
			    } else {
			        LoggerLoad.info("Successfully deleted csId: " + csId);
			    }
			}

		    
		    public Response getResponse() {
		        return response;
		    }

		
			
			}

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 


		       
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 


