package Pages;

import Browser.BrowserСhoice;
import Locators.LoginPageLocator;
import UserDao.User;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage implements BasePage  {

LoginPageLocator loginPageLocator = new LoginPageLocator();

LoginPage(){
    PageFactory.initElements(BrowserСhoice.getDriver(),loginPageLocator);
    BrowserСhoice.getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
}

public void  clickOnLoginButton(){
    loginPageLocator.getLoginByPhone().click();
}


public void sendDataInNumberField(User user){
    loginPageLocator.getEntryFieldByLoginByPhone().sendKeys(user.getPhoneNumber());}


public String getTextFromMobileMessageEntrance(){
    return loginPageLocator.getMobileMessageEntrance().getText();
}


public void sendTextIntoEmailRegisterForm(User dao){
    loginPageLocator.getEntryFieldByLoginByEmail().sendKeys(dao.getEmail());
}

public void clickOnLoginByEmail(){
    loginPageLocator.getLoginByEmail().click();
}

public void sendPasswordInPasswordField(User user){
    loginPageLocator.getPasswordFormForLogin().sendKeys(user.getPassword());
}

  public void   sendInFieldForMessageVerification(User user){
      loginPageLocator.getFieldForMessageVerification().sendKeys(user.getPhoneNumber());
  }

  public String getAccountNameText(){
    return loginPageLocator.getAccount().getText();
  }

// Business logics
public LoginPage loginByPhoneNumber(User dao){
    sendDataInNumberField(dao);
    clickOnLoginButton();
    sendInFieldForMessageVerification(dao);
    return new LoginPage();
}

public LoginPage loginByEmailNumber(User dao){
    clickOnLoginByEmail();
    sendTextIntoEmailRegisterForm(dao);
    clickOnLoginButton();
    sendPasswordInPasswordField(dao);
    clickOnLoginButton();
    return new LoginPage();

}

public  RegisterPage goToRegisterPage(){
    loginPageLocator.getRegisteringButton().click();
    return new RegisterPage();

}

}
