package testCases;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends LoginPage {
	LoginPage login;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage();
	}
	
	@Test
	public void URL() throws EncryptedDocumentException, IOException
	{
		String expURL =ReadData.readExcel(0, 0);
		String actURL = login.verifyUrlofApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Login Url: "+actURL);
	}
	
	@Test
	public void loginofApplicationtest() throws IOException, InterruptedException
	{
		String expTitle =ReadData.readExcel(0, 1);
		String actTitle = login.loginOfApplication();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("inventory URL: "+actTitle);
	}
	
	@Test(enabled=false)
	public void titletest() throws EncryptedDocumentException, IOException {
		String expTitle = ReadData.readExcel(0, 2);//0,2
		String actTitle = login.titleofapplication();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("title: "+actTitle);
	}
	@AfterMethod
	public void browserClose(ITestResult it) throws IOException
	{	
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.ss(it.getName());
		}
		report.flush();
		driver.close();
	}

}


