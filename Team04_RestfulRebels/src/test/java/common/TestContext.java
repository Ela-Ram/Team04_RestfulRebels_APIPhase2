package common;

import java.util.HashMap;
import java.util.Map;

import io.restassured.specification.RequestSpecification;

public class TestContext {
	
	private static Map<String, String> environmentData = new HashMap<>();
    private static RequestSpecification requestSpecification;
	
    
	
	public static void setRequestSpecification(RequestSpecification spec) {
        requestSpecification = spec;
    }

    public static RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

}
