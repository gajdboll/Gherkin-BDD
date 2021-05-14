package stepDefininitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.ie.InternetExplorerDriver;

import BaseUtil.Base;
import Pages.LoginPages;
import Transformation.CorrectCredentials;
import Transformation.EmailTransform;
import Transformation.PassLength;
import cucumber.api.Transform;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps extends Base{

	//project structure saved into the vaRIABLE
	String path = System.getProperty("user.dir");
	 
	
	
	private Base base;
	//private WebDriver Driver;
	public LoginSteps( ) {}
	//Dependency Injection
	public LoginSteps(Base base)
	{
		this.base = base;
	}
//////////That listed part need to be added if we want to use nested class
//new object need to be updated with those details below?? no idea why yet - but only in new Cucumber
@DataTableType(replaceWithEmptyString = "[blank]")
public User convert(Map<String, String> entry){
  return new User(
          entry.get("login"),
          entry.get("password")
  );
}
	@Before
	public void Beginning()
	{
		System.out.println("1. Official web");
	    //WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver",path+chromeDriverPath);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kgajdosz\\Documents\\bench learning\\BDD\\Gherkin-Cucumber\\BddFrameworkGherkin\\Drivers\\ChromeDriver\\chromedriver.exe");
		//WebDriverManager.firefoxdriver().setup();
	  //  WebDriverManager.edgedriver().setup();
	  //  WebDriverManager.iedriver().setup();
	 //  System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		 
	}
	@After
	public void TernDown()
	{ 	Driver.close();
		Driver.quit();	
		Driver=null;
		System.out.println("End.");	
	}
	@Given("Customer is on official app web on Firefox")
	public void customer_is_on_official_app_web_on_firefox() {
		//base.Driver.get("http://demo.guru99.com/V4/");
		Driver = new ChromeDriver();
				Driver.navigate().to("http://demo.guru99.com/V4/");
			    String url = Driver.getCurrentUrl();
			    System.out.println("Customer enters page "+url); 
	}

	@Given("Customer is on official app web")
	public void customer_is_on_official_app_web() {    
		//base.Driver.get("http://demo.guru99.com/V4/");
		Driver.navigate().to("http://demo.guru99.com/V4/");
	    String url = Driver.getCurrentUrl();
	    System.out.println("Customer enters page "+url);   
	}
	@When("Customer enters correct login as {string} and enters correct password {string}")
	public void customer_enters_correct_login_as_and_enters_correct_password(String login, String pass) {
		System.out.println("2. Login process (correct credentials)");
		LoginPages page = new LoginPages(Driver);
		page.EnterLoginCredentials(login, pass);
	}
	@And("Customer clicks Login button")
	public void customer_clicks_login_button() {
		System.out.println("3. Button gets clicked");
		LoginPages page = new LoginPages(Driver);
		page.ClickLogin();
	}
	@Then("Customer is successfully Logged in to the application")
	public void customer_is_successfully_logged_in_to_the_application() {
		System.out.println("4. Successfully Logged In - Assertion");
		String expectedHtmlUrl= "http://demo.guru99.com/V4/manager/Managerhomepage.php";
		String actualurl = Driver.getCurrentUrl();
		//Before Asserts were invented - we could use - is statements
		if(expectedHtmlUrl.equalsIgnoreCase(actualurl)) { System.out.println("Success");} else {	Driver.close();
		Driver.quit();		System.out.println("Failure - try it next time");}
		Assert.assertEquals(actualurl,expectedHtmlUrl);
}
	//those (\\w+) when they are passed as arguments - or (.*) too
	@When("^Customer enters correct (\\w+) and (\\w+)$")
	public void customer_enters_correct_admin222_and_pass1(String login, String password) {
		System.out.println("5. Scenario Outline - Credentials passed ");
		LoginPages page = new LoginPages(Driver);
		page.EnterLoginCredentials(login, password);
	}
	//those (\\w+) when they are passed as arguments - or (.*) too
	@Then("^Customer is re-directed to web with (.*)$")
	public void customer_is_re_directed_to_web_with_test(String Welcome) {
		System.out.println("6. Moved to Web - with text - Assertion");
		String expectedTab= "Guru99 Bank Manager HomePage";
		//below there is error handler - driver
		if(Welcome.equalsIgnoreCase(expectedTab)) { System.out.println("Success");} else {	Driver.switchTo().alert().accept();	System.out.println("Failure - try it next time");
			}
		Assert.assertEquals(Welcome,expectedTab);	
	}
	@When("Customer enters correct login credentials")
	public void enterCredentialsFromDataTable(DataTable table) {
		System.out.println("7. Enter credentials based on dataTables");
		 //line below used for both techniques - possibilities
        List<List<String>> cells = table.cells();
        // quick way to hide selected code / text - > ctrl + Shift + "/"
        //System.out.println("The value is : " + cells.get(1).get(0));
        //System.out.println("The value is : " + cells.get(1).get(1));
        LoginPages page = new LoginPages(Driver);
		page.EnterLoginCredentials(cells.get(1).get(0), cells.get(1).get(1));
		
	}
	  @Given("Customer is on official app web on firefox")
      public void customer_enters_correct_admin222_and_pass1_on_firefox() 
      {
         System.out.println("Firefox Browser");
         Driver = new FirefoxDriver();
			Driver.navigate().to("http://demo.guru99.com/V4/");
		    String url = Driver.getCurrentUrl();
		    System.out.println("Customer enters page "+url); 
  }
	  @Given("Customer is on official app web on Edge")
      public void customer_enters_correct_admin222_and_pass1_on_Edge() 
      {
         System.out.println("Edge Browser");
         Driver = new EdgeDriver();
			Driver.navigate().to("http://demo.guru99.com/V4/");
		    String url = Driver.getCurrentUrl();
		    System.out.println("Customer enters page "+url); 
  }
	  
	  @Given("Customer is on official app web on IE")
      public void customer_enters_correct_admin222_and_pass1_on_IE() 
      {
         System.out.println("IE Browser");
         Driver = new InternetExplorerDriver();
			Driver.navigate().to("http://demo.guru99.com/V4/");
		    String url = Driver.getCurrentUrl();
		    System.out.println("Customer enters page "+url); 
      }
	//new methods for Tranformation scenario
	@When("Customer enters correct login credentials2")
	public void customer_enters_correct_login_credentials2(io.cucumber.datatable.DataTable table) {
		 //method raw no longer exist so we are using method cell to get access to cels
        //line below used for both techniques - possibilities
        List<List<String>> cells = table.cells();
        // quick way to hide selected code / text - > ctrl + Shift + "/"
        WebElement loginField = Driver.findElement(By.name("uid"));
        WebElement passField = Driver.findElement(By.name("password"));
 
       ///////////////////////////////////////////
        //sec posibility is : create an array list of users which stores all users
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for(User user:users){
            System.out.println("the UserName is: "+ user.login);
            loginField.sendKeys(user.login);
            
            System.out.println("the Password  is: "+ user.password);
            passField.sendKeys(user.password);
        }
	
	}
	//class used for DataTable example
	public class User {
        public String login;
        public String password;

        public User(String login, String password) 
        {
            this.login = login;
            this.password = password;
        }
       }
}