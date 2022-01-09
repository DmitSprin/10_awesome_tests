package Pages;

import Browser.BrowserСhoice;
import Locators.RegisterPageLocator;
import UserDao.User;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class RegisterPage implements  BasePage {
    private RegisterPageLocator registerPageLocator = new RegisterPageLocator();

    RegisterPage(){
        PageFactory.initElements(BrowserСhoice.getDriver(),registerPageLocator);
        BrowserСhoice.getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }

    public void sendNameInRegisterField(User user){
        registerPageLocator.getRegisterFieldForName().sendKeys(user.getUserName());
    }

    public void  sendEmailInRegisterField(User user){
        registerPageLocator.getRegisterFieldForEmail().sendKeys(user.getEmail());
    }

    public void sendPasswordInRegisterField(User user){
        registerPageLocator.getRegisterFieldForPassword().sendKeys(user.getPassword());
    }

    public void sendPhoneInRegisterField(User user){
        registerPageLocator.getRegisterFieldForPhone().sendKeys(user.getPhoneNumber());
    }

    public void clickOnRegisterButton(){
        registerPageLocator.getRegisterButton().click();
    }

    //Business logics

    public RegisterPage registerNewUser(User dao){
        sendEmailInRegisterField(dao);
        sendNameInRegisterField(dao);
        sendPasswordInRegisterField(dao);
        sendPhoneInRegisterField(dao);
        clickOnRegisterButton();
        return  new RegisterPage();
    }

}
