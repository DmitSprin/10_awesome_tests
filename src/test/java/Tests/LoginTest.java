package Tests;

import Pages.MainPage;
import Pages.LoginPage;
import UserDao.User;
import UserDao.UserRepo;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
    @Description("this test checks the ability to login using a phone number")
    @Severity(SeverityLevel.CRITICAL)
    public void loginByPhone(User user){
        MainPage basePage = loadApplication();
        LoginPage loginPage = basePage.goToLoginPage().loginByPhoneNumber(user);
        String phone =  loginPage.getTextFromMobileMessageEntrance();
        System.out.println(phone);
        Assert.assertTrue(phone.contains(user.getPhone()));
    }

    @Test(dataProvider = "exist user")
    @Description("this test checks the ability to login using a email")
    @Severity(SeverityLevel.CRITICAL)
    public void loginByEmail(User user){
        MainPage basePage = loadApplication();
        LoginPage loginPage =  basePage.goToLoginPage().loginByEmailNumber(user);
        String name =  loginPage.getAccountNameText();
        Assert.assertEquals(name,user.getName());

    }

}
