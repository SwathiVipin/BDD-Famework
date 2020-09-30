package wiproassignment.gillette_testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//D://Project/JavaSelenium/gillette/src/test/java/wiproassignment/gillette/features
		//D://Project/JavaSelenium/gillette/src/test/java/wiproassignment/gillette/stepDefenitions
		features="features",
		glue = {"D://Project/JavaSelenium/gillette/src/main/java/wiproassignment/gillette/stepDefenitions"},
		monochrome =true,
		strict = false,
		dryRun= true,
		format = {"pretty","html:target/test-output","json:target/cucumber.json"}
		
				
		)

public class TestRunner {

}
