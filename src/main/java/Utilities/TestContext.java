package Utilities;

import Managers.AllDriverManager;
import Managers.PageObjectManager;

import java.net.MalformedURLException;

public class TestContext {

    private final AllDriverManager driverManager;
    private final PageObjectManager pageObjectManager;
    public ScenarioContext scenarioContext;

   /* Constructor -where actual TEST will begin with initialization
   of Drivers to various classes.*/
    public TestContext() throws MalformedURLException {
        driverManager = new AllDriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
        scenarioContext = new ScenarioContext();
    }

    //getters for above class variables
    public AllDriverManager getDriverManager() {
        return driverManager;
    }
    public PageObjectManager getPageObjectManager() {return pageObjectManager;
    }
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
