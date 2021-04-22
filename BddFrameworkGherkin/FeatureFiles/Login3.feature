
@tag
Feature: Title of your feature
  I want to use this template for my feature file

Background: 

  Given I want to write a step with precondition <name>  
 When I check for the <value> in step


    Scenario Outline: Title of your scenario
  
 
    
   
    Then I validate the outcomes
    

  @tag2
  Scenario Outline: Title of your scenario outline
   

    Then I verify the <status> in step

    Examples: 
      |  name      | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
