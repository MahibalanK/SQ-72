package Managers;

import Enums.DriverType;
import Enums.EnvironmentType;
import Enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static Enums.DriverType.CHROME;

public class AllDriverManager {

   // Class To Initiate APPIUM Driver for Mobile TEST
   private static WebDriver webDriver;

    private static ChromeDriver webChromeDriver;

    private static DriverType browserType;
    private static EnvironmentType environmentType;
    private static Platform devicePlatform;
    private static String deviceName;
    private static String oSVersion;
    private static String apkAppPath;

    private static String appPackage;
    private static String appActivity;


    public AllDriverManager() {
        devicePlatform = FileReaderManager.getInstance().getConfigFileReader().getDevicePlatform();
        deviceName = FileReaderManager.getInstance().getConfigFileReader().getDeviceName();
        oSVersion =  FileReaderManager.getInstance().getConfigFileReader().getOSVersion();
        browserType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
        apkAppPath = FileReaderManager.getInstance().getConfigFileReader().getAPKPath();
        appPackage = FileReaderManager.getInstance().getConfigFileReader().getAppPackage();
        appActivity = FileReaderManager.getInstance().getConfigFileReader().getAppActivity();

    }


    /*Driver setup for LOCAL execution*/
    private WebDriver createLocalDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        switch (devicePlatform) {
            case DESKTOP:
                System.setProperty("webdriver.chrome.driver", "C://Driver//chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("incognito");
                options.addArguments("start-maximized");
                webDriver = new ChromeDriver(options);
                break;
            case ANDROID:
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, oSVersion);
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, devicePlatform);
                if(appPackage.equalsIgnoreCase("nc")){
                    cap.setCapability(MobileCapabilityType.BROWSER_NAME, browserType);
                    cap.setCapability(MobileCapabilityType.APP,apkAppPath);

                }
                else{
                    cap.setCapability("appPackage", appPackage);
                    cap.setCapability("appActivity", appActivity);
                }

                webDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
                System.out.println("android driver set up done");
                break;
            case IOS:
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, oSVersion);
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, devicePlatform);
                cap.setCapability(MobileCapabilityType.BROWSER_NAME, browserType);
                cap.setCapability(MobileCapabilityType.APP,apkAppPath);
                webDriver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
                break;

        }
        long time = FileReaderManager.getInstance().getConfigFileReader().getTime();

        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        //webDriver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        //webDriver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
        return webDriver;
    }


/*Driver setup for CLOUD execution*/
    private AppiumDriver<WebElement> createRemoteDriver() {
        throw new RuntimeException("Remote web driver is not yet implemented");
    }

    /*Parent function to set driver depends on Environment Type -local or remote*/
    private WebDriver createDriver() throws MalformedURLException {
        switch (environmentType) {
            case LOCAL:
                webDriver = createLocalDriver();
                break;
            case REMOTE:
                webDriver = createRemoteDriver();
                break;
        }
        return webDriver;
    }

//    private WebDriver createWebDriver() throws MalformedURLException {
//        switch (environmentType) {
//            case LOCAL:
//                webDriver = createLocalDriver();
//                break;
//            case REMOTE:
//                webDriver = createRemoteDriver();
//                break;
//        }
//        return webDriver;
//    }




    /*Getter method */
    public WebDriver getDriver() throws MalformedURLException {
        if (webDriver == null) webDriver = createDriver();
        return webDriver;
    }



    /*Closing driver instance */
    public void closeDriver() {
       // webDriver.closeApp();
        webDriver.close();
        webDriver.quit();
    }
}
