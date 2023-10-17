package stepDefinitions;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.PropertyReader;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class hooks {
    public TestContextSetup testContext;

    public hooks(TestContextSetup testContext){
        this.testContext = testContext;
    }
    @Before
    public void openBrowser(){
        openApplication();
    }

    @After
    public void closeBrowser(){
        testContext.driverManager.driver.quit();
    }

    @AfterStep
    public void captureScreenOnFailure(Scenario scenario) throws IOException {
        WebDriver driver = testContext.driverManager.driver;
        if(scenario.isFailed()){
            File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent,"image/jpeg","image");
        }
    }

    public void openApplication(){
        String URL = PropertyReader.readData().getProperty("qa_url");
        testContext.driverManager.driver.get(URL);
    }
}
