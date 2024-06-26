package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartIcon_InventoryPage;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class CartIcon_Test extends TestBase{
	Inventory_Page invent;
	LoginPage login;
	CartIcon_InventoryPage cart;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new CartIcon_InventoryPage();
		login.loginOfApplication();
		invent.add6products();
		invent.cartIcon();
	}
	
	@Test
	public void removeproducts()
	{
		String expcount = "1";
		String actCount = cart.removedProducts();
		Assert.assertEquals(expcount, actCount);
		Reporter.log("Count after removing products in cart page: "+actCount);
	}
	@Test
	public void carttitle()
	{
		String expLogo = "Swag Labs";
		String actLogo = cart.cartTitle();
		Assert.assertEquals(expLogo, actLogo);
		Reporter.log("Logo of cartTitle: "+actLogo);
	}
	
	@Test
	public void url()
	{
		String expUrl = "https://www.saucedemo.com/cart.html";
		String actUrl = cart.Url();
		Assert.assertEquals(expUrl,actUrl);
		Reporter.log("Url of cartIcon: "+actUrl);
	}
	
	@Test
	public void verifyCheckoutButtonTest() throws InterruptedException 
	{
		String exp = "https://www.saucedemo.com/checkout-step-one.html";
		String act = cart.verifyCheckoutButton1();
		Assert.assertEquals(exp, act);
		Reporter.log("After clicking on Checkout Btn URL is : " + act);
	}
	
	@Test
	public void twitterlogo()
	{
		boolean res = cart.twitterLogo();
		Assert.assertEquals(res, true);
		Reporter.log("TwitterLogo: "+res);
	}
	
	@Test
	public void continuebtn() throws InterruptedException
	{	
		cart.continuebtn();
	}
	
	@Test
	public void qty()
	{
		String expres = "QTY";
		String actRes = cart.qtytext();
		Assert.assertEquals(expres,actRes);
		Reporter.log("Qty text: "+actRes);
	}
	
	@Test
	public void desc()
	{
		String expRes = "Description";
		String actRes = cart.description();
		Assert.assertEquals(expRes, actRes);
		Reporter.log("Desc text: "+actRes);
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
