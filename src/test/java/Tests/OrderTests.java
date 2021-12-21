package Tests;

import Pages.BasePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.RegisterPage;
import UserDao.User;
import UserDao.UserRepo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static Tests.TestRunner.loadApplication;

public class OrderTests {

    @DataProvider(name = "products name")
    public Object[][] productsName() {
        return new Object[][]{{"Смартфоны", "Apple","iPhone"}};
    }

    @Test(dataProvider = "products name")
    public void searchWithCatalog(String cat, String subCat, String prod){

        BasePage basePage = loadApplication();
        ProductPage productPage = basePage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat,subCat);
        productPage.clickOmFirstProduct();
        productPage.clickOnBuyButton();
        String productName =  productPage.orderConfirmText();
        Assert.assertTrue(productName.contains(prod));

 }


    @DataProvider(name = "new user")
    public Object[][] getNewUser() {;
        return new Object[][]{{UserRepo.createNewUser()}
        };
    }

    @Test(dataProvider = "new user")
    public void addProductToWishList(User user) {
        BasePage basePage = loadApplication();

        LoginPage loginPage = basePage.goToLoginPage();
        RegisterPage registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        ProductPage productPage = basePage.moveToCatalog();
        productPage.choiceСategory("Смартфоны");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productPage.moveToSubMenu("Apple");
        productPage.clickOmFirstProduct();
        productPage.clickOnBuyButton();



    }


}
