package Pages;

import Browser.BrowserСhoice;
import Locators.ProductPageLocators;
import Utils.ExplicitStrategy;;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ProductPage {

    ProductPageLocators productPageLocators = new ProductPageLocators();
    Actions builder = new Actions(BrowserСhoice.getDriver());
    ExplicitStrategy strategy = new ExplicitStrategy();

    public ProductPage() {
        PageFactory.initElements(BrowserСhoice.getDriver(), productPageLocators);
        BrowserСhoice.getDriver().manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);

    }
    public String getNameFromFirstProduct(){
       return productPageLocators.getFirstProductOnPage().getText();
    }
    @Step("Product Page :  click on first product from product page ")
    public void clickOmFirstProduct(){
        builder.moveToElement(productPageLocators.getFirstProductOnPage()).build().perform();
        productPageLocators.getFirstProductOnPage().click();
    }
    @Step("Product Page :  click on buy button")
    public void clickOnBuyButton()  {
        strategy.waitForElement(productPageLocators.getBuyButton());
        BrowserСhoice.getDriver().navigate().refresh();
        productPageLocators.getBuyButton().click();
    }
    @Step("Product Page : get text with confirm order ")
    public String  orderConfirmText(){
       return productPageLocators.getOrderConfirm().getText();
    }
     @Step("Product Page : get list all products from product page ")
    public List<String> findAllProducts() {
        strategy.waitForElements(productPageLocators.getProducts());
        return productPageLocators.getProducts().stream().map(WebElement::getText).collect(Collectors.toList());
    }
    @Step("Product Page : click on wishlist  button ")
    public void addToWishListButton(){
        productPageLocators.getAddToWishList().click();
    }
    @Step("Product Page :  move mouse to sub product - {0}")
    public void moveToSubMenu(String subProd){
        List<WebElement> subCategories = productPageLocators.getSubCategories();
        List<WebElement> subCategoriesSorted =
        subCategories.stream().filter(x->x.getText().contains(subProd)).collect(Collectors.toList());
        subCategoriesSorted.stream().findFirst().get().click();

    }
    @Step("Product Page : choose category {0} of catalog")
    public void choiceСategory(String cat) {
        List<WebElement> allCategories =  productPageLocators.getCategories();
        allCategories.stream().filter(x->x.getText().contains(cat))
                .forEach(x->builder.moveToElement(x).build().perform());
    }
    @Step("Product Page :choose category {0} and sub category {1} of catalog")
    public void choiceСategoryAndSubCategory(String cat,String sub) {
         List<WebElement> allCategories =  productPageLocators.getCategories();
         allCategories.stream().filter(x->x.getText().contains(cat))
                .forEach(x->builder.moveToElement(x).build().perform());
         moveToSubMenu(sub);

    }
}
