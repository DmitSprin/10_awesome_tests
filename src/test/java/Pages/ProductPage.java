package Pages;

import Browser.BrowserСhoice;
import Locators.ProductPageLocators;
import Utils.ExplicitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
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

        List<String> products = new ArrayList<>();

        strategy.waitForElements(productPageLocators.getProducts());

        for (int i = 0; i < productPageLocators.getProducts().size(); i++) {

            products.add(productPageLocators.getProducts().get(i).getText());
        }

        return products;

    }
public void moveToSubMenu(String subProd){


    for(int i = 0; i < productPageLocators.getSubCategories().size(); i++){
        if(productPageLocators.getSubCategories().get(i).getText().contains(subProd)){
            productPageLocators.getSubCategories().get(i).click();
          break;
        }

    }


}

    public void    choiceСategory(String cat) {
        for (int i = 0; i < productPageLocators.getCategories().size(); i++) {
            if (productPageLocators.getCategories().get(i).getText().contains(cat)) {

                builder.moveToElement(productPageLocators.getCategories().get(i)).build().perform();



            }



        }


    }
    public void    choiceСategoryAndSubCategory(String cat,String sub) {
        for (int i = 0; i < productPageLocators.getCategories().size(); i++) {
            if (productPageLocators.getCategories().get(i).getText().contains(cat)) {

                builder.moveToElement(productPageLocators.getCategories().get(i)).build().perform();

            }




        }
        moveToSubMenu(sub);


    }
}
