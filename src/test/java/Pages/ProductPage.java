package Pages;

import Browser.BrowserСhoice;
import Locators.ProductPageLocators;
import Utils.ExplicitStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public void clickOmFirstProduct(){
        builder.moveToElement(productPageLocators.getFirstProductOnPage()).build().perform();
        productPageLocators.getFirstProductOnPage().click();
    }

    public void clickOnBuyButton()  {
        strategy.waitForElement(productPageLocators.getBuyButton());
        BrowserСhoice.getDriver().navigate().refresh();
        productPageLocators.getBuyButton().click();
    }

    public String  orderConfirmText(){
       return productPageLocators.getOrderConfirm().getText();
    }

    public List<String> findAllProducts() {
        strategy.waitForElements(productPageLocators.getProducts());
        return productPageLocators.getProducts().stream().map(WebElement::getText).toList();
    }

    public void addToWishListButton(){
        productPageLocators.getAddToWishList().click();
    }

public void moveToSubMenu(String subProd){
        List<WebElement> subCategories = productPageLocators.getSubCategories();
       List<WebElement> subCategoriesSorted =
               subCategories.stream().filter(x->x.getText().contains(subProd)).toList();
          subCategoriesSorted.stream().findFirst().get().click();

    }

    public void choiceСategory(String cat) {
        List<WebElement> allCategories =  productPageLocators.getCategories();
        allCategories.stream().filter(x->x.getText().contains(cat))
                .forEach(x->builder.moveToElement(x).build().perform());
    }

    public void choiceСategoryAndSubCategory(String cat,String sub) {
        List<WebElement> allCategories =  productPageLocators.getCategories();
         allCategories.stream().filter(x->x.getText().contains(cat))
                .forEach(x->builder.moveToElement(x).build().perform());
        moveToSubMenu(sub);

    }
}
