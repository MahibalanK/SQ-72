package PageObjects;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class StarWarsPage {

    private final WebDriver webDriver;

    //Constructor to initialize page elements
    public StarWarsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    // Locators
    @FindBy(xpath = "//table[contains(@class,'text')]")
    private WebElement movieTable;
    @FindBy(xpath = "//th[contains(text(),'Title')]")
    private WebElement titleCol;
    @FindBy(xpath = "//tbody//following::tr[5]//a[1]")
    private WebElement lastMovie;

    @FindBy(xpath = "//tbody//following::td//a")
    private List<WebElement> allMovies;


    //enter 2 numbers in calculator app and press equal symbol
    public String sortMoviesByColumn(String strColumn) throws InterruptedException {
        Wait.untilAjaxCallIsDone(this.webDriver,40L);
        Wait.untilPageReadyState(this.webDriver,30L);
        Wait.untilElementIsVisible(this.webDriver,movieTable,70L);
        Wait.untilElementIsVisible(this.webDriver,titleCol,70L);
        titleCol.click();
        Wait.untilElementIsVisible(this.webDriver,lastMovie,70L);
        String strLastMovie = lastMovie.getText();
       return strLastMovie;

    }

    public void clickSpecificMovieToVerifySpecies(String strExpectedMovie){
        Wait.untilAjaxCallIsDone(this.webDriver,40L);
        Wait.untilPageReadyState(this.webDriver,30L);
        String strMovieName;
        int intSize = allMovies.size();
        for(int i=0;i<intSize; i++){
            strMovieName= allMovies.get(i).getText();
            if(strMovieName.equals(strExpectedMovie)){
                allMovies.get(i).click();
            }
        }
    }

}
