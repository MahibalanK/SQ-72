package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

        private final WebDriver webDriver;

        //Constructor to initialize page elements
        public CalculatorPage(WebDriver webDriver) {
            this.webDriver = webDriver;
            PageFactory.initElements(this.webDriver, this);
        }

        // Locators
        @FindBy(id = "com.google.android.calculator:id/op_add")
        private WebElement btnAddOperator;
        @FindBy(id = "com.google.android.calculator:id/eq")
        private WebElement btnEqualSign;
         @FindBy(id = "com.google.android.calculator:id/result_final")
         private WebElement lablResult;


         //enter 2 numbers in calculator app and press equal symbol
        public void enterNumber(String strNum1, String strNum2) throws InterruptedException {

            String strXpath_Num1,strXpath_Num2;
            strXpath_Num1 = "com.google.android.calculator:id/digit_"+strNum1;
            strXpath_Num2 = "com.google.android.calculator:id/digit_"+strNum2;

            this.webDriver.findElement(By.id(strXpath_Num1)).click();
            btnAddOperator.click();
            this.webDriver.findElement(By.id(strXpath_Num2)).click();
            btnEqualSign.click();

        }


        //get result of sum of 2 no's
    public String verifyResult() throws InterruptedException {

          String strAppResult;
          strAppResult = lablResult.getText();
          return strAppResult;
    }

    }



