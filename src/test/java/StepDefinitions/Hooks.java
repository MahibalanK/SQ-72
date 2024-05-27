package StepDefinitions;

import Managers.FileReaderManager;
import Utilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;

import java.net.MalformedURLException;

public class Hooks {

    TestContext testContext;
    WebDriver webDriver;

    public Hooks(TestContext context) {
        testContext = context;
    }

  /*  This before Method will setup Android Driver and Launch APP URL
  * to kick off the TEST execution*/
    @Before
    public void setUp() throws MalformedURLException {
        webDriver = testContext.getDriverManager().getDriver();
        if(FileReaderManager.getInstance().getConfigFileReader().getAppPackage().equalsIgnoreCase("nc")){
            webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());

        }
         System.out.println("Launched url");
    }


    /*If scenario failed ,then Taking screenshot logic */
    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (WebDriverException | MalformedURLException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        testContext.getDriverManager().closeDriver();
    }
}
