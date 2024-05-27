package StepDefinitions;

import PageObjects.StarWarsPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;

public class StarWarsSteps {


    TestContext testContext;
    StarWarsPage starWarsPage;


    public StarWarsSteps(TestContext context) throws InterruptedException {
        testContext = context;
        starWarsPage = testContext.getPageObjectManager().getStarWarsPage();
    }

    @Given(": User Launch Chrome browser and load the star wars application")
    public void user_launch_chrome_browser_and_load_the_star_wars_application() {
        System.out.println("Launched browser and loaded app URL");
    }
    @Given(": User sort the movies by {string} and verify the last movie as {string}")
    public void user_sort_the_movies_by_and_verify_the_last_movie_as(String strTitle, String string2) throws InterruptedException {
        String strGetVal = starWarsPage.sortMoviesByColumn(strTitle);
        System.out.println("Got Title from app "+strGetVal);

    }
    @Then(": User clicks the movie {string} and vefify the species has {string}")
    public void user_clicks_the_movie_and_vefify_the_species_has(String strMovie, String string2) {

        starWarsPage.clickSpecificMovieToVerifySpecies(strMovie);
        System.out.println("Im in star wars world");
    }
    @Then(": User verify that {string}, {string} is not part of {string}")
    public void user_verify_that_is_not_part_of(String string, String string2, String string3) {
        System.out.println("Im in star wars world");
    }

}
