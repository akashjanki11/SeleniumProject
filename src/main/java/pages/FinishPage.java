package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class FinishPage extends TestBase{
	@FindBy(xpath="//button[@id='back-to-products']") private WebElement backHomeBtn;
	@FindBy(xpath="//div[@class='app_logo']") private WebElement logo;
	@FindBy(xpath="//span[@data-test='title']") private WebElement title;
	@FindBy(xpath="//img[@class='pony_express']") private WebElement img;
	@FindBy(xpath="//h2[@data-test='complete-header']") private WebElement thankYouLabel;
	@FindBy(xpath="//div[@data-test='complete-text']") private WebElement textOfDispatch;
	
	public FinishPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifytitle()
	{
		return logo.getText();
	}
	public String verifyLogo()
	{
		return logo.getText();
	}
	
	public String verifythankyouLabel()
	{
		 return thankYouLabel.getText();
	}
	
	public String verifyText()
	{
		return textOfDispatch.getText();
	}
	
	public String verifybackHome()
	{
		backHomeBtn.click();
		return driver.getCurrentUrl();
	}

}
