package Locators;


import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class MainPageLocators {

    @FindBy(xpath = "//span[@class='ml8 dashed-text']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(@class ,'dn aic jcc favorites')] //div[contains(@class,'df aic jcc pa badge')]")
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



}
