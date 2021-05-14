Feature: Testing of the Logging Application

  #comments below
  #in this case we change additional step and create one long step with 2 parameters
  #- so they will be passed to the method as regular experession
  Background: 
    Given Customer is on official app web

  ############################   I   ################################
  @One
  Scenario Outline: Unsuccessful login to the app
    #"amidn" & "password" is passed as argument in the method
    When Customer enters correct <login> and <password> 
    And Customer clicks Login button
    Then Customer is re-directed to web with <Welcome>

    Examples: 
      | login      | password | Welcome                      |
      | admin222   | pass1    | Guru - test                  |
      | mngr322726 | ratahYn  | Guru99 Bank Manager HomePage |       

  ## Scenario for datatable scenario
  ############################   II   ####################################
  @Two
  Scenario: Successful/unsuccessful login to the app DataTables prt I
    When Customer enters correct login credentials
      | login      | password |
      | mngr312054 | yjabYvA  |
    And Customer clicks Login button
    Then Customer is successfully Logged in to the application

  ###############################   III   #################################
  @Three
  @ExTestWithTable
  Scenario Outline: Check login is succesful with valid credential
   
   
    When user enters "<sheetName>" and <RowNumber> 
    And user click on login button and fill out the form
    Then user is navigate to home page`

    Examples: 
      | sheetName | RowNumber |condition|
      | Login     |         0 |Login|
      | Login     |         1 |Login|
      | Login     |         2 |Login|
      | Login     |         3 |Login|

    
    
    
