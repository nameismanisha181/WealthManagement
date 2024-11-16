package Product;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import ObjectRepository.CreatingNewProduct;
import ObjectRepository.HomePage;
import ObjectRepository.ProductInfoPage;
import ObjectRepository.ProductPage;

public class CreateProductTest extends BaseClass
{
       @Test
       public void CreateProduct() throws IOException
       {
    	   
    	   ExcelFileUtility eUtil= new ExcelFileUtility();
    	   String ProductName = eUtil.getDataFromExcel("Products", 1, 0);    	   
    	   
    	   System.out.println(ProductName);
    	   //Click on product tab
    	   HomePage hp = new HomePage(driver);
    	   hp.clickOnProduct();
    	   
    	   //Click on plus sign 
    	   ProductPage PP=new ProductPage(driver);
    	   PP.ClickOnProductImage();
    	   
    	   //Enter product details and click on save
    	   CreatingNewProduct CNP= new CreatingNewProduct(driver);
    	   CNP.createProduct(ProductName);
    	   
    	   //Verify product is created 
    	   ProductInfoPage PIP= new ProductInfoPage(driver);
    	   String actualProductName = PIP.getProductName();
    	   Assert.assertTrue(actualProductName.contains(ProductName));
    	   
    	    
       }
}
