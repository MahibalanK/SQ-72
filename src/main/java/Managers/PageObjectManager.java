package Managers;

import PageObjects.SpaceProductPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectManager {

    private final AppiumDriver<MobileElement> webDriver;
    private SpaceProductPage spaceProductPage;

  /*  This class will be invoked for page initialization from Test Context Class*/
    public PageObjectManager(AppiumDriver<MobileElement> webDriver) {
        this.webDriver = webDriver;
    }

    public SpaceProductPage getLoginPage() {
        if (spaceProductPage == null) {
            spaceProductPage = new SpaceProductPage(webDriver);
        }
        return spaceProductPage;
    }

}
