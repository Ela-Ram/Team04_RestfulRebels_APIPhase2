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
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import payload.Batch_POJO;
import payload.Class_POJO;
import payload.Login_POJO;

@Getter
@Setter

public class BatchRequest {
	
	private Batch_POJO batch_POJO;  
    private RequestSpecification requestspecification;
    private Response response;

public BatchRequest() {
    this.batch_POJO = new Batch_POJO();
}


public void batchPostRequestbody(String sheetName, String testCaseID) throws IOException {
	 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
    
	    batch_POJO.setBatchDescription(testData.get("batchDescription"));
	    batch_POJO.setBatchName(testData.get("batchName")); 
	    String batchnoofclassesstr = testData.get("batchNoOfClasses");

    	if (batchnoofclassesstr != null && !batchnoofclassesstr.trim().isEmpty()) {
    		batch_POJO.setBatchNoOfClasses((int) Double.parseDouble(testData.get("batchNoOfClasses")));
    	} else {
    	    LoggerLoad.info(" batchNoOfClasses is empty or null");
    	}
	    
    	batch_POJO.setBatchStatus(testData.get("batchStatus"));
    	
    	 String programIdUseCases = testData.get("programIdUseCase");
		   
		    if ("valid".equalsIgnoreCase(programIdUseCases)) {
		     String programId = Utils.get("programId", String.class); 
		     batch_POJO.setProgramId(Integer.parseInt(programId));
		       
		    } else {
		    	String programIdStr = testData.get("programId");

		    	if (programIdStr != null && !programIdStr.trim().isEmpty()) {
		    	    batch_POJO.setProgramId((int)Double.parseDouble(programIdStr));
		    	} else {
		    	    LoggerLoad.info("ProgramId is empty or null");
		    	}
		    }
	  

	   
	    
	    }		 

public Batch_POJO getbatchRequestBody() {  
   return batch_POJO;
}



//------------------------------------------------------------------------------------------------------------------------------------------------------------



public void setEndpointPostBatch(String sheetName, String testCaseID) throws IOException {
	 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
	 if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
       	batch_POJO.setEndpoint(testData.get("Endpoint"));  // Set endpoint in user_POJO
       } else {
       	String method = testData.get("Method");

       	switch (method.toLowerCase()) {
       	    case "post":
       	        batch_POJO.setEndpoint(enumPackage.Endpoint.Batch_POST.getPath());
       	        break;
       	    case "batch_get_allbatches":
       	        batch_POJO.setEndpoint(enumPackage.Endpoint.Batch_GET_allBatches.getPath());
       	        break;
       	    case "batch_get_by_batchname":
       	        batch_POJO.setEndpoint(enumPackage.Endpoint.Batch_GET_BatchByBatchName.getPath());
       	        break;
       	    case "batch_get_bybatchid":
       	        batch_POJO.setEndpoint(enumPackage.Endpoint.Batch_GET_byBatchId.getPath());
       	        break;
       	    case "batch_get_programid":
       	        batch_POJO.setEndpoint(enumPackage.Endpoint.Batch_GET_byProgramId.getPath());
       	        break;
       	    case "batch_put_bybatchid":
       	        batch_POJO.setEndpoint(enumPackage.Endpoint.Batch_PUT_byBatchId.getPath());
       	        break;
       	    case "batch_delete_bybatchid":
       	        batch_POJO.setEndpoint(enumPackage.Endpoint.Batch_DELETE_byBatchId.getPath());
       	        break;
       	   
       	    default:
       	        LoggerLoad.info("Unknown method -> " + method);
       	        throw new IllegalArgumentException("Invalid method: " + method);
       	}
       }

       LoggerLoad.info(" Endpoint set to -> " + batch_POJO.getEndpoint());
   }


   public String getEndpoint() {
       return batch_POJO.getEndpoint();
   }
 

//_________________________________________________________________________
   
   public void batchPost(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
	   Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 batchPostRequestbody(sheetName, testCaseID);
	        setEndpointPostBatch(sheetName, testCaseID);
		 
		  if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
			    requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
			    }else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
			    	 requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			    }
		  
		 if (requestSpecification == null) {
		        throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
		    }

	        // Making the POST request
	        response = given()
	            .spec(requestSpecification)
	            .body(getbatchRequestBody())  
	            .when()
	            .post(getEndpoint());
	            
	        LoggerLoad.info("****** Request Body: " + batch_POJO);
	        LoggerLoad.info("****** Response: " + response.prettyPrint());
	        LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	        
	        if (response.getContentType() != null && response.getContentType().contains("application/json")) {
	        	try {
	            String batchId = response.jsonPath().getString("batchId");  
	            if (batchId != null && !batchId.isEmpty()) {
	            	Utils.set("batchId", batchId);
	            	Utils.addToList("batchId_list",batchId);

	                LoggerLoad.info("batchId stored successfully: " + batchId);
	            } else {
	                LoggerLoad.warn("batchId is missing in the response.");
	            }
	        	}catch (JsonPathException e) {
	              LoggerLoad.error("Failed to parse JSON response: " + e.getMessage());
	        	}
	        } else {
	            LoggerLoad.warn("Response is not in JSON format. Received: " + response.getBody().asString());
	        }
	  
	        
	 }
   
   

   
   
