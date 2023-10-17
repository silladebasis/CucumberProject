package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CommonUtils {
    public TestContextSetup testContextSetup;
    public WebDriver driver;
    public CommonUtils(WebDriver driver){
        this.driver = driver;
    }

    public String switchToWindow(){
        Set<String> windows = driver.getWindowHandles();
        String url = null;
//        Iterator<String> iterator = windows.iterator();
//        String parentWindow = iterator.next();
//        String childWindow = iterator.next();
        for (String handle : windows){
            driver.switchTo().window(handle);
            url = driver.getCurrentUrl();
        }
        return url;

    }
}
