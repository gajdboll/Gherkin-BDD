# V5 Page Object Model/ Pattern - POM

POM is used to group all the pages in separate classes - all those classes usually are in the separate package too so the y are orginized.
In our example we created Pages package and inside we created Login Page class which contain all the elements and etc. - check the code

Below you will find the way we initializing elements on the page

@FindBy(how = How.NAME, using ="uid")
	public WebElement UserName;
	
	Once that is done we create methods that we can  re-use later in the LoginDefinitions
	The only thing is that in the definitioSteps page we need to create object before we call methods from, Page package (POM class)
	
	The last but not at least is to create Constuctor in the LoginPage POM class
	
	public LoginPages(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	PageFactory is run inside contructor so it s responsible to create all elements from the page - and it has driver in the parameter do initialise the page.
	Not the best practice but we will change it later - that only allows us to move to the next level of testing
	
	The last step is make changes to each step - and in each step create Object of the page we are working on - our case Login page
	and then next run the method - all the details you can see in the code