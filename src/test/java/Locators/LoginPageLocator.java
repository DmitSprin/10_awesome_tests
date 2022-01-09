package Locators;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Setter
@Getter
public class LoginPageLocator extends MainPageLocators {

    @FindBy(xpath = "//input[@name='phone']")
    WebElement entryFieldByLoginByPhone;

    @FindBy(xpath = "//span[contains(@class, 'dashed-text autorizeName')]")
    WebElement account;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordFormForLogin;

    @FindBy(xpath = "//div[@class='full-height df fdc jcc'] //p")
    WebElement mobileMessageEntrance;

    @FindBy(xpath = "//input[@name ='code']")
    WebElement fieldForMessageVerification;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginByPhone;

    @FindBy(xpath = "//div[@class='full-height df fdc jcc']//button[@type='button']")
    WebElement loginByEmail;

    @FindBy(xpath = "//input[@name='email']")
    WebElement entryFieldByLoginByEmail;

    @FindBy(xpath = "//div[@class='full-height df fdc jcc'] //a[@class='link']")
    WebElement registeringButton;
}


