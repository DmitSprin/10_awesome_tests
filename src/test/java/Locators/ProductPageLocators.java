package Locators;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@Getter
@Setter
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

    @FindBy(xpath = "//div[@class='mt32'] //button[contains(@class, 'buyButton-')]")
    WebElement buyButton;

}