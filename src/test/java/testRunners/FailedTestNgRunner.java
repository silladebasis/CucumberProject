package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failed_scenarios.txt",
        glue = {"stepDefinitions"},
        dryRun = false,
        monochrome = true,
        //tags = "@E2E or @Sanity",
        plugin = {"pretty","html:target/cucumberReports.html","json:target/cucumberReport.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        }
)
public class FailedTestNgRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
