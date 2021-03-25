# V6 - Update of Existing code (add additional feature files & scenarios) & Transformations using Cucumber


First I created additional Login2.feature file with additional approach for DataTables - Solution2

That sec solution is handled by creating nested User class in the stepDefinition

Transformation:
- Extend Transformer <> class for the type to be transformed
- Override transform method
- call @ Transform annotation as parameter in calling method param

all the changes are made for new created Feature file (Login2.feature) and that change should only expalin how to use that transform solution - the solution is not making more seanse

Steps:
1) Create additional steps where transformation should make a place like:
- And Customers login is the prefix for email domain
- And Numbers of characters in the correct password length

then Create new package - lets call it Transformation and inside we create class called Email transformation - so that class will allow to make changes to the certain step (email
and it makes changes toi email field)
that class needs to be "extends Transformer"
Inside that class we create overridden  transform method whi we will use to make our changes.
Once our method is done and the body is implemented we come back to stepDefinitions

In the method - step we want to make chgange we simply add in th parameter part (@Ttransform(nazwaKlasyZKtorejMamyWykorzystac zmiany.class) typ parameter przekazywany) 
eg public void Login(@Transform(EnterLogin.class) String login){})

that is all :)

BTW - @Override transform method has only one parameter passed as the argument

The other thing is that Transformer work - as it s not making any errors to me on the screen, however the purpose of that is not met.
transformed variable is not passed to the step 