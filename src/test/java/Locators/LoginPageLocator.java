package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocator extends BasePageLocators {

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

    public WebElement getEntryFieldByLoginByPhone() {
        return entryFieldByLoginByPhone;
    }

    public WebElement getLoginByPhone() {
        return loginByPhone;
    }

    public WebElement getLoginByEmail() {
        return loginByEmail;
    }

    public WebElement getRegisteringButton() {
        return registeringButton;
    }

    public WebElement getMobileMessageEntrance() {return mobileMessageEntrance;}

    public WebElement getEntryFieldByLoginByEmail() {return entryFieldByLoginByEmail;}

    public WebElement getPasswordFormForLogin() {return passwordFormForLogin;}

    public WebElement getFieldForMessageVerification() {return fieldForMessageVerification;}

    public WebElement getAccount() {return account;}



}
