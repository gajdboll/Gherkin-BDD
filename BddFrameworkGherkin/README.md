# V10 - > Extend report - another way of reporting

***************************************************************
Reference
https://www.youtube.com/watch?v=6ic95TgkcEY&t=195s
**********************************************************


*******************************************************************
Step 1: Add Cucumber Extent Reporter library to Maven Project
*********************************************************
This is really simple, as we have been using Maven Project,
 all we need to do is to add the dependencies in to the project POM file. 
Dependencies information can be taken from Maven Repository – Cucumber Extent Reporter.

<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.0.8</version>
</dependency>

<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports-cucumber4-adapter -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports-cucumber4-adapter</artifactId>
    <version>1.2.1</version>
</dependency>

*****************************************
Step 2 – Add Extent Config to the Project - which is nothng else but the class ExtendListener class  - which contains all the set up needed for that
********************************************


Report Theme : <theme> : standard or dark
Document Encoding : <encoding> : UFT-8
Title of the Report : <documentTitle> : This will display on the Browser Tab
Name of the Report: <reportName>: This will display at the top of the Report
Global Date Format : <dateFormat> : Like this yyyy-MM-dd
Global Time Format  : <timeFormat> : Like this HH:mm:ss

**************************************
Step 3: Crete listener class - so we set that up what we will raise it in term of pass / fail skip etc.
***************************************
**************************************
Step 4: Add hte listener in the testNG .xml file as below
***************************************
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >

<suite name="Suite" verbose="1" configfailurepolicy="skip">
  <test name="Test">  
  	<classes>
  	 		<class name ="TestRunners.LoginRunnerTestNG"/>
  		 
 	 </classes>
  </test> 
 	 <listeners>
		<listener class-name="Utils.TestListener">

	</listener>  
  </listeners>
</suite> <!-- Suite -->

**************************************
Step 5: Modify the step def class ad aad object ExtendReport as well as try catch block so we could catch the results, make a screenshot and create report
****************************************
**************************************

**************************************
Step 6: Once that is done we can run the program from testng.xml file and report is created in the seperate folder as well as the screenshots
****************************************



 