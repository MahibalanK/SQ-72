package StepDefinitions;

import PageObjects.SpaceProductPage;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {

    TestContext testContext;
    SpaceProductPage spaceProductPage;

    public LoginSteps(TestContext context) {
        testContext = context;
        spaceProductPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given(": User Launch Android native browser with spaceX home page")
    public void launch_browser_with_space_x_home_page() {
        System.out.println("launched url already in Hooks setup");
    }
    @And(": User Verify the landing page has {string} image")
    public void verify_the_landing_page_has_image(String string) {
        Assert.assertTrue(spaceProductPage.verifyLandingPageText());
    }
    @Then(": User Search the product {string} in landing screen")
    public void search_the_product_in_landing_screen(String searchproduct) {
        spaceProductPage.searchProductinLandingPage(searchproduct);
    }

    @Then(": User Fetch the {string} and {string} in the searched page")
    public void fetch_the_and_in_the_searched_page(String string, String string2) throws InterruptedException {
       spaceProductPage.printProductNameAndPrice();
    }

    @Then(": User add the product {string} with {string} to verify the amount displayed in the app")
    public void user_add_the_product_with(String produtname, String quantity) throws InterruptedException {
        spaceProductPage.AddCartWithVaryingQuantity(produtname,quantity);
    }


}
