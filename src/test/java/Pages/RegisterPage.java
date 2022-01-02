package Pages;

import Browser.BrowserСhoice;
import Locators.RegisterPageLocator;
import UserDao.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class RegisterPage {
    private RegisterPageLocator registerPageLocator = new RegisterPageLocator();

    RegisterPage(){
        PageFactory.initElements(BrowserСhoice.getDriver(),registerPageLocator);
        BrowserСhoice.getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }
    @Step(" Register Page : send name - {user.userName} in name field  field ")
    public void sendNameInRegisterField(User user){
        registerPageLocator.getRegisterFieldForName().sendKeys(user.getName());
    }
    @Step(" Register Page : send email - {user.email}  in email  field ")
    public void  sendEmailInRegisterField(User user){
        registerPageLocator.getRegisterFieldForEmail().sendKeys(user.getEmail());
    }
    @Step(" Register Page : send password - {user.password}  in password field ")
    public void sendPasswordInRegisterField(User user){
        registerPageLocator.getRegisterFieldForPassword().sendKeys(user.getPassword());
    }
    @Step(" Register Page : send phone number - {user.phoneNumber}  in phone field ")
    public void sendPhoneInRegisterField(User user){
        registerPageLocator.getRegisterFieldForPhone().sendKeys(user.getPhone());
    }
    @Step("Register Page: click on register button")
    public void clickOnRegisterButton(){
        registerPageLocator.getRegisterButton().click();
    }

    //Business logics
     @Step("Register Page : register new user with email - {dao.email}" +
" username - {dao.userName} , phone number - {dao.phoneNumber} , password -{dao.password}  ")
    public RegisterPage registerNewUser(User dao){
        sendEmailInRegisterField(dao);
        sendNameInRegisterField(dao);
        sendPasswordInRegisterField(dao);
        sendPhoneInRegisterField(dao);
        clickOnRegisterButton();
        return  new RegisterPage();
    }

}
