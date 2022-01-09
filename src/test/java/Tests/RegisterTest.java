package Tests;


import Pages.MainPage;
import Pages.LoginPage;
import Pages.RegisterPage;
import UserDao.User;
import UserDao.UserRepo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class RegisterTest extends TestRunner {

    @DataProvider(name = "new user")
    public Object[][] getNewUser() {;
        return new Object[][]{{UserRepo.createNewUser()}
        };
    }

    @Test(dataProvider = "new user")
    public void createNewUser(User user) {
        MainPage mainPage = loadApplication();
        LoginPage loginPage = mainPage.goToLoginPage();
        RegisterPage registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        String name =  loginPage.getAccountNameText();
        Assert.assertEquals(name,user.getUserName());
    }

    @DataProvider(name = "exist user")
    public Object[][] getExistUser() {;
        return new Object[][]{{UserRepo.getExistUser()}
        };
    }

    //Negative test
    @Test(dataProvider = "exist user")
    public void createNewUserWithWrongCredential(User user){
        MainPage mainPage = loadApplication();
        LoginPage loginPage = mainPage.goToLoginPage();
        RegisterPage registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        String name =  loginPage.getAccountNameText();
        Assert.assertNotEquals(name,user.getUserName());

    }

}
