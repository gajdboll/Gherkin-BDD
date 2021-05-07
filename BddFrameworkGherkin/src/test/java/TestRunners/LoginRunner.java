package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// That test is run through JUnit

@RunWith(Cucumber.class)
@CucumberOptions(
		
features="C:\\Users\\kgajdosz\\Documents\\bench learning\\BDD\\Gherkin-Cucumber\\BddFrameworkGherkin\\FeatureFiles", 
glue= {"stepDefininitions"},tags= "@One"
,monochrome = true,
plugin = { "pretty", 
"html:target/HTMLReport-NEW/HTMLREPORT.html",
"junit:target/JunitReport/report.xml",
"json:target/cucumber.json"}
 
)

public class LoginRunner {

}
