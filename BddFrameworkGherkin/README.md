# V8 - > Reporting in Cucumber


To create simple josn or html reporting we add additional paramerter in the testRunner class


below code replaced format version
 monochrome = true,plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" }

Once we have done that we can use Reporting system created by developer and we can download are read it thhrough from
https://github.com/damianszczepanik/cucumber-reporting (however we will use similar patch but got it from mvn dependenci / repository )because the one from the github should be used as a dependency not a plugin

First we add dependency from github into the plugins section



    <groupId>net.masterthought</groupId>
    <artifactId>maven-cucumber-reporting</artifactId>
    <version>(check version above)</version>

	<executions>
		<execution>
			<id>executions</id>
			<phase>verify</phase>
			<goals>
			<goal>generate</goal>
			</goals>
			<configuration>
			<projectName>Project name</projectName>
			<outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
			<cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
			</configuration>
		</execution>
	</executions>
from line 21 we added few lines because we will run that test from cmd / maven to prove that is working fine  

then we go to the source sttructure of the project (cmd structure source) and we type mvn clean - to remove all the target (all the previous runs)

then we enter mvn compile

and then mvn verify



On top of that we need to add additional configuration for maven-surfire-plugin - as below - full image
[if we will not add that configuration in the surfire plugin we will get exception as quick we run on the failed test case ]
	<plugin>
		
		 <groupId>org.apache.maven.plugins</groupId>
  		  <artifactId>maven-surefire-plugin</artifactId>
  		  <version>2.19.1</version>
		  <configuration>
			<testFailureIgnore>true</testFailureIgnore>
		  </configuration>
