# V11 - > Log4J

***************************************************************
Reference
https://www.youtube.com/watch?v=rbuR9Q_55h4&t=496s

https://springframework.guru/log4j-2-configuration-using-properties-file/
https://logging.apache.org/log4j/2.x/manual/configuration.html
https://www.quora.com/Why-use-Log4j#
https://www.quora.com/What-is-the-difference-between-log4j-xml-and-log4j-properties-in-Java
**********************************************************

MAKE SURE YOU WILL CREATE PROPERTIES FILE (CLASS OR XML) in the src/man()or test / resources - OTHERWISE YOU WILL SEE ONLY FATAL AND ERRORS********************

*******************************************************************
Step 1: Add log4j dependencies as below
*********************************************************
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
    </dependencies>

*****************************************
Step 2 – Add log4j2. properties in the source mention above - you will find that content odf that file in the file: Logs.java
********************************************

the part provided by me should contain name of the package we run alogs
logger.file.name=Utils
******************************************

appender.file.append=true  

it is set to true so logs getting upadated - if that line will be removed we will get only new entries

***************************************************

logger.trace("this is a trace  message"); - is not visible in the logs unl;ess we change : 


logger.file.level = debug    -> to  ---> logger.file.level = trace

++++++++++++++++++++++++++++++++++++++++++++++++++++++++

we can set loggs of in the lines:

logger.file.level = off
rootLogger.level = off


--------------------------------------------

Lo4j2,properties example class below

**********************************

status=info
name=properties_configuration

#Givedirectorypathwherelogfilesshouldgetstored
property.basePath=./logs/

#ConsoleAppenderwillprintlogsonconsole
appender.console.type=Console
appender.console.name=consoleLogger
appender.console.target=SYSTEM_OUT
appender.console.layout.type=PatternLayout

#Specifythepatternofthelogs
appender.console.layout.pattern=[%level] %d{yyyy-MM-ddHH:mm:ss.SSS} [%l]-%msg%n


#RollingFileAppenderwillprintlogsinfilewhichcanberotatedbasedontimeorsize
appender.rolling.type=RollingFile
appender.rolling.name=fileLogger
appender.rolling.fileName=${basePath}/Logs.log
appender.rolling.filePattern=${basePath}app_%d{yyyyMMdd}.log.gz
appender.rolling.layout.type=PatternLayout
appender.rolling.layout.pattern=%d{yyyy-MM-ddHH:mm:ss.SSS} %level [%t][%l]-%msg%n
appender.rolling.policies.type=Policies

#Rotatelogfileeachday
appender.rolling.policies.time.type=TimeBasedTriggeringPolicy
appender.rolling.policies.time.interval=1
appender.rolling.policies.time.modulate=true
appender.rolling.strategy.type=DefaultRolloverStrategy
appender.rolling.strategy.delete.type=Delete
appender.rolling.strategy.delete.basePath=${basePath}
appender.rolling.strategy.delete.maxDepth=1
appender.rolling.strategy.delete.ifLastModified.type=IfLastModified
#Deletefilesolderthan30days
appender.rolling.strategy.delete.ifLastModified.age=30d

#ClassesinthispackageorsubpackageswilluseConsoleAppenderandRollingFileAppenderforlogging
logger.hops-examples-hive.name=hops-examples-hive
logger.hops-examples-hive.level=debug
logger.hops-examples-hive.additivity=false
logger.hops-examples-hive.appenderRef.rolling.ref=fileLogger
logger.hops-examples-hive.appenderRef.console.ref=consoleLogger

#Configurerootloggerforloggingerrorlogsinclasseswhichareinpackageotherthanabovespecifiedpackage
rootLogger.level=info
rootLogger.additivity=false
rootLogger.appenderRef.rolling.ref=fileLogger
rootLogger.appenderRef.console.ref=consoleLogger



