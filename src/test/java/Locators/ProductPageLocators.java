package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductPageLocators {

    @FindBy(xpath = "//div[contains(@class,'md-description')] //h5")
    List<WebElement> products;

    @FindBy(xpath = "//div[contains(@class,'border-box pr productCardCategory')]")
    WebElement firstProductOnPage;

    @FindBy(xpath = "//a[@class='df aic jcsb'] //div")
    List<WebElement> categories;

    @FindBy(xpath = "//*[contains(@class ,'icon add-favorire icon')]")
    WebElement addToWishList;

    @FindBy(xpath = "//a[contains(@class,'submenu')]")
    List<WebElement> subCategories;

    @FindBy(xpath = "//div[contains(@class,'grid')] //div[contains(@class,'content')]")
    WebElement orderConfirm;

    @FindBy(xpath = "//button[contains(@class,'uppercase medium df buyButton')]")
    WebElement buyButton;

    public List<WebElement>  getProducts() {return products;}

    public List<WebElement> getSubCategories() {return subCategories;}

    public List<WebElement> getCategories() {return categories;}

    public WebElement getFirstProductOnPage() {return firstProductOnPage;}

    public WebElement getBuyButton() {return buyButton;}

    public WebElement getOrderConfirm() {return orderConfirm;}

    public WebElement getAddToWishList() {return addToWishList;}
}