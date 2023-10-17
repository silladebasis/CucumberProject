package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DealsPage;
import pages.HomePage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class DealsPageSteps {

    String expectedProductName;
    public TestContextSetup testContext;
    public DealsPage dealsPage;
    public HomePage homePage;
    public DealsPageSteps(TestContextSetup testContext){
        this.testContext = testContext;
        dealsPage = testContext.pageObjectManager.getDealsPage();
        homePage = testContext.pageObjectManager.getHomePage();
    }

    @When("User searches for same product {string} in Deals Page")
    public void user_searches_for_same_product_in_deals_page(String product) {
        homePage.clickOnTopDeals();
        String URL = testContext.commonUtils.switchToWindow();
        if(URL.contains("/offers")){
            System.out.println("Switched to correct window");
            dealsPage.searchProductInDeals(product);
        }

    }
    @Then("User should see the searched product")
    public void user_should_see_the_searched_product() {
        expectedProductName = dealsPage.getProductNameInDeals();
        Assert.assertEquals(testContext.actualProductName,expectedProductName);
    }

}
