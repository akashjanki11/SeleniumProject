package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartIcon_InventoryPage;
import pages.CheckoutPage;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CheckOutPage_Test extends TestBase{
	   LoginPage login;
	   Inventory_Page invent;
	   CartIcon_InventoryPage cart;
	   CheckoutPage check1;
	   @BeforeMethod
	   public void setUp() throws IOException, InterruptedException
	   {
		   initialization();
		   login=new LoginPage();
		   invent=new Inventory_Page();
		   cart=new CartIcon_InventoryPage();
		   check1=new CheckoutPage();
		   login.loginOfApplication();
		   invent.add6products();
		   invent.cartIcon();
		   cart.removedProducts();
		   cart.clickOncheckOutbtn();
	   }
	   
	  @Test
	  public void infotest() throws EncryptedDocumentException, IOException, InterruptedException
	  {
		  String Expurl = ReadData.readExcelCheckOut(0, 3);
		  String actUrl = check1.inputinfo();
		  Assert.assertEquals(Expurl, actUrl);
		  Reporter.log("URL of checkout Information: "+actUrl);
	  }
	  
	  @Test
	  public void verifymenubtn() throws InterruptedException
	  {
		    check1.verifyMenubtn();
	  }
	  
	  @Test
	  public void verifymenuText() throws InterruptedException
	  {
		  String exptext = "About";
		  String acttext = check1.verifymenuText();
		  Assert.assertEquals(exptext, acttext);
		  Reporter.log("text: "+acttext);
	  }
	  @Test
	  public void verifyLogotest()
	  {
		  String expLogo = "Swag Labs";
		  String actLogo = check1.verifyLogo();
		  Assert.assertEquals(expLogo, actLogo);
		  Reporter.log("Checkout step one logo name: "+actLogo);
	  }
	  @Test
	  public void verifyCancelbtn()
	  {
		  check1.verifycancelbtn();
	  }
	  @Test
	  public void checkouttitle() {
		  check1.checkoutTitle();
	  }
	   
	  @AfterMethod
		public void closeBrowser(ITestResult it) throws IOException
		{
			if(it.FAILURE==it.getStatus())
			{
				Screenshot.ss(it.getName());
			}
			driver.close();
		}
}
