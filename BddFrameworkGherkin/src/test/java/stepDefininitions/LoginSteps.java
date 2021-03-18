package stepDefininitions;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("Customer is on official app web")
	public void customer_is_on_official_app_web() {
	    System.out.println("1. Official web");
	}

	@When("Customer enters correct login as {string} and enters correct password {string}")
	public void customer_enters_correct_login_as_and_enters_correct_password(String login, String pass) {
		System.out.println("2. Login process (correct credentials)");
	}

	@And("Customer clicks Login button")
	public void customer_clicks_login_button() {
		System.out.println("3. Button gets clicked");
	}

	@Then("Customer is successfully Logged in to the application")
	public void customer_is_successfully_logged_in_to_the_application() {
		System.out.println("4. Successfully Logged In");
	}
	//those (\\w+) when they are passed as arguments - or (.*) too
	@When("^Customer enters correct (\\w+) and (\\w+)$")
	public void customer_enters_correct_admin222_and_pass1(String login, String password) {
		System.out.println("5. Scenario Outline - Credentials passed ");
	}
	//those (\\w+) when they are passed as arguments - or (.*) too
	@Then("^Customer is re-directed to web with (.*)$")
	public void customer_is_re_directed_to_web_with_test(String Welcome) {
		System.out.println("6. Moved to Web - with text");
	}
	@When("Customer enters correct login credentials")
	public void enterCredentialsFromDataTable(DataTable table) {
		System.out.println("7. Enter credentials based on dataTables");
		 //line below used for both techniques - possibilities
        List<List<String>> cells = table.cells();
        // quick way to hide selected code / text - > ctrl + Shift + "/"
        System.out.println("The value is : " + cells.get(1).get(0));
        System.out.println("The value is : " + cells.get(1).get(1));
    
	}


	
}
