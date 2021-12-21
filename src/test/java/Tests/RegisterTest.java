package Tests;

import Pages.BasePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import UserDao.User;
import UserDao.UserRepo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Tests.TestRunner.loadApplication;

public class RegisterTest {


    @DataProvider(name = "new user")
    public Object[][] getNewUser() {;
        return new Object[][]{{UserRepo.createNewUser()}
        };
    }

    @Test(dataProvider = "new user")
    public void createNewUser(User user) {
        BasePage basePage = loadApplication();

        LoginPage loginPage = basePage.goToLoginPage();
        RegisterPage registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
       String name =  loginPage.getAccountNameText();
        Assert.assertEquals(name,user.getName());
    }




    @DataProvider(name = "exist user")
    public Object[][] getExistUser() {;
        return new Object[][]{{UserRepo.getExistUser()}
        };
    }

    //Negative test
    @Test(dataProvider = "exist user")
    public void createNewUserWithWrongCredential(User user){
        BasePage basePage = loadApplication();

        LoginPage loginPage = basePage.goToLoginPage();
        RegisterPage registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        String name =  loginPage.getAccountNameText();
        Assert.assertEquals(name,user.getName());

    }


}
