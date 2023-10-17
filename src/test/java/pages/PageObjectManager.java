package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private HomePage homePage;
    private DealsPage dealsPage;
    private CheckoutPage checkoutPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){
        homePage = new HomePage(driver);
        return homePage;
    }

    public DealsPage getDealsPage(){
        dealsPage = new DealsPage(driver);
        return dealsPage;
    }

    public CheckoutPage getCheckoutPage(){
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
}
