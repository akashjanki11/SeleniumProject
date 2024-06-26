package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class CheckoutPage extends TestBase {
	//object repository
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement postalcode;
	@FindBy(xpath="//input[@class='submit-button btn btn_primary cart_button btn_action']") private WebElement continuebtn;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement menubtn;
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium cart_cancel_link']") private WebElement cancelbtn;
	@FindBy(xpath="//div[@class='app_logo']") private WebElement logo;
	@FindBy(xpath="//a[@id='about_sidebar_link']") private WebElement menuText1;
	
	//calling method for the webelements
	public CheckoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String inputinfo() throws EncryptedDocumentException, IOException, InterruptedException
	{
		firstName.sendKeys(ReadData.readExcelCheckOut(0, 0));
		lastName.sendKeys(ReadData.readExcelCheckOut(0, 1));
		postalcode.sendKeys(ReadData.readExcelCheckOut(0,2));
		continuebtn.click();
		Thread.sleep(1000);
		return driver.getCurrentUrl();
	}
	
	public void verifyMenubtn() throws InterruptedException
	{
		menubtn.click();
		Thread.sleep(2000);
	}
	
	public String verifyLogo()
	{
		return logo.getText();
	}
	
	public void verifycancelbtn()
	{
		cancelbtn.click();
	}
	
	public void checkoutTitle()
	{
		driver.getTitle();
	}
	
	public String verifymenuText()
	{	
		menubtn.click();
		return menuText1.getText();
	}
	
}
	
	


