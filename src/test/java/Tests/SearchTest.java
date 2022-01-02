package Tests;


import Pages.MainPage;
import Pages.ProductPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;


public class SearchTest extends TestRunner {

    @DataProvider(name = "products")
    public Object[][] products() {
        return new Object[][]{{"iPhone"}};

    }

    @Test(dataProvider = "products")
    @Description("this test check the ability to find an item using a simple search")
    @Severity(SeverityLevel.NORMAL)
    public void searchWithText(String prod){
        MainPage basePage = loadApplication();
        ProductPage productPage = basePage.searchProductInTopSearch(prod);
        List<String> products = productPage.findAllProducts();
        List<String> sortedProduct =  products.stream().filter(x->x.contains(prod)).collect(Collectors.toList());
        assert (sortedProduct.size()!= 0);
        Assert.assertEquals(sortedProduct.size(),products.size());
    }

    @DataProvider(name = "products name")
    public Object[][] productsName() {
        return new Object[][]{{"Смартфоны", "Apple","iPhone"}};
    }

    @Test(dataProvider = "products name")
    @Description("this test check the ability to find an item using a catalog")
    @Severity(SeverityLevel.NORMAL)
    public void searchWithCatalog(String cat, String subCat, String prod){
        MainPage basePage = loadApplication();
        ProductPage productPage = basePage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat,subCat);
        String productName = productPage.getNameFromFirstProduct();
        Assert.assertTrue(productName.contains(prod));
    }

}