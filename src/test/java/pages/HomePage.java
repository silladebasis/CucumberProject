package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver Driver;
    public HomePage(WebDriver driver){
        this.Driver = driver;
        PageFactory.initElements(this.Driver,this);
    }
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBox;
    @FindBy(css = "h4.product-name")
    private WebElement productName;

    @FindBy(linkText = "Top Deals")
    private WebElement lnkTopDeals;
    @FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
    private WebElement addToCartButton;
    @FindBy(css = "a.cart-icon")
    private WebElement checkoutLink;
    @FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
    private WebElement proceedToCheckout;
    @FindBy(css = "input.quantity")
    private WebElement quantityText;

    public void searchProduct(String item){
        searchBox.sendKeys(item);
    }
    public String getProductName(){
        return productName.getText();
    }

    public void clickOnTopDeals(){
        lnkTopDeals.click();
    }
    public HomePage addToCart(){
        addToCartButton.click();
        return this;
    }
    public HomePage clickOnCheckoutLink(){
        checkoutLink.click();
        return this;
    }
    public HomePage clickOnProceedToCheckout(){
        proceedToCheckout.click();
        return this;
    }
    public String getHomePageTitle(){
        return Driver.getTitle();
    }
    public void enterQuantity(String quantity){
        quantityText.clear();
        quantityText.sendKeys(quantity);
    }
}
