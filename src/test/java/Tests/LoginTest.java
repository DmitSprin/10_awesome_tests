package Tests;

import Pages.MainPage;
import Pages.LoginPage;
import UserDao.User;
import UserDao.UserRepo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginTest  extends TestRunner {

    @DataProvider(name = "exist user")
    public Object[][] getExistUser() {;
        return new Object[][]{{UserRepo.getExistUser()}
        };
    }

    @Test(dataProvider = "exist user")
    public void loginByPhone(User user){
        MainPage mainPage = loadApplication();
        LoginPage loginPage = mainPage.goToLoginPage().loginByPhoneNumber(user);
        String phone =  loginPage.getTextFromMobileMessageEntrance();
        System.out.println(phone);
        Assert.assertTrue(phone.contains(user.getPhoneNumber()));
    }

    @Test(dataProvider = "exist user")
    public void loginByEmail(User user){
        MainPage mainPage = loadApplication();
        LoginPage loginPage =  mainPage.goToLoginPage().loginByEmailNumber(user);
        String name =  loginPage.getAccountNameText();
        Assert.assertEquals(name,user.getUserName());

    }

}