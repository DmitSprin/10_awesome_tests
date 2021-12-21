package Pages;

import Browser.BrowserСhoice;
import Locators.BasePageLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class BasePage {
    BasePageLocators locators = new BasePageLocators();
    Actions builder = new Actions(BrowserСhoice.getDriver());




    public BasePage(){

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

   public void changeLanguage(){locators.getLanguage().click();}


    public void sendProductNameInTopSearch(String st){

        locators.getTopSearch().sendKeys(st);
        locators.getTopSearch().sendKeys(Keys.ENTER);
    }


  public  String getUrl(){
       return BrowserСhoice.getDriver().getCurrentUrl();
  }

  public String getNumberFomWishList(){
       return locators.getWishList().getText();
  }


  public void clickOnScrollButton(){
        locators.getScrollButton().click();
  }


    public BasePage click(){

        locators.getBasket().click();
        return new BasePage();
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
