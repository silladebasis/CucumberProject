package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.PageObjectManager;
import utils.TestContextSetup;

import java.time.Duration;

public class CheckoutPageSteps {
    public TestContextSetup testContext;
    public CheckoutPage checkoutPage;
    public CheckoutPageSteps(TestContextSetup testContext){
        this.testContext = testContext;
        checkoutPage = testContext.pageObjectManager.getCheckoutPage();
    }
    @Then("added product {string} is displayed in the checkout")
    public void productIsDisplayedInTheCheckout(String expectedProduct) throws InterruptedException {
        checkoutPage.waitForTableToDisplay();
        String actualProductName = checkoutPage.getProductNameInCheckout();
        System.out.println("Product Name in Checkout Page is : " + actualProductName);
        Assert.assertEquals(actualProductName, expectedProduct);
        Assert.assertTrue(checkoutPage.verifyProductIsDisplayed(),"Product is displayed in checkout page");
    }
}
