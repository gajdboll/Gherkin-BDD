package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features= {"FeatureFiles/Login2.feature"}, monochrome = true,plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" },
				glue= {"stepDefinitions"}
				//tags="~@Two,@One"  or  tags={"~@Two,@One}"// tags works from this file only - they will not work if the project is entee
				)
public class LoginRunner2 extends AbstractTestNGCucumberTests{

}

