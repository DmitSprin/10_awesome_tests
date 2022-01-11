package Pages;

import Browser.BrowserСhoice;
import Locators.MainPageLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class MainPage implements BasePage{
    MainPageLocators locators = new MainPageLocators();
    Actions builder = new Actions(BrowserСhoice.getDriver());


    public MainPage(){

        PageFactory.initElements(BrowserСhoice.getDriver(), locators);
        BrowserСhoice.getDriver().manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
    }

    public void clickOnLoginButton(){
        locators.getLoginButton().click();
    }

    public void clickOnWishList(){
        locators.getWishList().click();
    }

    public void moveMouseToCatalogBar(){
       builder.moveToElement(locators.getCatalog());
    }

     public void changeLanguage(){
        locators.getLanguage().click();}

     public void sendProductNameInTopSearch(String st){
        locators.getTopSearch().sendKeys(st);
        locators.getTopSearch().sendKeys(Keys.ENTER);
    }

  public String getNumberFomWishList(){
       return locators.getWishList().getText();
  }

  public void clickOnScrollButton(){
        locators.getScrollButton().click();
  }
  public Point getPoint(){
       WebElement el =  locators.getBasket();
       return getElementPoint(el);
  }

    public MainPage click(){
        locators.getBasket().click();
        return new MainPage();
    }

    public LoginPage goToLoginPage(){
        clickOnLoginButton();
        return new LoginPage();
    }

    public ProductPage searchProductInTopSearch(String product){
        sendProductNameInTopSearch(product);
        return new ProductPage();
    }

    public ProductPage moveToCatalog(){
        moveMouseToCatalogBar();
        return new ProductPage();
    }

}
