 Feature: Testing of the Logging Application
  #comments below
   #in this case we change additional step and create one long step with 2 parameters 
   #- so they will be passed to the method as regular experession
  
  Background:  
  	Given Customer is on official app web
 ############################################################ 	
  	 Scenario Outline: Unsuccessful login to the app
  
    #"amidn" & "password" is passed as argument in the method
    When Customer enters correct <login> and <password>
    And Customer clicks Login button
    Then Customer is re-directed to web with <Welcome>
  	
  	Examples:
      | login    | password | Welcome    |
      | admin222 | pass1    | test       |
      | test34   | pass2    | expected 2 |
 ## Scenario for datatable scenario 	
 ################################################################
  Scenario: Successful/unsuccessful login to the app DataTables prt I

    When Customer enters correct login credentials
      | login | password |
      | admin | pass123  |
    And Customer clicks Login button
    Then Customer is successfully Logged in to the application	
 ################################################################
 Scenario: Successful/unsuccessful login to the app DataTables prt II

    When Customer enters correct or uncorrect login credentials from DBtables
      | login | password |
      | admin | pass123  |
    And Customer clicks Login button
    Then Customer is successfully Logged in to the application	        	
###################################################################   	
 	 Scenario: Successful login to the app

    #"amidn" & "password" is passed as argument in the method
    When Customer enters correct login as "admin" and enters correct password "pass123"
    And Customer clicks Login button
    Then Customer is successfully Logged in to the application