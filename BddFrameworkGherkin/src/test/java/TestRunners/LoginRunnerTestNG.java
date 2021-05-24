package TestRunners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
features="C:\\Users\\kgajdosz\\Documents\\bench learning\\BDD\\Gherkin-Cucumber\\BddFrameworkGherkin\\FeatureFiles", 
glue= {"stepDefininitions"},tags= "@One"
,monochrome = true,
plugin = { "pretty", "html:target/HTMLReport/HTMLREPORT.html",
"junit:target/JunitReport/report.xml",
"json:target/cucumber.json"
}
 
)

public class LoginRunnerTestNG extends AbstractTestNGCucumberTests{
	// That code alloews you to run all the test parallely
	 /*  @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }*/
	

	
	
}
