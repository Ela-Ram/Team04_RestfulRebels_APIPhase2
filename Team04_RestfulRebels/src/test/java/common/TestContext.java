
package common;

import java.util.HashMap;
import java.util.Map;

import io.restassured.specification.RequestSpecification;

public class TestContext {
	
	
	
	  private static Map<String, RequestSpecification> requestSpecifications = new HashMap<>();
	
	    // Method to set a specific RequestSpecification
	    public static void setRequestSpecification(String key, RequestSpecification spec) {
	        requestSpecifications.put(key, spec);
	    }

	    // Method to get a specific RequestSpecification by key
	    public static RequestSpecification getRequestSpecification(String key) {
	        return requestSpecifications.get(key);
	    }
	  	    
	}

	

