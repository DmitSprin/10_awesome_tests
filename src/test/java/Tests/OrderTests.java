package Tests;

import Browser.BrowserСhoice;
import Pages.BasePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.RegisterPage;
import UserDao.User;
import UserDao.UserRepo;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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

    //  unstable test
    @Test(dataProvider = "new user")
    public void addProductToWishList(User user) throws InterruptedException {
        BasePage basePage = loadApplication();

        ProductPage productPage = basePage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory("Смартфоны","Apple");;
        productPage.clickOmFirstProduct();
        LoginPage loginPage = basePage.goToLoginPage();
        RegisterPage registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        productPage.addToWishListButton();
     String numberOfProducts =  basePage.getNumberFomWishList();

     Assert.assertEquals(numberOfProducts,"1");

    }
    @AfterTest(alwaysRun = true )
    public void tearDown(){
        BrowserСhoice.closeBrowser();

    }
}
