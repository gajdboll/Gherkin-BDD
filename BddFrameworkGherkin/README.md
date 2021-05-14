# V8 - > Adding Excel to the test - Data Driven testing

****************Ithems needed***********************************************
1)Dependecies needed - POI library

<!-- POI-->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>5.0.0</version>
		</dependency>
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.0.0</version>
		</dependency>
	
		<dependency>
		    <groupId>com.itextpdf</groupId>
		    <artifactId>itextpdf</artifactId>
		    <version>5.5.13</version>
		</dependency>
----------------
2) ExcelReader class (I will add 2 classes just in case - one was previously used in Baldoyle but I will use the one from QAtools web)
 they are attached in the Utils package
 
3) modification of the featuer file - adding additional tests which will pull informations from excel
 
4) addidng excel to teh project