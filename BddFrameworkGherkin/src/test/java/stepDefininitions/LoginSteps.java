package stepDefininitions;

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
	
}
