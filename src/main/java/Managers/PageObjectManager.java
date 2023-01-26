package Managers;

import PageObjects.CalculatorPage;
import PageObjects.SpaceProductPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

public class PageObjectManager {

    private final AppiumDriver<WebElement> webDriver;
    private SpaceProductPage spaceProductPage;
    private CalculatorPage calculatorPage;


  /*  This class will be invoked for page initialization from Test Context Class*/
    public PageObjectManager(AppiumDriver<WebElement> webDriver) {
        this.webDriver = webDriver;
    }

    public SpaceProductPage getLoginPage() {
        if (spaceProductPage == null) {
            spaceProductPage = new SpaceProductPage(webDriver);
        }
        return spaceProductPage;
    }

    public CalculatorPage getCalculatorPage() throws InterruptedException {
        if (calculatorPage == null) {
            Thread.sleep(3000);
            calculatorPage = new CalculatorPage(webDriver);
        }
        return calculatorPage;
    }

}
