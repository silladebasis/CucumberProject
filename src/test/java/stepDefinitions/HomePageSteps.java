package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.PageObjectManager;
import utils.CommonUtils;
import utils.TestContextSetup;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HomePageSteps {
    public TestContextSetup testContext;
    public HomePage homePage;
    public HomePageSteps(TestContextSetup testContext){
        this.testContext = testContext;
        homePage = testContext.pageObjectManager.getHomePage();
    }
    @Given("User is on Greenkart Home Page")
    public void user_is_on_greenkart_home_page() {
        Assert.assertTrue(homePage.getHomePageTitle().contains("GreenKart"));
    }
    @When("User searches for product with {string}")
    public void user_searches_for_product_with(String productName) {
        homePage.searchProduct(productName);
    }
    @When("searched product is displayed")
    public void searched_product_is_displayed() {
        WebDriverWait wait = new WebDriverWait(testContext.driverManager.driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h4.product-name"), "Tomato"));
        testContext.actualProductName = homePage.getProductName().split("-")[0].trim();
        System.out.println("Display the product Name : " + testContext.actualProductName);
    }

    @When("product {string} is displayed")
    public void product_is_displayed(String searchedProduct) {
        WebDriverWait wait = new WebDriverWait(testContext.driverManager.driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h4.product-name"), searchedProduct));
        testContext.actualProductName = homePage.getProductName().split("-")[0].trim();
        System.out.println("Display the product Name : " + testContext.actualProductName);
    }

    @And("product is added to cart and proceeds to checkout")
    public void productIsAddedToCartAndProceedsToCheckout() throws InterruptedException {
        homePage.addToCart()
                .clickOnCheckoutLink()
                .clickOnProceedToCheckout();
    }

    @And("user adds {string} quantities of product")
    public void userAddsQuantitiesOfProduct(String quant) {
        homePage.enterQuantity(quant);
    }
}
