package Pages;

import Browser.BrowserСhoice;
import Locators.MainPageLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class MainPage {
    MainPageLocators locators = new MainPageLocators();
    Actions builder = new Actions(BrowserСhoice.getDriver());


    public MainPage(){

        PageFactory.initElements(BrowserСhoice.getDriver(), locators);
        BrowserСhoice.getDriver().manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
    }
    @Step(" Main Page : click on login button ")
    public void clickOnLoginButton(){
        locators.getLoginButton().click();
        BrowserСhoice.getDriver();
    }
    @Step("Main Page : click on wish list")
    public void clickOnWishList(){
        locators.getWishList().click();
    }
    @Step("Main Page : move mouse to catalog bar")
    public void moveMouseToCatalogBar(){
       builder.moveToElement(locators.getCatalog());
    }
    @Step("Main Page : change language ")
    public void changeLanguage(){
        locators.getLanguage().click();}

    @Step("Send product {st} in top search ")
    public void sendProductNameInTopSearch(String st){
        locators.getTopSearch().sendKeys(st);
        locators.getTopSearch().sendKeys(Keys.ENTER);
    }
  @Step("Main Page : get current URL")
  public  String getUrl(){
       return BrowserСhoice.getDriver().getCurrentUrl();
  }
  @Step("Main Page : get  products amount which have been added to the wishlist ")
  public String getNumberFomWishList(){
       return locators.getWishList().getText();
  }
  @Step("Main Page : click on scroll button ")
  public void clickOnScrollButton(){
        locators.getScrollButton().click();
  }

    @Step("go to login page")
    public LoginPage goToLoginPage(){
        clickOnLoginButton();
        return new LoginPage();
    }
     @Step("click on a top search and send product {product}")
    public ProductPage searchProductInTopSearch(String product){
        sendProductNameInTopSearch(product);
        return new ProductPage();
    }
     @Step("move  mouse to a catalog ")
    public ProductPage moveToCatalog(){
        moveMouseToCatalogBar();
        return new ProductPage();
    }

}
