package stepDefininitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import BaseUtil.Base;
import Pages.LoginPages;
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

	private Base base;
	//private WebDriver Driver;
	public LoginSteps( ) {}
	//Dependency Injection
	public LoginSteps(Base base)
	{
		this.base = base;
	}
	@Before
	public void Beginning()
	{
		System.out.println("1. Official web");
	    WebDriverManager.chromedriver().setup();
	 //  System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		 Driver = new ChromeDriver();
	}
	@After
	public void TernDown()
	{ 	Driver.close();
		Driver.quit();		
		System.out.println("End.");	
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
		//WebElement loginBtn = Driver.findElement(By.name("btnLogin"));
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
}
