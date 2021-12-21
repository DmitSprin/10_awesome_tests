package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageLocator {




    @FindBy(xpath = "//input[@name = 'name']")
    WebElement registerFieldForName;

    @FindBy(xpath = "//input[@name = 'phone']")
    WebElement registerFieldForPhone;

    @FindBy(xpath = "//input[@name = 'email']")
    WebElement registerFieldForEmail;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement  registerFieldForPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement registerButton;


    public WebElement getRegisterFieldForName() {return registerFieldForName;}

    public WebElement getRegisterFieldForPhone() {return registerFieldForPhone;}

    public WebElement getRegisterFieldForEmail() {return registerFieldForEmail;}

    public WebElement getRegisterFieldForPassword() {return registerFieldForPassword;}

    public WebElement getRegisterButton() {return registerButton;}
}
