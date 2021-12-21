package Tests;

import Pages.BasePage;
import Pages.LoginPage;

import UserDao.User;
import UserDao.UserRepo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Tests.TestRunner.loadApplication;

public class LoginTest  {

    @DataProvider(name = "exist user")
    public Object[][] getExistUser() {;
        return new Object[][]{{UserRepo.getExistUser()}
        };
    }




    @Test(dataProvider = "exist user")
    public void loginByPhone(User user){
        BasePage basePage = loadApplication();

        LoginPage loginPage = basePage.goToLoginPage().loginByPhoneNumber(user);
        String phone =  loginPage.getTextFromMobileMessageEntrance();
        System.out.println(phone);
        Assert.assertTrue(phone.contains(user.getPhone()));


    }
    @Test(dataProvider = "exist user")
    public void loginByEmail(User user){

        BasePage basePage = loadApplication();
        LoginPage loginPage =  basePage.goToLoginPage().loginByEmailNumber(user);
        String name =  loginPage.getAccountNameText();
        Assert.assertEquals(name,user.getName());

    }


}
