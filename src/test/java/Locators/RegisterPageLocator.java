package Locators;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class RegisterPageLocator {

    @FindBy(xpath = "//input[@name = 'name']")
    WebElement registerFieldForName;

    @FindBy(xpath = "//input[@name = 'phone']")
    WebElement registerFieldForPhone;

    @FindBy(xpath = "//input[@name = 'email']")
    WebElement registerFieldForEmail;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement  registerFieldForPassword;

    @FindBy(xpath = "//div[@class='full-height df fdc jcc'] //button[@type='submit']")
    WebElement registerButton;

}
