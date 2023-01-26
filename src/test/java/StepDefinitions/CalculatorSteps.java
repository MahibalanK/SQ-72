package StepDefinitions;

import PageObjects.CalculatorPage;
import PageObjects.SpaceProductPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CalculatorSteps {


    TestContext testContext;
    CalculatorPage calculatorPage;


    public CalculatorSteps(TestContext context) throws InterruptedException {
        testContext = context;
        calculatorPage = testContext.getPageObjectManager().getCalculatorPage();
    }

    @Given(": User Launch Android native calculator app in emulator")
    public void user_launch_android_native_calculator_app_in_emulator() {
       System.out.println("Calculator App launched ");
    }
    @Given(": User pass {string} and {string} to be entered in the app")
    public void user_pass_and_to_be_entered_in_the_app(String num1, String num2) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
       calculatorPage.enterNumber(num1, num2);
    }
    @Then(": User press addition operator and verify the result is equal to the {string}")
    public void user_press_addition_operator_and_verify_the_result_is_equal_to_the(String strResult) throws InterruptedException {
        String strAppResult = calculatorPage.verifyResult();
        Assert.assertEquals(strResult, strAppResult);
        System.out.println("Sun of two numbers is "+strAppResult);

    }

}
