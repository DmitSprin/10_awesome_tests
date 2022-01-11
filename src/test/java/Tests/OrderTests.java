package Tests;


import Pages.MainPage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.RegisterPage;
import UserDao.User;
import UserDao.UserRepo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class OrderTests extends  TestRunner {

    @DataProvider(name = "products name")
    public Object[][] productsName() {
        return new Object[][]{{"Смартфоны", "Apple","iPhone"}};
    }

    @Test(dataProvider = "products name")
    public void searchWithCatalog(String cat, String subCat, String prod)  {
        MainPage basePage = loadApplication();
        ProductPage productPage = basePage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat,subCat);
        productPage.clickOnFirstProduct();
        productPage.clickOnBuyButton();
        String productName = productPage.orderConfirmText();
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
        MainPage basePage = loadApplication();
        ProductPage productPage = basePage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory("Смартфоны","Apple");;
        productPage.clickOnFirstProduct();
        Thread.sleep(1000);
        LoginPage loginPage = basePage.goToLoginPage();
        RegisterPage registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        Thread.sleep(3000);
        productPage.addToWishListButton();
        String numberOfProducts =  basePage.getNumberFomWishList();
        Assert.assertEquals(numberOfProducts,"1");
    }
}
