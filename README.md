# SQ 72 Assessment

---
## Project Purpose
This project has SQ 72 assessment Solution for mobile automation Tests

## Requirements
* Java Development Kit
* Android Studio for emulators
* Appium desktop
* Maven

## Running Tests
* Clone the repository from your fork to this directory
* Open the project using any Java IDE
* Edit the device(emulator) name, android version, device platform 
in the Configuration.properties file
* Run the tests with the script below
* use the cucumber tags like this
```shell
$ mvn clean install -Dcucumber.filter.tags="@AddProductToCart"
```

## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* See test report from `target/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html`

## Note - 
* This test ran against appium 1.22.2v, android 12v, JDK-1.8