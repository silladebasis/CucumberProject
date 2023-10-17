package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.DealsPageSteps;

public class DealsPage {
    public WebDriver Driver;
    public DealsPage(WebDriver driver){
        this.Driver = driver;
        PageFactory.initElements(this.Driver,this);
    }

    @FindBy(id = "search-field")
    private WebElement searchField;
    @FindBy(css = "tr td:nth-child(1)")
    private WebElement productName;

    public void searchProductInDeals(String item){
        searchField.sendKeys(item);
    }
    public String getProductNameInDeals(){
        return productName.getText();
    }
}
