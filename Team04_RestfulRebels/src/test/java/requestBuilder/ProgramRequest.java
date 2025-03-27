package requestBuilder;


	

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ExcelReader;
import common.LoggerLoad;
import common.TestContext;
import common.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import payload.Class_POJO;
import payload.Program_POJO;


import static io.restassured.RestAssured.given;

@Getter
@Setter
public class ProgramRequest {
	
	private Program_POJO program_POJO;  
    RequestSpecification requestspecification;
    Response response;
    
    
    public ProgramRequest() {
        this.program_POJO = new Program_POJO();
    }

    public void setuserRequestbody(String sheetName, String testCaseID) throws IOException {
        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID);
       
        	program_POJO.setProgramDescription(testData.get("ProgramDesc"));
        	program_POJO.setProgramName(testData.get("ProgramName"));
            program_POJO.setProgramStatus(testData.get("ProgramStatus"));
    
    }

    public Program_POJO getProgramRequestBody() {  
        return program_POJO;
    }

    // Set endpoint
    public void setEndpointProgram(String sheetName, String testCaseID) throws IOException {
        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID.trim());
     

        if ("invalidEndpoint".equalsIgnoreCase(testData.get("usecase"))) {
        	program_POJO.setEndpoint(testData.get("Endpoint"));  // Set endpoint in user_POJO
        } else {
        	String method = testData.get("Method").trim().toLowerCase();
        	LoggerLoad.info("Extracted Method from Excel: '" + method + "'");
        	switch (method) {
			case "post":
				program_POJO.setEndpoint(enumPackage.Endpoint.Program_POST.getPath());
				break;
			case "get_allprograms":
				program_POJO.setEndpoint(enumPackage.Endpoint.Program_GET_allPrograms.getPath());
				LoggerLoad.info("Endpoint Path: " + enumPackage.Endpoint.Program_GET_allPrograms.getPath());
				break;
			case "get_allprograms_withusers":
				program_POJO.setEndpoint(enumPackage.Endpoint.Program_GET_allProgram_withUsers.getPath());
				break;
			case "get_program_byprogramid":
				program_POJO.setEndpoint(enumPackage.Endpoint.Program_GET_ProgramId.getPath());
				break;
				
			case "updateprogram_byprogramname":
				program_POJO.setEndpoint(enumPackage.Endpoint.Program_PUT_byProgramName.getPath());
				break;
			case "updateprogram_byprogramid":
				program_POJO.setEndpoint(enumPackage.Endpoint.Program_PUT_byProgramId.getPath());
				break;
				
			case "deleteprogram_byprogramid":
				program_POJO.setEndpoint(enumPackage.Endpoint.Program_DELETE_byProgramId.getPath());
				break;
			case "deleteprogram_byprogramname":
				program_POJO.setEndpoint(enumPackage.Endpoint.Program_DELETE_byProgramName.getPath());
				break;

			default:

				LoggerLoad.info("Unknown method -> " + method);
    	        throw new IllegalArgumentException("Invalid method: " + method);
			}
        	
        	LoggerLoad.info(" Endpoint set to -> " + program_POJO.getEndpoint());
        	 
        }
    }

   
    public String getEndpoint() {
        return program_POJO.getEndpoint();  // Return endpoint from login_POJO
    }
    
    
//-----------------------------------------------------------------------------------------------------------------------------------------------------------    
  //Create User with all fields  
        
 public void programPost(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
	 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID.trim());   
	 setuserRequestbody(sheetName, testCaseID);
        setEndpointProgram(sheetName, testCaseID);
        
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
		 
	 if("invalid".equalsIgnoreCase(testData.get("HTTP"))) {
	        response = given()
	        		 .spec(requestSpecification)
	    			 .body(getProgramRequestBody())
	    			 .when()
	    			 .get(getEndpoint());
	    } else {
	        response = given()
	        		.spec(requestSpecification)
	                .body(getProgramRequestBody())  
	                .when()
	                .post(getEndpoint());
	         
	    } 
    
    
        LoggerLoad.info("****** Request Body: " + program_POJO);
        LoggerLoad.info("****** Response: " + response.prettyPrint());
        LoggerLoad.info("****** Status Code: " + response.getStatusCode());
        
        if (response.getContentType() != null && response.getContentType().contains("application/json")) {
            try {
                String programId = response.jsonPath().getString("programId");
                if (programId != null && !programId.isEmpty()) {
                    Utils.set("programId", programId);
                    Utils.addToList("programId_list", programId);
                    LoggerLoad.info("programId stored successfully: " + programId);
                } else {
                    LoggerLoad.warn("programId is missing in the response.");
                }

                String programName = response.jsonPath().getString("programName");
                if (programName != null && !programName.isEmpty()) {
                    Utils.set("programName", programName);
                    Utils.addToList("ProgramName_list", programName);
                    LoggerLoad.info("ProgramName stored successfully: " + programName);
                } else {
                    LoggerLoad.warn("ProgramName is missing in the response.");
                }
            } catch (JsonPathException e) {
                LoggerLoad.error("Failed to parse JSON response: " + e.getMessage());
            }
        } else {
            LoggerLoad.warn("Response is not in JSON format. Received: " + response.getBody().asString());
        }

        
 }
        
