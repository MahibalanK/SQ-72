package Managers;

import PageObjects.CalculatorPage;
import PageObjects.SpaceProductPage;
import PageObjects.StarWarsPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectManager {

    private final WebDriver webDriver;
    private SpaceProductPage spaceProductPage;
    private CalculatorPage calculatorPage;

    private StarWarsPage starWarsPage;



  /*  This class will be invoked for page initialization from Test Context Class*/
    public PageObjectManager(WebDriver webDriver) {
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
            //Thread.sleep(3000);
            calculatorPage = new CalculatorPage(webDriver);
        }
        return calculatorPage;
    }

    public StarWarsPage getStarWarsPage() throws InterruptedException {
        if (starWarsPage == null) {
            //Thread.sleep(3000);
            starWarsPage = new StarWarsPage(webDriver);
        }
        return starWarsPage;
    }


}
