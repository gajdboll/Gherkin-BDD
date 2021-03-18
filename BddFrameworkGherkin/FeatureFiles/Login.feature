 Feature: Testing of the Logging Application
  #comments below
   #in this case we change additional step and create one long step with 2 parameters 
   #- so they will be passed to the method as regular experession
  
 	 Scenario: Successful login to the app
  	Given Customer is on official app web
    #"amidn" & "password" is passed as argument in the method
    When Customer enters correct login as "admin" and enters correct password "pass123"
    And Customer clicks Login button
    Then Customer is successfully Logged in to the application