//--------------------------------------------------------------------------------------------------------------------------------------------------------------  
  //Post without Payload	 
	 
	 public void programPostNoPayload(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
		 
		 Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID.trim()); 
	        setEndpointProgram(sheetName, testCaseID);
	        
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
	            
	        LoggerLoad.info("****** Request Body: " + program_POJO);
	        LoggerLoad.info("****** Response: " + response.prettyPrint());
	        LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	        
	 }
    
    
  //****************************************Get Program******************************************************************************************
    
    //Get program
    public void GetallProgramandGetallprogramswithUsers(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID.trim());
    	setEndpointProgram(sheetName, testCaseID);
    	
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
		 if("invalid".equalsIgnoreCase(testData.get("HTTP"))) {
			 	response= given().spec(requestSpecification).when().post(getEndpoint());;
		    } else {
		    	 response= given().spec(requestSpecification).when().get(getEndpoint());
		         
		    }
	    LoggerLoad.info("****** Response: " + response.prettyPrint());
		LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		 
		 
    }
       
    // get program by programId 
    public void GetProgramByProgramId(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID.trim());
    	setEndpointProgram(sheetName, testCaseID);
    	
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
		 
		 String Idvalue ;
		 if ("invalid ProgramId".equalsIgnoreCase(testData.get("usecase"))) {
			 Idvalue =testData.get("ProgramIdinPath".trim());
			 LoggerLoad.info(Idvalue);
		 }
		   else {
			   Idvalue =Utils.get("programId", String.class);   
		}
		 if("invalid".equalsIgnoreCase(testData.get("HTTP"))) {
			 response= given()
					 .spec(requestSpecification)
					 .pathParam("Id", Idvalue)
					 .when()
					 .post(getEndpoint()+"{Id}");
			 
		    } else {
		    	response= given()
						 .spec(requestSpecification)
						 .pathParam("Id", Idvalue)
						 .when()
						 .get(getEndpoint()+"{Id}");
				
		    } 
	  		 	 
		 LoggerLoad.info("****** Response: " + response.prettyPrint());
		 LoggerLoad.info("****** Status Code: " + response.getStatusCode());
		 		    	
    }   
    //********************************************Put Program************************************************************************************
    //Request body for put
    public void setuserRequestbodyforUpdate(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException  {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID.trim());
    	
       	program_POJO.setProgramDescription(testData.get("ProgramDesc"));
        String usecase = testData.get("usecase");
        if ("missed programName".equalsIgnoreCase(usecase)) {
        	String programNameStored = testData.get("ProgramNameinPath");
        	 program_POJO.setProgramName(programNameStored);
        }else {
        String programNameStored = Utils.get("programName", String.class) ;
        program_POJO.setProgramName(programNameStored);
        }
        program_POJO.setProgramStatus(testData.get("ProgramStatus"));
    	
    }
    
    	
    public void updateByProgramIdandProgramName(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
        Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID.trim());
        setuserRequestbody(sheetName, testCaseID);	
        setEndpointProgram(sheetName, testCaseID);

        // Set request specification
       
        // Get ID value based on use case
        String bytype = testData.get("bytype");
        String IdValue = "";

        if ("byProgramId".equalsIgnoreCase(bytype)) {
            IdValue = Utils.get("programId", String.class);
        } else if ("byinvalidProgramId".equalsIgnoreCase(bytype)) {
            IdValue = testData.get("ProgramIdinPath");
        } else if ("byProgramName".equalsIgnoreCase(bytype)) {
            IdValue = Utils.get("programName", String.class);
        } else if ("invalidProgramName".equalsIgnoreCase(bytype)) {
            IdValue = testData.get("ProgramNameinPath");
        }

       
        String authType = testData.get("authType");
        if ("invalid".equalsIgnoreCase(authType)) {
            requestSpecification = TestContext.getRequestSpecification("invalidRequestSpecification");
        } else if ("valid".equalsIgnoreCase(authType)) {
            requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
        } else if ("invalidurl".equalsIgnoreCase(authType)) {
            requestSpecification = TestContext.getRequestSpecification("invalidURLRequestSpecification");
        }

        if (requestSpecification == null) {
            throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
        }

        
        if("invalid".equalsIgnoreCase(testData.get("HTTP"))) {
        	response = given()
	                .spec(requestSpecification)
	                .pathParam("pathParam", IdValue)
	                .body(getProgramRequestBody())
	                .when()
	                .get(getEndpoint() + "{pathParam}");	         
	    } else {
	    	response = given()
	                .spec(requestSpecification)
	                .pathParam("pathParam", IdValue)
	                .body(getProgramRequestBody())
	                .when()
	                .put(getEndpoint() +"{pathParam}");	         
	    } 

        
        

        // Logging
        LoggerLoad.info("****** Request Body: " + program_POJO);
        LoggerLoad.info("****** Response: " + response.prettyPrint());
        LoggerLoad.info("****** Status Code: " + response.getStatusCode());
    }

		

    
    
  //-----------update without Payload-----------------------------------------------------------------------------------------------	 
	 
  	 public void programUpdateNoPayload(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
  		
  		Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID.trim());   
  		setEndpointProgram(sheetName, testCaseID);
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
  		String programId =Utils.get("programId", String.class);
  		 response = given()
  			        .spec(requestSpecification)
  			        .pathParam("Id", programId)
  			        .body("{}")
  			        .when()
  			        .put(getEndpoint()+"{Id}");
  	            
  	        LoggerLoad.info("****** Request Body: " + program_POJO);
  	        LoggerLoad.info("****** Response: " + response.prettyPrint());
  	        LoggerLoad.info("****** Status Code: " + response.getStatusCode());
  	        
  	 }
    
  		
  	//**************************************   Delete Program   *******************************************************	
  	 
	public void DeleteByProgrameNameandId(String sheetName, String testCaseID, RequestSpecification requestSpecification) throws IOException {
    	Map<String, String> testData = ExcelReader.getTestData(sheetName, testCaseID.trim());
    	String Idvalue ="";
    	setEndpointProgram(sheetName, testCaseID);
    	requestSpecification = TestContext.getRequestSpecification("validRequestSpecification");
    	if (requestSpecification == null) {
	        throw new IllegalArgumentException("RequestSpecification cannot be null. Ensure it is properly initialized.");
	
	 		 }
    	
		  if("deletebyProgramId_invalid".equalsIgnoreCase(testData.get("bytype"))){
			   Idvalue =testData.get("ProgramIdinPath".trim()); 
		  }else if("deletebyProgramId_valid".equalsIgnoreCase(testData.get("bytype"))) {
			  Idvalue =  Utils.get("programId", String.class);
		   }else if("deletebyProgramName_invalid".equalsIgnoreCase(testData.get("bytype"))) {
			   Idvalue =testData.get("ProgramNameinPath".trim());
		   }else if("deletebyProgramName_valid".equalsIgnoreCase(testData.get("usecase"))){
			   Idvalue =  Utils.get("programName", String.class);
		   }
		 response = given()
					.spec(requestSpecification)
					.pathParam("pathParam", Idvalue)
					.when()
					.delete(getEndpoint()+"{pathParam}");
	
	LoggerLoad.info("****** Request Body: " + program_POJO);
    LoggerLoad.info("****** Response: " + response.prettyPrint());
	LoggerLoad.info("****** Status Code: " + response.getStatusCode());
	LoggerLoad.info("Idvalue: " + Idvalue);

  	}
  	
  	
  	
  
  	
  	//--------------------------------------------------------------------------------------------------------------------------
    
