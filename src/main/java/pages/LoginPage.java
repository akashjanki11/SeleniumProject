package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase {
	@FindBy(xpath="//input[@id='user-name']") private WebElement usertextBox;
	@FindBy(xpath="//input[@id='password']") private WebElement passwdTextBox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginbtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String loginOfApplication() throws IOException, InterruptedException
	{	
		logger=report.createTest("Login to Sauce Labs application");
		usertextBox.sendKeys(ReadData.readPropertyFile("UserName"));
		logger.log(Status.INFO, "Username is entered");
		
		passwdTextBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO,"Password is entered");
		
		Thread.sleep(2000);
		loginbtn.click();
		logger.log(Status.INFO,"Login button is clicked");
		//Thread.sleep(2000);
		logger.log(Status.INFO,"Login is successfull");
		return driver.getCurrentUrl();
	}
	
	public String verifyMultiCredTests(String un,String passwd)
	{
		usertextBox.sendKeys(un);
		passwdTextBox.sendKeys(passwd);
		loginbtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyUrlofApplication()
	{
		return driver.getCurrentUrl();
	}
	
	public String titleofapplication() {
		return driver.getTitle();
	}
	
	
}
