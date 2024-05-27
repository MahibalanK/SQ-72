package StepDefinitions;

import PageObjects.CalculatorPage;
import PageObjects.StarWarsPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class StarWars {


    TestContext testContext;
    StarWarsPage starWarsPage;


    public StarWars(TestContext context) throws InterruptedException {
        testContext = context;
        starWarsPage = testContext.getPageObjectManager().();
    }

    @Given(": User Launch Chrome browser and load the star wars application")
    public void user_launch_chrome_browser_and_load_the_star_wars_application() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given(": User sort the movies by {string} and verify the last movie as {string}")
    public void user_sort_the_movies_by_and_verify_the_last_movie_as(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then(": User clicks the movie {string} and vefify the species has {string}")
    public void user_clicks_the_movie_and_vefify_the_species_has(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then(": User verify that {string}, {string} is not part of {string}")
    public void user_verify_that_is_not_part_of(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
