package TestRunners;

import org.testng.annotations.DataProvider;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
features="C:\\Users\\kgajdosz\\Documents\\bench learning\\BDD\\Gherkin-Cucumber\\BddFrameworkGherkin\\FeatureFiles", 
glue= {"stepDefininitions"},tags= " @Three"
,monochrome = true,
plugin = { "pretty", "html:target/HTMLReport/HTMLREPORT.html",
"junit:target/JunitReport/report.xml",
"json:target/cucumber.json"
}
 
)

public class LoginRunnerTestNG extends AbstractTestNGCucumberTests{
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}
