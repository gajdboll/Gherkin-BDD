# V4 - Dependency Injection

Before we start that concept I will make small modification - > I will move all the hooks into the separate class Hook.java
Then I will download cucumber picocontainer - because dependency Injection is not part of the Cucumber - and that dependency neeeds to be donwloaded if we want to test that



Version we will use is: <!-- https://mvnrepository.com/artifact/info.cukes/cucumber-picocontainer -->

    <artifactId>cucumber-picocontainer</artifactId>
    <version>1.2.5</version>
    
    copied into the pom file

Why do we need Dependency injection - most of the times we test using Selenium and then we use that technique which allows us to move driver (private) as a parameter of the constructor
That allows to inject that driver into the class and safely run the steps


###Usually we use separate class to keep all the Hooks - but for some reason our cucumber doesnt like that so i will keep
###all the hooks and steps in one class and that will allow us to progress.

btw Dependency Injection is passing object as the constructor parameter to the next class so it would be accessible in other class - especially Driver - 
dont forger to access private parameter before you will create constructor in the class (for some reason base prefix doesnt need to be mention / or it shouldnt be mention in terms of working the framework)
