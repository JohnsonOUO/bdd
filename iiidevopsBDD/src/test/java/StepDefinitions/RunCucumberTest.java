package StepDefinitions;

import org.junit.runner.RunWith;   
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;  

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/Features",
				glue={"StepDefinitions"},
				monochrome = true,
				plugin = { "pretty", "html:target/HtmlReports.html",
							"json:target/JSONReports/report.json",
				 			"junit:target/JUniteports/report.xml"})
public class RunCucumberTest {
}
