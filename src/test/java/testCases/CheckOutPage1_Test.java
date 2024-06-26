package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

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
import pages.checkOutPage1;
import utility.Screenshot;

public class CheckOutPage1_Test extends TestBase{
	 LoginPage login;
	   Inventory_Page invent;
	   CartIcon_InventoryPage cart;
	   CheckoutPage check1;
	   checkOutPage1 check2;
	   @BeforeMethod
	   public void setUp() throws IOException, InterruptedException
	   {
		   initialization();
		   login=new LoginPage();
		   invent=new Inventory_Page();
		   cart=new CartIcon_InventoryPage();
		   check1=new CheckoutPage();
		   check2=new checkOutPage1();
		   login.loginOfApplication();
		   invent.add6products();
		   invent.cartIcon();
		   cart.clickOncheckOutbtn();	
		   check1.inputinfo();
	   }
	
	@Test
	public void verifypaymentLabeltest()
	{
		String expRes = "Payment Information:";
		String actRes = check2.verifypaymentLabel();
		Assert.assertEquals(expRes, actRes);
		Reporter.log("Label of Payment info: "+actRes);
	}
	
	@Test
	public void verifypaymentinfotext()
	{
		String expRes = "SauceCard #31337";
		String actRes = check2.verifypaymentText();
		Assert.assertEquals(expRes, actRes);
		Reporter.log("Text of payment info: "+actRes);
	}
	   
	@Test
	public void CheckOutPage1Title()
	{
		String expTitle = "Swag Labs";
		String actTitle = check2.Checkout1title();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of chechout page step two:" +actTitle);
	}
	
	@Test
	public void verifyShippinglabel()
	{
		String expLabel = "Shipping Information:";
		String actLabel = check2.verifyShippinglabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Shipping info label: "+actLabel);
	}
	
	@Test
	public void verifyShippingtext()
	{
		String exptext = "Free Pony Express Delivery!";
		String actText = check2.verifyShippingtext();
		Assert.assertEquals(exptext, actText);
		Reporter.log("Shipping information text :"+actText);
	}
	@Test
	public void CheckOutPage1URl()
	{
		String expUrl="https://www.saucedemo.com/checkout-step-two.html";
		String actUrl = check2.CheckOut1URL();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Url of checkout page step two: "+actUrl);
	}
	
	@Test
	public void verifytotalLabel()
	{
		String explabel = "Price Total";
		String actLabel = check2.verifyTotalLabel();
		Assert.assertEquals(explabel, actLabel);
		Reporter.log("Total Price label: "+actLabel);
	}
	
	@Test
	public void verifyitemtotaltext()
	{
		String expRes = "Item total: $89.97";
		String actRes = check2.verifyitemtotaltext();
		Assert.assertEquals(expRes, actRes);
		Reporter.log("Item total: "+actRes);
	}
	
	@Test
	public void verifytaxtext()
	{
		String exptext = "Tax: $7.20";
		String acttext = check2.verifytaxtext();
		Assert.assertEquals(exptext, acttext);
		Reporter.log("Tax text: "+acttext);
	}
	
	@Test
	public void verifytotaltext()
	{
		String exptext = "Total: $97.17";
		String acttext = check2.verifytotaltext();
		Assert.assertEquals(exptext, acttext);
		Reporter.log("Total text: "+acttext);
	}
	
	@Test
	public void verifyfinishbtntest()
	{	
		String expurl = "https://www.saucedemo.com/checkout-complete.html";
		String actUrl = check2.verifyfinishbtn();
		Assert.assertEquals(expurl, actUrl);
		Reporter.log("After clicking finish btn Complete Url: "+actUrl);
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
