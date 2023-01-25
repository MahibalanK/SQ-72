package StepDefinitions;

import Managers.FileReaderManager;
import Utilities.TestContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.net.MalformedURLException;

public class Hooks {

    TestContext testContext;
    AppiumDriver<MobileElement> webDriver;

    public Hooks(TestContext context) {
        testContext = context;
    }

  /*  This before Method will setup Android Driver and Launch APP URL
  * to kick off the TEST execution*/
    @Before
    public void setUp() throws MalformedURLException {
        webDriver = testContext.getDriverManager().getDriver();
        webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
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
