package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    public WebDriver Driver;
    public CheckoutPage(WebDriver driver){
        this.Driver = driver;
        PageFactory.initElements(Driver,this);
    }
    @FindBy(css = "tbody tr td:nth-child(2) p")
    private WebElement productName;
    @FindBy(id = "productCartTables")
    private WebElement tableDisplay;

    public String getProductNameInCheckout(){
        return productName.getText();
    }
    public boolean verifyProductIsDisplayed(){
        return productName.isDisplayed();
    }

    public void waitForTableToDisplay(){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOf(tableDisplay));
    }
}
