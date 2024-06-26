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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class InventoryPage_Test extends TestBase {
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		login.loginOfApplication();
	}
	
	@Test
	public void add6productsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount ="3";
		String actCount = invent.add6products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Counts after adding of Products: "+actCount);
	}
	
	@Test
	public void removeproducts() throws InterruptedException, EncryptedDocumentException, IOException {
		String expCount ="1";//1
		String actCount = invent.remove6products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("count after removing products: "+actCount);
	}
	
	@Test
	public void verifyTwitterlogoTest() {
		boolean result = invent.verifyTwitterlogo();
		Assert.assertEquals(result, true);
		Reporter.log("TwitterLogo is present: "+result);
	}
	
	@Test
	public void FacebookLogo()
	{
		boolean result = invent.verifyFacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("FacebookLogo is present: "+result);
	}
	
	@Test
	public void LinkedInLogo()
	{
		boolean result = invent.verifyLinkedinLogo();
		Assert.assertEquals(result, true);
		Reporter.log("LinkedIn Logo is present: "+result);
	}
	
	
	
	@Test
	public void PageTitleTest()
	{
		String expTitle ="Products";
		String actTitle = invent.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("title of the page: "+actTitle);
	}
	
	
	
	@Test
	public void Footertest()
	{
		String expResult = "© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actResult = invent.footerText();
		Assert.assertEquals(expResult, actResult);
		Reporter.log("Footertext: "+actResult);
	}
	
	@Test
	public void Logotest()
	{
		String expResult = "Swag Labs";
		String actResult = invent.Logo();
		Assert.assertEquals(expResult,actResult);
		Reporter.log("SwagLogo: "+actResult);
	}
	
	@Test
	public void menudropdown()
	{
		 invent.menudropdown();
	}
	
	@Test
	public void cartIcontest()
	{
		invent.cartIcon();
	}
	@AfterMethod
	public void browserClose(ITestResult it) throws IOException
	{	
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.ss(it.getName());
		}
		driver.close();
}
}
