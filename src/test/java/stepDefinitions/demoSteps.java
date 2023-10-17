package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class demoSteps {

    @Given("User is on NetBanking page")
    public void user_is_on_net_banking_page() {
        System.out.println("User is on landing page");
    }

    @When("user login into the application with {string} and password {string}")
    public void userLoginIntoTheApplicationWithAndPassword(String username, String password) {
        System.out.println("Username is : " + username + " And password is : " + password);
    }
    @Then("Home Page is displayed")
    public void home_page_is_displayed() {
        System.out.println("Home page is displayed");
    }

    @When("user login into application {string} and password {string} with multiple data")
    public void userLoginIntoApplicationAndPasswordWithMultipleData(String username, String password) {
        System.out.println("Username is : " + username + " And password is : " + password);
    }
}
