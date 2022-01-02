package Pages;

import Browser.BrowserСhoice;
import Locators.LoginPageLocator;
import UserDao.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage  {

LoginPageLocator loginPageLocator = new LoginPageLocator();

LoginPage(){
    PageFactory.initElements(BrowserСhoice.getDriver(),loginPageLocator);
    BrowserСhoice.getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
}
@Step("Login Page : click on login button")
public void  clickOnLoginButton(){
    loginPageLocator.getLoginByPhone().click();
}
@Step("Login Page : send number - {user.phoneNumber} in login by phone field ")
public void sendDataInNumberField(User user){
    loginPageLocator.getEntryFieldByLoginByPhone().sendKeys(user.getPhone());}

@Step("Login Page : get text about user took succeed message")
public String getTextFromMobileMessageEntrance(){
    return loginPageLocator.getMobileMessageEntrance().getText();
}

@Step("Login Page : send email {user.email} ")
public void sendTextIntoEmailRegisterForm(User dao){
    loginPageLocator.getEntryFieldByLoginByEmail().sendKeys(dao.getEmail());
}
@Step("Login Page : click on the button that moves the user to the form where him can log in via email ")
public void clickOnLoginByEmail(){
    loginPageLocator.getLoginByEmail().click();
}
@Step(" Login Page : send password {user.password}  in password form ")
public void sendPasswordInPasswordField(User user){
    loginPageLocator.getPasswordFormForLogin().sendKeys(user.getPassword());
}
@Step("Login Page : Send cod in phone login verification field")
  public void  sendInFieldForMessageVerification(User user){
      loginPageLocator.getFieldForMessageVerification().sendKeys(user.getPhone());
  }
  @Step("Login Page : get account name text")
  public String getAccountNameText(){
    return loginPageLocator.getAccount().getText();
  }

// Business logics
    @Step("login by phone number {dao.phoneNumber}")
public LoginPage loginByPhoneNumber(User dao){
    sendDataInNumberField(dao);
    clickOnLoginButton();
    sendInFieldForMessageVerification(dao);
    return new LoginPage();
}
@Step("login by email {dao.email}")
public LoginPage loginByEmailNumber(User dao){
    clickOnLoginByEmail();
    sendTextIntoEmailRegisterForm(dao);
    clickOnLoginButton();
    sendPasswordInPasswordField(dao);
    clickOnLoginButton();
    return new LoginPage();

}
@Step("go to register page ")
public  RegisterPage goToRegisterPage(){
    loginPageLocator.getRegisteringButton().click();
    return new RegisterPage();
}




}