//data validation for program
  	 public static void validateDataForProgram(Program_POJO expectedPOJO, Response response) {
	        // Parse the response body to extract actual values
	        JsonPath jsonPath = response.jsonPath();

	        // Validate ProgramDescription
	        Assert.assertEquals(expectedPOJO.getProgramDescription(), jsonPath.getString("programDescription"), "Mismatch in programDescription");	        // Validate classDate

	        // Validate ProgramName
	        Assert.assertEquals(expectedPOJO.getProgramName(), jsonPath.getString("programName"), "Mismatch in ProgramName");

	        // Validate classStatus
	        Assert.assertEquals(expectedPOJO.getProgramStatus(), jsonPath.getString("programStatus"), "Mismatch in ProgramStatus");

	      
  	 }
  	 
  	 
  	public void cleanupPrograms(String key, String pathVariableName, String endpointTemplate) {
  	    List<Object> programList = Utils.get(key, List.class);

  	    if (programList != null && !programList.isEmpty()) {
  	        for (Object item : programList) {
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

  	public void deleteProgramForCleanup(String identifier, String pathVariableName, String endpointTemplate) {
  	    requestspecification = TestContext.getRequestSpecification("validRequestSpecification");

  	    response = given()
  	            .spec(requestspecification)
  	            .pathParam(pathVariableName, identifier)
  	            .when()
  	            .delete(endpointTemplate);

  	    LoggerLoad.info("****** DELETE Request Endpoint: " + endpointTemplate.replace("{" + pathVariableName + "}", identifier));
  	    LoggerLoad.info("****** Response: " + response.prettyPrint());
  	    LoggerLoad.info("****** Status Code: " + response.getStatusCode());

  	    if (response.getStatusCode() != 200) {
  	        LoggerLoad.error("Failed to delete " + pathVariableName + ": " + identifier + ". Status Code: " + response.getStatusCode());
  	    } else {
  	        LoggerLoad.info("Successfully deleted " + pathVariableName + ": " + identifier);
  	    }
  	}

  	 public Response getResponse() {
         return response;
     }

}