package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features= {"FeatureFiles/Login2.feature"},
				glue= {"stepDefinitions"}
				//tags="~@Two,@One"   // tags works from this file only - they will not work if the project is entee
				)
public class LoginRunner2 {

}
