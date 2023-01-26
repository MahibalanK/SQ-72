package PageObjects;

import Utilities.Wait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpaceProductPage {

    private final AppiumDriver<WebElement> webDriver;

    //Constructor to initialize page elements
    public SpaceProductPage(AppiumDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    // Locators
    @FindBy(xpath = "//h1[contains(text(),'Shop SpaceX')]")
    private WebElement lblShopSpaceX;
    @FindBy(xpath = "(//button[@aria-controls='Search'])[2]")
    private WebElement btnSearch;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement txtSearchBox;
    @FindBy(xpath = "//a[text()='View all']")
    private WebElement lnkViewAll;
    @FindAll(@FindBy(xpath = "//li//span[@class='ProductItem__Title Heading']//child::a"))
    private List<WebElement> lblProductName;
    @FindAll(@FindBy(xpath = "//span[@class='money pre-money']"))
    private List<WebElement> lblProductPrice;
    @FindBy(xpath = "//h1[contains(@class,'Title')]")
    private WebElement lblIndividualPdtName;
    @FindBy(xpath = "//span[contains(@class,'money cash')]")
    private WebElement lblIndividualPdtPrice;
    @FindBy(xpath = "(//div[contains(@class,'Quantity')])[2]/span[2]")
    //span 1 decrease span 2 increase
    private WebElement btnProductQuantity;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnAddCart;


    /*PAGE ACTIONS
    verify the landing page Image displayed or not*/
    public boolean verifyLandingPageText(){
        Wait.untilElementIsVisible((AppiumDriver) this.webDriver,lblShopSpaceX, 30L);
        if(lblShopSpaceX.isDisplayed()){
            return true;
        }
            return false;
    }

   /* Search the product in search box and go to view all page*/
    public void searchProductinLandingPage(String productname){

        Wait.untilElementIsVisible((AppiumDriver) this.webDriver,btnSearch, 30L);
        btnSearch.click();
        txtSearchBox.sendKeys(productname);
        Wait.untilElementIsVisible((AppiumDriver) this.webDriver,lnkViewAll, 30L);
        lnkViewAll.click();

    }

    /*Fetch the product name and price and print in console*/
    public void printProductNameAndPrice() throws InterruptedException {

        String strProductName, strProductPrice;
        int intProductSize, intPriceSize;

       /* Used thread (due to time constraint !! )- As initially tried with document,getreadystate()
        and wait on ajax call to finish but it doesnt help in this case */
        Thread.sleep(2000);

        //get total product element size
        Wait.untilElementIsVisible((AppiumDriver) this.webDriver, lblProductName.get(0), 60L);
        intProductSize = lblProductName.size();
        System.out.println("Total products "+intProductSize);

        //get total product price size
        intPriceSize = lblProductPrice.size();
        System.out.println("Total prices "+intPriceSize);

        for (int i = 0; i < intProductSize ; i++) {
            strProductName = lblProductName.get(i).getText();
            strProductPrice = lblProductPrice.get(i).getText();
           System.out.println("product name "+strProductName+ " and price is "+strProductPrice);

        }

    }

    /*Function to add products and verify the final amount dynamically from user*/
    public void AddCartWithVaryingQuantity(String strproductname, String strQunatity) throws InterruptedException {

        String strProductName, strProductPrice = null, strAppCalculatedPrice;
        int intProductSize;

          /* Used thread (due to time constraint !! )- As initially tried with document,getreadystate()
        and wait on ajax call to finish but it doesnt help in this case */
        Thread.sleep(2000);
        //get total product size
        Wait.untilElementIsVisible((AppiumDriver) this.webDriver, lblProductName.get(0), 60L);
        intProductSize = lblProductName.size();

        // iterate each product and find the matched one and click
        for ( int product = 0; product < intProductSize ; product++ ) {
            strProductName = lblProductName.get(product).getText();

            if( strProductName.equalsIgnoreCase(strproductname) ){
                strProductPrice = lblProductPrice.get(product).getText();
                lblProductName.get(product).click();
                System.out.println("Product clicked "+strProductName);
                System.out.println("single quantity price  "+strProductPrice);
                break;
            }

        }

        Wait.untilElementIsVisible( this.webDriver,lblIndividualPdtName,60L );
        Wait.untilElementIsVisible( this.webDriver,btnProductQuantity,60L );

        // Increase quantity of products dynamically
        for (int i = 0; i < Integer.valueOf( strQunatity ) ; i++) {
             btnProductQuantity.click();
        }

        //click add to cart button
        btnAddCart.click();
        Wait.untilElementIsVisible( this.webDriver,lblProductPrice.get(0),60L );
        strAppCalculatedPrice = lblProductPrice.get(0).getText();

       /* get quantity selected and do calculation to
         verify against App calculated amount*/
        int intquantity = Integer.valueOf( strQunatity );
        double dblCalculatedPriceAmount = getPriceForAddedQunatity( intquantity,strProductPrice );

        System.out.println("Code calculated price amount " +dblCalculatedPriceAmount);
        System.out.println("App calculated price amount " +strAppCalculatedPrice);

    }

    /*pre calculate the price amount depends on quantity and single price value*/
    public double getPriceForAddedQunatity(int intQunatity,String strPrice){

        String[] arrSplitActualPrice = strPrice.split("[!@#$]");
        double dblCalculatedPrice = Double.valueOf( arrSplitActualPrice[1] );
        dblCalculatedPrice = dblCalculatedPrice * ( intQunatity+1 );
        return dblCalculatedPrice ;
    }



}

