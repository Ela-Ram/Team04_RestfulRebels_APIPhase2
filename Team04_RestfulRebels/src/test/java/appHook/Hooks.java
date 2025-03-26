package appHook;

import common.ConfigReader;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Hooks {
	
	 private RequestSpecification request;
	
	
	
	
	@Before("@NoAuth")
    public void removeAuthForNoAuthScenarios() {
        request = RestAssured.given()
                //.baseUri(ConfigReader.getProperty("Base_Url")) // Keep base URL
                .header("Accept", "application/json")
                .contentType("application/json"); // No Authorization header
    }
	
	
	
	
	
	
	
	
	

}
