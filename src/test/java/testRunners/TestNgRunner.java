package testRunners;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/features/searchProduct.feature",
        glue = {"stepDefinitions","hooks"},
        dryRun = false,
        monochrome = true,
        //tags = "@E2E or @Sanity",
        plugin = {"pretty","html:target/cucumberReports.html","json:target/cucumberReport.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/failed_scenarios.txt"}
)
public class TestNgRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
