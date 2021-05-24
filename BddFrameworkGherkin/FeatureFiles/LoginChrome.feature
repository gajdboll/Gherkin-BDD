Feature: Testing of the Logging Application

  #comments below
  #in this case we change additional step and create one long step with 2 parameters
  #- so they will be passed to the method as regular experession
  Background: 
    Given Customer is on official app web

  ############################   I   ################################
  @One @Parallel
  Scenario Outline: Unsuccessful login to the app
   
    When Customer enters correct <login> and <password> 
    And Customer clicks Login button
    Then Customer is re-directed to web with <Welcome>

    Examples: 
      | login      | password | Welcome                      |
      #| admin222   | pass1    | Guru - test                  |
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
   @Tree
  # @ExTestWithTable
  Scenario Outline: Check login is succesful with valid credential
   
     When user enters "<sheetName>" and <RowNumber> 
     And Customer clicks Login button
    Then Customer is re-directed to web with <Welcome>

    Examples: 
      | sheetName | RowNumber |Welcome |
      | Login     |         0 |Guru99 Bank Manager HomePage |  
      | Login     |         1 |Guru99 Bank Manager HomePage |  
     # | Login     |         2 |Guru99 Bank Manager HomePage |  
     # | Login     |         3 |Guru99 Bank Manager HomePage |  

    
    
    
