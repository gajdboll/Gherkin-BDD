# V3 Implementation of the Selenium code in terms of Front -End testing

The sec part of resolution for DataTable section got removed (code didn't work with current version of Cucumber and can be found in the previous version of code)

In this branch Selenium code will be attached to indicate how BDD code can be connected with selenium.

webDriverManager will be used instead of downloading correct driver on the drive - that saves a time and all the instances of the driver can be found using that solution

More information you can easly find by searching in the google search once typed WebDriverManager - git repository contains all necessary informations

The other source of information is code presented on this branch: only correct dependencies are needed and one line of code is changes 
(instead of SystemProperty with correct location of the chromedriver - WebDriverManager comes in place), and that saves the time and it is easy in use.


## In this branch I have added concept of tags - because I didnt want to run all the test cases in one go

If we want to use tags we need to inititate tag using @ symbol and word after words which specify the tag we want to run on each iteration

(1) The tags should appears in the feature file above needed scenario 
(2) The rest of the journey is to include that tag in the testRunner file by adding tag word -> 

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles",
				glue= {"stepDefinitions"},
				tags = "@Two"
				)
public class LoginRunner {}

*Character ~ to skip the tags
*OR or Comma : Runs the scenario if it has at least one give tag, there are separated with comma, all the tags will be included in one double quote like {"Sanity, smoke, regression"}
*AND or Quotes : Runs the scenario if it has all the given tags, all the tags are separated with double quotes {"Sanity", "smoke", "regression"}

## In this branch I have added concept of Hooks - to initiate what we always need to do on front before we start each test and in the end when we always finish test

@After & @Before -> that s only 2 examples of cucumber annotations - they are many more but you can find them on official cucumber site


