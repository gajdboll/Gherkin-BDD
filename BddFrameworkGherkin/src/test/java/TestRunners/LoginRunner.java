package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features= {"C:\\Users\\kgajdosz\\Documents\\bench learning\\BDD\\Gherkin-Cucumber\\BddFrameworkGherkin\\FeatureFiles\\Login.feature"},
				glue= {"src/test/java/stepDefininitions"}
				//tags="~@Two,@One"   // tags works from this file only - they will not work if the project is entee
				)
public class LoginRunner {// extends AbstractTestNGCucumberTests{

}
