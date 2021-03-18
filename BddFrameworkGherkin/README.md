# Initial faze of BDD project For some reason CUMCUMER version 6.6.0 works fine

We are using Eclipse IDE to run the BDD project (I encounter some difficulties to do the same on IntellyJ IDE)

Additional .gitigore file created to keep target / jars & pom file secured

All pom dependencies are attached in this file as reference:


###Important notice: - version 6.6.0 of cucumber used for that project
Version 6.6.0 attached - working version (known)


Dependencies attached to that pom file:

/**************************************

            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-server -->

            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-server</artifactId>
            <version>3.141.59</version>
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->

            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>6.6.0</version>
         
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
       
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>6.6.0</version>
            <scope>test</scope>
      
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-core -->
     
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-core</artifactId>
            <version>6.6.0</version>
    
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-jvm-deps -->
     
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-jvm-deps</artifactId>
            <version>1.0.6</version>
            <scope>provided</scope>
   
<!-- https://mvnrepository.com/artifact/io.cucumber/gherkin -->
      
            <groupId>io.cucumber</groupId>
            <artifactId>gherkin</artifactId>
            <version>15.0.2</version>
       
<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->

            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>4.3.1</version>
            <scope>test</scope>
     
 <!-- https://mvnrepository.com/artifact/org.testng/testng -->
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.1.0</version>
            <scope>test</scope>
 <!--                 -->    
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
   
*****************************************/
###The first step is to create FOLDER / directory (not a package with feature files)

Feature Files that s English language with all the steps of represented scenario which allows business understand 
to understand test(s) - that feature is mapped with correct automation process (correct steps) allowing 
run certain test.

After that we need to create Test Runner (part of JUNIT library ) which runs our tests

And the last part of that is create java class with all the steps - hoe to recreate test.
That part is mapped with feature files - and is not necessarily  understood by business


