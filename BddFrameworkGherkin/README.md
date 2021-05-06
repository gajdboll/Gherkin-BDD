# V8 - > Reporting in Cucumber - Maven reporting


To create simple json or html reporting we add additional paramerter in the testRunner class


below code replaced format version
 monochrome = true,plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" }

Once we have done that we can use Reporting system created by developer and we can download are read it thhrough from
https://github.com/damianszczepanik/cucumber-reporting (however we will use similar patch but got it from mvn dependencies / repository )
because the one from the github should be used as a dependency not a plugin

First we add dependency from github into the plugins section



    <groupId>net.masterthought</groupId>
    <artifactId>maven-cucumber-reporting</artifactId>
    <version>(check version above example 3.0.0)</version>

	<executions>
		<execution>
			<id>executions</id>
			<phase>verify</phase>
				<goals>
					<goal>generate</goal>
				</goals>
			<configuration>
			<projectName>Project name - Bdd Project</projectName>
				<outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
				<cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
			</configuration>
		</execution>
	</executions>
from line 21 we added few lines because we will run that test from cmd / maven to prove that is working fine  

then we go to the source structure of the project (cmd structure source) and we type mvn clean - to remove all the target (all the previous runs)

then we enter mvn compile

and then mvn verify


On top of that we need to add additional configuration for maven-surfire-plugin - as below - full image
[if we will not add that configuration in the surfire plugin we will get exception as quick we run on the failed test case ]
	
	
	Sometimes additional lines need to be added to the POM - I will add full pom so you will not lose the track of it.
	however - additionally you will need to go to the build path and specify the version of the compiler and change the library build from JRE to JDK
	
	
	Additional thing is from Maven drop down (right click on project - maven) we select update project and then forced update
	DO THAT STEP AFTER ALL CHANGES!!!
	
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>BddGroup</groupId>
  <artifactId>BddFrameworkGherkin</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>BddFrameworkGherkin</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
     <maven.compiler.target>1.8</maven.compiler.target>
 	 <maven.compiler.source>1.8</maven.compiler.source>
 
    
  </properties>

<build>
	<plugins>
		<plugin>
		
		<groupId>org.apache.maven.plugins</groupId>
   		 <artifactId>maven-compiler-plugin</artifactId>
   		 <version>3.8.1</version>
		 <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
		</plugin>
		<plugin>
		
		 <groupId>org.apache.maven.plugins</groupId>
  		  <artifactId>maven-surefire-plugin</artifactId>
  		  <version>2.22.0</version>
		  <configuration>
			<testFailureIgnore>true</testFailureIgnore>
		  </configuration>
		</plugin>
		<plugin>
	 
    		<groupId>net.masterthought</groupId>
   			 <artifactId>maven-cucumber-reporting</artifactId>
    			<version>2.8.0</version>
 
						<executions>
							<execution>
								<id>executions</id>
								<phase>verify</phase>
								<goals>
								<goal>generate</goal>
								</goals>
								<configuration>
								<projectName>BddFrameworkGherkin</projectName>
								<outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
								<cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
								</configuration>
							</execution>
					</executions> 
			</plugin>
	</plugins>
</build>
 <dependencies>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
      
      

        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>6.9.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>6.9.1</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-core -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-core</artifactId>
            <version>6.9.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-jvm-deps -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-jvm-deps</artifactId>
            <version>1.0.6</version>
            <scope>provided</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/gherkin -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>gherkin</artifactId>
            <version>15.0.2</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->

        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>4.3.1</version>
            <scope>test</scope>
        </dependency>
      
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/info.cukes/cucumber-picocontainer -->
		<dependency>
   		 <groupId>info.cukes</groupId>
   		 <artifactId>cucumber-picocontainer</artifactId>
    		<version>1.2.4</version>
    		<scope>test</scope>
		</dependency>
        
		
		<!-- testng dependencies are missing from that example-->


</project>
	
	