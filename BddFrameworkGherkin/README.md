# V3 - Hooks & Tags

Hooks contains 2 annotations (only two not as the TestNG framework)

@Before (which is used to create / instantiate a driver object) 
@After (it is used to kill all the instances and close files / connections)


If we want to use the same object between 2 different classes (Hooks and step Definitions) @Before will trigger relevant methods always on the beginning of the each test
and @After in the end of each test.
If we want to use seperate classes for Webdriver We can use static webdriver in the Test class on modify only driver variable by calling "name of the class". driver
(example: LogisStep.driver.get("wp.pl")) - it is easie to make changes in the Hook class cause there are only few roes that are using that variable not like test class whoch contain all the methods / steps

you can always try to use extand technowue however you will get cucumber error saying that you are not allo to pass driver object like that

Example below:

???????????????????????????????????????????????????????????????????????????????
? Share your Cucumber Report with your team at https://reports.cucumber.io    ?
? Activate publishing with one of the following:                              ?
?                                                                             ?
? src/test/resources/cucumber.properties:    cucumber.publish.enabled=true    ?
? Environment variable:                      CUCUMBER_PUBLISH_ENABLED=true    ?
? JUnit:                                     @CucumberOptions(publish = true) ?
?                                                                             ?
? More information at https://reports.cucumber.io/docs/cucumber-jvm           ?
?                                                                             ?
? To disable this message, add cucumber.publish.quiet=true to                 ?
? src/test/resources/cucumber.properties                                      ?
???????????????????????????????????????????????????????????????????????????????
Exception in thread "main" io.cucumber.core.exception.CompositeCucumberException: There were 4 exceptions:
  io.cucumber.java.InvalidMethodException(You're not allowed to extend classes that define Step Definitions or hooks. class stepDefininitions.Hooks extends class stepDefininitions.LoginSteps)
  io.cucumber.java.InvalidMethodException(You're not allowed to extend classes that define Step Definitions or hooks. class stepDefininitions.Hooks extends class stepDefininitions.LoginSteps)
  io.cucumber.java.InvalidMethodException(You're not allowed to extend classes that define Step Definitions or hooks. class stepDefininitions.Hooks extends class stepDefininitions.LoginSteps)
  io.cucumber.java.InvalidMethodException(You're not allowed to extend classes that define Step Definitions or hooks. class stepDefininitions.Hooks extends class stepDefininitions.LoginSteps)
	at io.cucumber.core.runtime.CucumberExecutionContext.getException(CucumberExecutionContext.java:84)
	at io.cucumber.core.runtime.Runtime.run(Runtime.java:103)
	at io.cucumber.core.cli.Main.run(Main.java:79)
	at cucumber.api.cli.Main.run(Main.java:30)
	at cucumber.api.cli.Main.main(Main.java:15)


*****************************************************************************************************************

##What are Cucumber Tags?
Let’s say you have got many different feature files that cover all the different functionality of the application. Now there can be a certain situation in the project where you like to execute just a SmokeTests or End2EndTests or may be RegressionTests. One approach is that you start creating new feature files with the name of the type like SmokeTests.features or End2EndTests.feature and copy-paste your existing tests in the same. But this would make the project filthy and would require more maintenance in future. So how to manage execution in such cases?

Logically ANDing and ORing Tags
Requirements are complicated, it will not always simple like executing a single tag. It can be complicated like executing scenarios that are tagged either as @SmokeTest or @RegressionTest. It can also be like executing scenarios that are tagged both as @SmokeTest and @RegressionTest. Cucumber tagging gives us the capability to choose what we want with the help of ANDing and ORing.

 

Execute all tests tagged as @SmokeTest OR @RegressionTest

Tags that are comma-separated are ORed.

Cucumber Group Tags 9

Note: OR means scenarios that are tagged either as @SmokeTest OR @RegressionTest.

 

Execute all tests tagged as @SmokeTest AND @RegressionTest

Tags which are passed in separate quotes are ANDed

Cucumber Group Tags 9

Note: There are only two scenarios in our feature file which have both tags together.

 

 

How to Ignore Cucumber Tests
This is again a good feature of Cucumber Tags that you can even skip tests in the group execution. Special Character ~ is used to skip the tags. This also works both for Scenarios and Features. And this can also works in conjunction with AND or OR.

Execute all tests of the feature tagged as @FunctionalTests but skip scenarios tagged as @SmokeTest 

Cucumber Group Tags 9

Note: This is AND condition, which means all the scenarios tagged as @FunctionalTest but not @SmokeTest. So total tests are 15 and smoke tests are 6, so it ran just 9 tests.

 

Execute all tests which are not at all tagged in all the Features

Cucumber Group Tags 9

 

Execute all tests which are not at all tagged in Single Feature

Cucumber Group Tags 9

 

It is fun to play with tags, especially when you have many features files with multiple scenarios.
