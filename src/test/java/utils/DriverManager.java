package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverManager {
    public WebDriver driver;
    public WebDriver DriverManager(){
        String browser_prop = PropertyReader.readData().getProperty("browser"); // to read values from properties file
        String browserConfig = System.getProperty("browser");
        String browser= browserConfig != null ? browserConfig : browser_prop;
        if(driver == null){
            if(browser.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            }
            else{
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }
}
