 Feature: Testing of the Logging Application
  #comments below
   #in this case we change additional step and create one long step with 2 parameters 
   #- so they will be passed to the method as regular experession
  
  Background:  
  	Given Customer is on official app web
  	
  	 Scenario Outline: Unsuccessful login to the app
  
    #"amidn" & "password" is passed as argument in the method
    When Customer enters correct <login> and <password>
    And Customer clicks Login button
    Then Customer is re-directed to web with <Welcome>
  	
  	Examples:
      | login    | password | Welcome    |
      | admin222 | pass1    | test       |
      | test34   | pass2    | expected 2 |
  	
 	
 	 Scenario: Successful login to the app
  
    #"amidn" & "password" is passed as argument in the method
    When Customer enters correct login as "admin" and enters correct password "pass123"
    And Customer clicks Login button
    Then Customer is successfully Logged in to the application