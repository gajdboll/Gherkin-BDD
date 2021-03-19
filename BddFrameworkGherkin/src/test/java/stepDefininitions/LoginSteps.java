package stepDefininitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
/////////That listed part need to be added if we want to use nested class
//new object need to be updated with those details below?? no idea why yet - but only in new Cucumber
/*  Below internal nested class is the example of the sec way of DataTables presentation but it doesn t
 * work with that version of Cucumber and is not used as much as the first idea
 * The code below is commented and the end of that scrip which is part of that sec solution
 * @DataTableType(replaceWithEmptyString = "[blank]")
 *
public User convert(Map<String, String> entry){
    return new User(
            entry.get("login"),
            entry.get("password")
    );
   */ //////////////////////////////////
}

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
/* sec part of the DataTable solution
	@When("Customer enters correct or uncorrect login credentials from DBtables")
	public void customer_enters_correct_or_uncorrect_login_credentials_from_d_btables(DataTable table) {
		System.out.println("7. Enter credentials based on dataTables");
		 //line below used for both techniques - possibilities
        List<List<String>> cells = table.cells();
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for(User user:users){
            System.out.println("the UserName is: "+ user.login);
            System.out.println("the Password  is: "+ user.password);        
	}*/

}
