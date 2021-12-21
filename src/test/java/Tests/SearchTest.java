package Tests;

import Browser.BrowserСhoice;
import Pages.BasePage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import static Tests.TestRunner.loadApplication;

public class SearchTest {

    @DataProvider(name = "products")
    public Object[][] products() {
        return new Object[][]{{"iPhone"}};

    }

    @Test(dataProvider = "products")
    public void searchWithText(String prod){

        BasePage basePage = loadApplication();
        ProductPage productPage = basePage.searchProductInTopSearch(prod);
     List<String> products = productPage.findAllProducts();
     List<String> sortedProduct =  products.stream().filter(x->x.contains(prod)).toList();
        assert (sortedProduct.size()!= 0);
     Assert.assertEquals(sortedProduct.size(),products.size());
    }

    @DataProvider(name = "products name")
    public Object[][] productsName() {
        return new Object[][]{{"Смартфоны", "Apple","iPhone"}};
    }

    @Test(dataProvider = "products name")
    public void searchWithCatalog(String cat, String subCat, String prod){

        BasePage basePage = loadApplication();
        ProductPage productPage = basePage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat,subCat);
        String productName = productPage.getNameFromFirstProduct();
        Assert.assertTrue(productName.contains(prod));
    }

    @AfterTest(alwaysRun = true )
    public void tearDown(){
        BrowserСhoice.closeBrowser();

    }
}