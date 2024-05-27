package DataProviders;

import Enums.DriverType;
import Enums.EnvironmentType;
import Enums.Platform;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;

    /*Logic to load property File to get the Global Test Execution Config*/
    public ConfigFileReader() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String propertyFilePath = "config/configuration.properties";

        try {
            fileReader = new FileReader(propertyFilePath);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();

            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    /* Get URL from Config File*/
    public String getUrl() {
        String url = properties.getProperty("url");

        //Simply If...Else
        if (url != null) return url;
        else
            throw new RuntimeException("url not specified in the config file.");
    }

   /* Get timeouts from Config File*/
    public long getTime() {
        String timeout = properties.getProperty("timeout");

        //Common If...Else
        if (timeout != null) {
            return Long.parseLong(timeout);
        } else {
            throw new RuntimeException("timeout not specified in the config file.");
        }
    }

    /*To SET Mobile Device Platform Type*/
    public Platform getDevicePlatform()  {
        String devicePlatform = properties.getProperty("Platform");

        switch (devicePlatform) {
            case "DESKTOP":
                return Platform.DESKTOP;
            case "ANDROID":
                return Platform.ANDROID;
            case "IOS":
                return Platform.IOS;
            default:
                throw new RuntimeException("Device Platform name key value in configuration file is not matched: " + devicePlatform);
        }
    }

    /*To SET Browser Type */
    public DriverType getBrowser()  {
        String browserName = properties.getProperty("browser");

        switch (browserName) {
            case "chrome":
                return DriverType.CHROME;
            case "firefox":
                return DriverType.FIREFOX;
            case "edge":
                return DriverType.EDGE;
            case "safari":
                return DriverType.SAFARI;
            default:
                throw new RuntimeException("Browser name key value in configuration file is not matched: " + browserName);
        }
    }

    /*
    To SET Execution mode for LOCAL and REMOTE execution*/
    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");

        switch (environmentName) {
            case "LOCAL":
                return EnvironmentType.LOCAL;
            case "REMOTE":
                return EnvironmentType.REMOTE;
            default:
                throw new RuntimeException("Environment type key value in configuration file is not matched: " + environmentName);
        }
    }

   /* Get device Name -emulator name */
    public String getDeviceName(){
        return properties.getProperty("DeviceName");
    }

   /* Get OS version of the mobile*/
    public String getOSVersion(){
        return properties.getProperty("OSVersion");
    }

/*Get Apk path for the App Under Test*/
    public String getAPKPath(){
        return properties.getProperty("ApkPath");
    }


    public String getAppPackage(){
        return properties.getProperty("appPackage");
    }
    public String getAppActivity(){
        return properties.getProperty("appActivity");
    }



}
