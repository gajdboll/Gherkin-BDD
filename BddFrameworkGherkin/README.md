# V10 - > Extend report - another way of reporting

***************************************************************
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

  <dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.14.1</version>
  </dependency>
  
  <dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.14.1</version>
  </dependency>
*****************************************
Step 2 – Add Extent Config to the Project
********************************************
Extent Config is required by the Cucumber Extent Report plugin to read the report configuration. As it gives the capability to set many useful settings to the report from the XML configuration file.

1. Create a New File and name it as extent-config.xml by right click on the configs folder in the project. In this config file you can set many elements like :

Report Theme : <theme> : standard or dark
Document Encoding : <encoding> : UFT-8
Title of the Report : <documentTitle> : This will display on the Browser Tab
Name of the Report: <reportName>: This will display at the top of the Report
Global Date Format : <dateFormat> : Like this yyyy-MM-dd
Global Time Format  : <timeFormat> : Like this HH:mm:ss

**************************************
Step 3: Read the extent-config.xml path
****************************************
1. Make an entry for the Path of the config in the Configuration.properties file.

reportConfigPath=C:/ToolsQA/CucumberFramework/configs/extent-config.xml

Note: Make sure to edit the path as per your machine path.

 