//   get all batches
   

	 public void getllbatcheswithoutPathParam(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
		    setEndpointPostBatch(sheetName, testCaseID);  // You need to implement this to set your GET endpoint
		    Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		    if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
			    requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
			    }else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
			    	 requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			    }
		  
		     response = given()
		            .spec(requestSpecification)
		            .when()
		            .get(getEndpoint()); // getEndpoint() should return the full URL for the GET request

		    LoggerLoad.info("****** GET Request Endpoint: " + getEndpoint());
		    LoggerLoad.info("****** Response: " + response.prettyPrint());
		    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		}

	 
	//Get by Batch id, batchname, Programid

	 public void batchGetbybatchidbatchnameprogramid(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
		 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
		 setEndpointPostBatch(sheetName, testCaseID); 
		 String IdValue = "";

		 if ("byBatchId".equalsIgnoreCase(testData.get("usecase"))) {
		    IdValue = Utils.get("batchId", String.class);

		 }else if ("byinvalidBatchId".equalsIgnoreCase(testData.get("usecase"))) {
			 IdValue = String.valueOf((int) Double.parseDouble(testData.get("batchId")));
		 } else if ("bydeletedBatchId".equalsIgnoreCase(testData.get("usecase"))) {
				 IdValue = String.valueOf((int) Double.parseDouble(testData.get("batchId")));
		 }else if("byBatchName".equalsIgnoreCase(testData.get("usecase"))) {	
			  IdValue = "team10apidriventwentyseven";
		 }else if ("byinvalidBatchName".equalsIgnoreCase(testData.get("usecase"))) {
			 IdValue = testData.get("batchName");
		 } else if ("bydeletedBatchName".equalsIgnoreCase(testData.get("usecase"))) {
				 IdValue = testData.get("batchName");
		 }else if ("byProgramId".equalsIgnoreCase(testData.get("usecase"))) {
			   IdValue = Utils.get("programId", String.class);
			  
		 }else if ("byinvalidProgramId".equalsIgnoreCase(testData.get("usecase"))) {
			 IdValue = String.valueOf((int) Double.parseDouble(testData.get("programId")));
		 } else if ("bydeletedProgramId".equalsIgnoreCase(testData.get("usecase"))) {
				 IdValue = String.valueOf((int) Double.parseDouble(testData.get("programId")));
		 }
		 
		 if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
			    requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
			    }else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
			    	 requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			    }
		 
		    
		     response = given()
		            .spec(requestSpecification)
		            .pathParam("id", IdValue)
		            .when()
		            .get(getEndpoint() + "{id}");
		         
		     
		     LoggerLoad.info("****** Id used: " + IdValue);
		    LoggerLoad.info("****** GET Request Endpoint: " + getEndpoint());
		    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		
	 } 
	
	 
	 //Delete batch by batchid
	 
	 public void deleteBatch(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
		 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);  
		 setEndpointPostBatch(sheetName, testCaseID);  // You need to implement this to set your GET endpoint

		    String Batchid = "";
		    if ("succesfulbatchdeletebybatchid".equalsIgnoreCase(testData.get("usecase"))) {
		    	Batchid = Utils.get("batchId", String.class);
//		    	Batchid = "10926";
					   
				 }else if ("retrievethebatchbyinvalidbatchid".equalsIgnoreCase(testData.get("usecase"))) {
					 Batchid = String.valueOf((int) Double.parseDouble(testData.get("batchId")));
				 }
		    
		    if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
			    requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
			    }else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
			    	 requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			    }

		     response = given()
		            .spec(requestSpecification)
		            .pathParam("id", Batchid)
		            .when()
		            .delete(getEndpoint() + "{id}"); 
		    
		    
		     LoggerLoad.info("****** DELETE Request Endpoint: " + getEndpoint().replace("{id}", Batchid));
		    LoggerLoad.info("****** Response: " + response.prettyPrint());
		    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		}
	 
	//update 
	 public void batchPut(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
		 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);  
		 batchPostRequestbody(sheetName, testCaseID);
	        setEndpointPostBatch(sheetName, testCaseID);
	        
	        String Batchid = "";
		    if ("succesfulupdatebybatchid".equalsIgnoreCase(testData.get("usecase"))) {
				    Batchid = Utils.get("batchId", String.class);
				 }else if ("updatebybatchbyinvalidbatchid".equalsIgnoreCase(testData.get("usecase"))) {
					 Batchid = String.valueOf((int) Double.parseDouble(testData.get("batchId")));
		
				 
				 }
		    
		    
		    if ("invalid".equalsIgnoreCase(testData.get("authType"))) {
			    requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
			    }else if ("valid".equalsIgnoreCase(testData.get("authType"))) {
			    	 requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
			    }
		
		 if (requestSpecification == null) {
		        throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
		    }

	        // Making the POST request
	        response = given()
	            .spec(requestSpecification)
	            .body(getbatchRequestBody()) 
	            .pathParam("id", Batchid)
	            .when()
	            .put(getEndpoint()+"{id}");
	            
	        LoggerLoad.info("****** Request Body: " + batch_POJO);
	        LoggerLoad.info("****** Response: " + response.prettyPrint());
	        LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	        
	        if (response.getContentType() != null && response.getContentType().contains("application/json")) {
	        	try {
	            String batchId = response.jsonPath().getString("batchId");  
	            if (batchId != null && !batchId.isEmpty()) {
	            	Utils.set("batchId", batchId);
	            	Utils.addToList("batchId_list",batchId);

	                LoggerLoad.info("batchId stored successfully: " + batchId);
	            } else {
	                LoggerLoad.warn("batchId is missing in the response.");
	            }
	        }catch (JsonPathException e) {
	           LoggerLoad.error("Failed to parse JSON response: " + e.getMessage()); 
	        
	        }
	        }else {
	            LoggerLoad.warn("Response is not in JSON format. Received: " + response.getBody().asString());
	        }
	  
	        
	 }
       
	 
	 
	        

	 public void getllbatcheswithsearchString(String sheetName, String testCaseID, RequestSpecification requestSpecification,String searchValue) throws IOException {
		    setEndpointPostBatch(sheetName, testCaseID);  // You need to implement this to set your GET endpoint
		    
		    requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
		     response = given()
		            .spec(requestSpecification)
		            .when()
		            .queryParam("searchString", searchValue)
		            .get(getEndpoint()); 

		    LoggerLoad.info("****** GET Request Endpoint: " + getEndpoint());
		    LoggerLoad.info("****** Response: " + response.prettyPrint());
		    LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		}

	 
	 
	 
	 public void cleanupBatch(String key, String pathVariableName, String endpointTemplate) {
	  	    List<Object> batchId_list = Utils.get(key, List.class);

	  	    if (batchId_list != null && !batchId_list.isEmpty()) {
	  	        for (Object item : batchId_list) {
	  	            String identifier = String.valueOf(item);
	  	            deleteProgramForCleanup(identifier, pathVariableName, endpointTemplate);
	  	            LoggerLoad.info("Deleted " + pathVariableName + ": " + identifier);
	  	        }

	  	        Utils.remove(key);
	  	        Utils.remove(pathVariableName);
	  	        LoggerLoad.info("All " + pathVariableName + "s from the list have been deleted and cleaned up from the Utils.");
	  	    } else {
	  	        LoggerLoad.info("No " + pathVariableName + "s found in the list to delete.");
	  	    }
	  	}

	  	public void deleteProgramForCleanup(String identifier, String pathVariableName, String endpoint) {
	  	    requestspecification = TestContext.getRequestSpecification("validRequestSpecification");

	  	    response = given()
	  	            .spec(requestspecification)
	  	            .pathParam(pathVariableName, identifier)
	  	            .when()
	  	            .delete(endpoint);

	  	    LoggerLoad.info("****** DELETE Request Endpoint: " + endpoint.replace("{" + pathVariableName + "}", identifier));
	  	    LoggerLoad.info("****** Response: " + response.prettyPrint());
	  	    LoggerLoad.info("****** Status Code: " + response.getStatusCode());

	  	    if (response.getStatusCode() != 200) {
	  	        LoggerLoad.error("Failed to delete " + pathVariableName + ": " + identifier + ". Status Code: " + response.getStatusCode());
	  	    } else {
	  	        LoggerLoad.info("Successfully deleted " + pathVariableName + ": " + identifier);
	  	    }
	  	}
	 
	 
	 
}





