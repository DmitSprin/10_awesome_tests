package Tests;


import Pages.MainPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;


public class SearchTest extends TestRunner {

    @DataProvider(name = "products", parallel = true )
    public Object[][] products() {
        return new Object[][]{{"iPhone"},{"iPhone"}};

    }

    @Test(dataProvider = "products")
    public void searchWithText(String prod){
        MainPage mainPage = loadApplication();
        ProductPage productPage = mainPage.searchProductInTopSearch(prod);
        List<String> products = productPage.findAllProductsAndReturnName();
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
        MainPage mainPage = loadApplication();
        ProductPage productPage = mainPage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat,subCat);
        String productName = productPage.getNameFromFirstProduct();
        Assert.assertTrue(productName.contains(prod));
    }

}