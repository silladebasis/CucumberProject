package utils;

import org.openqa.selenium.WebDriver;
import pages.PageObjectManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestContextSetup {
    public String actualProductName;
    public PageObjectManager pageObjectManager;
    public DriverManager driverManager;
    public CommonUtils commonUtils;
    public TestContextSetup() throws IOException {
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.DriverManager());
        commonUtils = new CommonUtils(driverManager.DriverManager());
    }
}
