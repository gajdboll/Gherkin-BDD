# V9 Parallel testing
------------------------------




*********Reference*********************************************************************************************************************
https://cucumber.io/docs/guides/parallel-execution/#testng

https://maven.apache.org/surefire/maven-surefire-plugin/examples/fork-options-and-parallel-execution.html

https://www.youtube.com/watch?v=OnpuqA2lPUk&list=PLUeDIlio4THGVyUyXUQniMu7Vagd9d_5P&index=12
****************************************************************************************************************************
TestNg .xml file - how to reduce number of threads below
++++++++++++++++++++++++++++++++++++++++++++++++++++++

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >

<suite name="Suite" verbose="1" configfailurepolicy="skip" data-provider-thread-count="3">
  <test name="Test">  
  	<classes>
  	 		<class name ="TestRunners.LoginRunner"/>
  		<class name ="TestRunners.LoginRunner2"/>
 	 </classes>
  </test> 
</suite> <!-- Suite -->

**********************
Parallel Test Execution
Basically, there are two ways in maven-surefire-plugin to achieve parallel test execution.

The most obvious one is by using the parallel parameter. The possible values depend on the test provider used. 
For JUnit 4.7 and onwards, this may be methods, classes, both, suites, suitesAndClasses, suitesAndMethods, classesAndMethods or all. 
As a prerequisite in JUnit tests, the JUnit runner should extend org.junit.runners.ParentRunner. 
If no runner is specified through the annotation @org.junit.runner.RunWith, the prerequisite is accomplished.

As of maven-surefire-plugin:2.16, the value "both" is deprecated but it still can be used and behaves same as classesAndMethods.

See the example pages for JUnit and TestNG for details.
***************************************************************************************************************************************

TestNG
Cucumber can be executed in parallel using TestNG and Maven test execution plugins by setting the dataprovider parallel option to true. In TestNG the scenarios and rows in a scenario outline are executed in multiple threads. One can use either Maven Surefire or Failsafe plugin for executing the runners.

Create a Maven project in your favorite IDE adding Cucumber dependencies to the POM as detailed here and TestNG dependencies here.

Add the two feature files (scenarios.feature and scenario-outlines.feature) and step definition class as described in the JUnit section.

Add a cucumber runner by extending the AbstractTestNGCucumberTests class and overriding the scenarios method in the parallel package (same name as step definition package) in src/test/java folder. Set the parallel option value to true for the DataProvider annotation.
package parallel;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class RunCucumberTest extends AbstractTestNGCucumberTests{

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
Add the Maven Surefire plugin configuration to the build section of the POM.
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.0</version>
</plugin>
Use the Maven install or a suitable command to execute the POM. This should run in parallel thread mode. You should see a result similar to below. The scenarios and rows of the scenario outlines are executed in different threads.
Thread ID - 15 - Scenario Outline Row 2 from scenario-outlines feature file.
Thread ID - 14 - Scenario Outline Row 1 from scenario-outlines feature file.
Thread ID - 16 - Scenario 1 from scenarios feature file.
Thread ID - 17 - Scenario 2 from scenarios feature file.
To execute using a Maven Failsafe plugin, setup the POM as described in the JUnit section. Remove the parallel and useUnlimitedThreads settings in the configuration part.
The default thread count of the dataprovider in parallel mode is 10. To change this the dataproviderthreadcount property needs to be added to the configuration section of the Surefire or Failsafe plugin in the POM.

<configuration>
    <properties>
        <property>
            <name>dataproviderthreadcount</name>
            <value>20</value>
        </property>
    </properties>
</configuration>
If you have multiple runners, set the parallel configuration to classes to reduce execution times. In addition the threadCount can be set to to the desired value or useUnlimitedThreads can be set to true.

<configuration>
    <parallel>classes</parallel>
    <threadCount>4</threadCount>
</configuration>
*********************************************************************************************************
 
Parallel testin with BDD - work for Feature file - that allows code to be run quicker - all the features are run sepearatly on tests 
all changes you can make in the xml file for testNG or POM for maven project

