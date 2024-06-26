package testCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.Screenshot;

public class MultiCredentials_Test extends TestBase{
	LoginPage login;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
	}
	
	@DataProvider(name="Validation")
	public Object[] [] getData()
	{	
		return new Object[] []
		{
			{"standard_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"},
		};
	}
	
	@Test(dataProvider="Validation")
	public void verifyMultiCredsTest(String un,String passwd)
	{
		SoftAssert s=new SoftAssert();
		String expUrl="https://www.saucedemo.com/inventory.html";
		String actUrl = login.verifyMultiCredTests(un, passwd);
		s.assertEquals(expUrl, actUrl);
		s.assertAll();	
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
