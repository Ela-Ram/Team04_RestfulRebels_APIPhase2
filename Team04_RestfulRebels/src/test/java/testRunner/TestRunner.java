package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


/*@CucumberOptions(
	    features = "src/test/resources/features", // Path to your feature files
	    glue = "stepDefinitions", // Package where your step definitions are located
	    tags ="@login or @createuser or @getuser",
	    plugin = {
	        "pretty", // Pretty formatting for console output
	        "html:target/cucumber-reports.html", // Generate HTML report
	        "json:target/cucumber-reports.json" // Generate JSON report
	    },
	    monochrome = true // Clean console output
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	    // This class doesn't need any code; it's just a configuration class.
	}*/


@CucumberOptions(
	    features = "src/test/resources/features", // Path to your feature files
	    tags = "@login or @createuser or @getuser",
	    glue = "stepDefinitions", // Package where your step definitions are located
	    plugin = {
	        "pretty", // Pretty formatting for console output
	        "html:target/cucumber-reports.html", // Generate HTML report
	        "json:target/cucumber-reports.json" // Generate JSON report
	    },
	    monochrome = true // Clean console output
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	    // This class doesn't need any code; it's just a configuration class.
	}
