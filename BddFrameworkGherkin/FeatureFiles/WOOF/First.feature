
Feature: Add Personal Data section in the Woof system
This function allows you to enter the data of persons who have to pay dog tax. 
The data involved include surname, street, city and other data relevant to the assessment.
The data must be accessible by other processes within 3 seconds after entry. 
This function will be required 250 times per year.


Background: Given Customer is on the official Woof app 
  @Name
  Scenario Outline: F-322.1	Data item surname must be filled in.
    
    When Customer leaves empty <Surname>
    And enters,<Initials>,<Prefix><Street>,<Number>,<Postcode>,<City>,<Income><Date of birth>,<dogs>
    Then Error <Message> occurs on the screen

##Press F8 to save this data.
##Press F10 to leave this function.

    Examples: 
     Surname	|		Initials	 |	Prefix		|	Street			|	Number	|	Postcode		|		City				|	Income		|		Date of birth |	dogs	|	Message									|
				""		|		"KG"			 |		"IRL"		|		"Oak Rd."	|			4		|		"D04"			|		"Greyhound" |	5000,00		| 	17061990			| 1			|	"Surname is mandatory"	|
  @Name
  Scenario Outline: F-322.23	Data item surname must be alphabetic.
    
    When Customer non alphabetic <Surname>
    And enters,<Initials>,<Prefix>,<Street>,<Number>,<Postcode>,<City>,<Income><Date of birth>,<dogs>
    Then Error <Message> occurs on the screen

##Press F8 to save this data.
##Press F10 to leave this function.
 
  Examples: 
     Surname			|		Initials	 |	Prefix		|	Street			|	Number	|	Postcode		|		City				|	Income		|		Date of birth |	dogs	|	Message											|
				"$£()"		|		"KG"			 |		"IRL"		|		"Oak Rd."	|			4		|		"D04"			|		"Greyhound" |	5000,00		| 	17061990			| 1			|	"Surname is not alphabetic"	|
@Initials
  Scenario Outline: F-322.2	Data item initials must be filled in.
    
    When Customer  leaves empty <Initials>
    And enters,<Surname>,<Prefix>,<Street>,<Number>,<Postcode><City>,<Income><Date of birth>,<dogs>
    Then Error <Message> occurs on the screen

##Press F8 to save this data.
##Press F10 to leave this function.
 
  Examples: 
     Surname			|		Initials	 |	Prefix		|	Street			|	Number	|	Postcode		|		City				|	Income		|		Date of birth |	dogs	|	Message									|
				"Brown"		|		""				 |		"IRL"		|		"Oak Rd."	|			4		|		"D04"			|		"Greyhound" |	5000,00		| 	17061990			| 1			|	"Initials is mandatory"	|
@Initials
  Scenario Outline: F-322.24	Data item initials may not be numeric
    
    When Customer  enters numeric <Initials>
    And enters,<Surname>,<Prefix>,<Street>,<Number>,<Postcode><City>,<Income><Date of birth>,<dogs>
    Then Error <Message> occurs on the screen

##Press F8 to save this data.
##Press F10 to leave this function.
 
  Examples: 
     Surname			|		Initials		 |	Prefix		|	Street			|	Number	|	Postcode		|		City				|	Income		|		Date of birth |	dogs	|	Message												|
				"Brown"		|		"123"				 |		"IRL"		|		"Oak Rd."	|			4		|		"D04"			|		"Greyhound" |	5000,00		| 	17061990			| 1			|	"Initials is not alphabetic"	|

  @Prefix
  Scenario Outline: F-322.23	Data item surname must be alphabetic.
    
    When Customer non alphabetic <Prefix>
    And enters <Surname>,<Initials>,<Street>,<Number>,<Postcode><City>,<Income><Date of birth>,<dogs>
    Then Error <Message> occurs on the screen

##Press F8 to save this data.
##Press F10 to leave this function.
 
  Examples: 
     Surname			|		Initials	 |	Prefix		|	Street			|	Number	|	Postcode		|		City				|	Income		|		Date of birth |	dogs	|	Message											|
				"Brown"		|		"KG"			 |	"$£()"		|		"Oak Rd."	|			4		|		"D04"			|		"Greyhound" |	5000,00		| 	17061990			| 1			|	"Prefix is not alphabetic"	|
 
 
 		
