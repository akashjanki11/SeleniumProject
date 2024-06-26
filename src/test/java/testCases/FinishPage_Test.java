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
import pages.FinishPage;
import pages.Inventory_Page;
import pages.LoginPage;
import pages.checkOutPage1;
import utility.ReadData;
import utility.Screenshot;

public class FinishPage_Test extends TestBase{
	 LoginPage login;
	   Inventory_Page invent;
	   CartIcon_InventoryPage cart;
	   CheckoutPage check1;
	   checkOutPage1 check2;
	   FinishPage finish;
	   @BeforeMethod
	   public void setUp() throws IOException, InterruptedException
	   {
		   initialization();
		   login=new LoginPage();
		   invent=new Inventory_Page();
		   cart=new CartIcon_InventoryPage();
		   check1=new CheckoutPage();
		   check2=new checkOutPage1();
		   finish=new FinishPage();
		   login.loginOfApplication();
		   invent.add6products();
		   invent.cartIcon();
		   cart.clickOncheckOutbtn();	
		   check1.inputinfo();
		   check2.verifyfinishbtn();
	   }
	   
	   @Test
	   public void verifytitle() throws EncryptedDocumentException, IOException
	   {
		   String expTitle = "Swag Labs";
		   String acttitle = finish.verifytitle();
		   Assert.assertEquals(expTitle, acttitle);
		   Reporter.log("Title of finish page: "+acttitle);
	   }
	   
	   @Test
	   public void verifyLogo() throws EncryptedDocumentException, IOException {
		   String expLogo=ReadData.readExcel(1, 2);
		  String actLogo=finish.verifyLogo();
		  Assert.assertEquals(expLogo, actLogo);
		  Reporter.log("Logo of finish Page: "+actLogo);
	   }
	   
	   @Test
	   public void verifythankyouLabel()
	   {
		   String expres = "Thank you for your order!";
		   String actRes = finish.verifythankyouLabel();
		   Assert.assertEquals(expres, actRes);
		   Reporter.log("Thank You Label of finish Page: "+actRes);
	   }
	   
	   @Test
	   public void verifytextOfDispatch()
	   {
		   String expRes = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		   String actRes = finish.verifyText();
		   Assert.assertEquals(expRes, actRes);
		   Reporter.log("Text of dispatched: "+actRes);
	   }
	   
	   @Test
	   public void verifyBackHomebtn() throws EncryptedDocumentException, IOException
	   {
		  String expUrl = ReadData.readExcel(1, 0);
		  String actUrl = finish.verifybackHome();
		  Assert.assertEquals(expUrl, actUrl);
		  Reporter.log("Url after clicking on backHome Btn: "+actUrl);
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
