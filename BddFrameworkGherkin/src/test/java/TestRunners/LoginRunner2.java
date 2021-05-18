package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//Test runner runs through TestNG - all the commented lines are no longter needed by the Testng and new importes got imported

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
features="C:\\Users\\kgajdosz\\Documents\\bench learning\\BDD\\Gherkin-Cucumber\\BddFrameworkGherkin\\FeatureFiles", 
glue= {"stepDefininitions"},tags= "@ExTestWithTable"
,monochrome = true,
plugin = { "pretty", "html:target/HTMLReport/HTMLREPORT.html",
"junit:target/JunitReport/report.xml",
"json:target/JsonReport/report.json"}
 
)

public class LoginRunner2 extends AbstractTestNGCucumberTests{
}



//Login2.feature