package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
    	"src/test/resources/features/01Login.feature",
        "src/test/resources/features/02Program.feature",
    	"src/test/resources/features/03Batch.feature",
    	"src/test/resources/features/04User.feature",
    	"src/test/resources/features/05Class.feature",
    	"src/test/resources/features/06NoauthandInvalidURL.feature",
    	"src/test/resources/features/07Cleanup.feature",
    	"src/test/resources/features/08Logout.feature"
        
    },
    glue = "stepDefinitions",
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", // Allure Report
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Extent Report
        "json:target/CucumberReports/LMS_API.json",
        "html:target/CucumberReports/LMS.html",
        "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // Just configuration - no code needed here
}
