package Locators;

import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePageLocators {

    @FindBy(xpath = "//span[@class='ml8 dashed-text']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(@class ,'dn aic jcc favorites')]")
    private WebElement wishList;

    @FindBy(xpath = "//div[@class='menu--desktop__title']")
    private WebElement catalog;

    @FindBy(xpath = "//div[contains(@class,'dib df basket')]")
    private WebElement basket;

    @FindBy(xpath = "//div[contains(@class,'scrollButton')]")
    private WebElement scrollButton;

    @FindBy(xpath = " //a[@href='/uk/']")
    private WebElement Language;

    @FindBy(xpath = "//input[@type='text'] ")
    private WebElement topSearch;

    @FindBy(xpath = "//a[contains(@class,'dn aic jcc favorites')] //div[@class='pr']")
    private  WebElement wishCount;

    public WebElement getScrollButton() {return scrollButton;}

    public WebElement getLanguage() {return Language;}

    public WebElement getTopSearch() {return topSearch;}

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWishList() {
        return wishList;
    }

    public WebElement getCatalog() {
        return catalog;
    }

    public WebElement getBasket() {
        return basket;
    }

    public WebElement getWishCount() {return wishCount;}






}
