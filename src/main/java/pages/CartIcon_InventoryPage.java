package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartIcon_InventoryPage extends TestBase {
	//object repository
	@FindBy(xpath="//span[@class='title']") private WebElement cartTitle;
	@FindBy(xpath="//div[@class='app_logo']") private WebElement cartLogo;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//button[@name='remove-sauce-labs-backpack']") private WebElement removebackpack;
	@FindBy(xpath="//button[@name='remove-sauce-labs-bike-light']") private WebElement removebikeLight;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	//@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button']") private WebElement checkoutbtn;
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium']") private WebElement continuebtn;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement qtytext;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement description;
	@FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button ']") private WebElement checkoutBtn;
	
	//calling Webelements
	public CartIcon_InventoryPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//methods
	public String removedProducts()
	{	
		removebackpack.click();
		removebikeLight.click();
		return cartCount.getText();
	}
	public String cartTitle()
	{
		return driver.getTitle();
	}
	
	public String Url()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean twitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	
	public String verifyCheckoutButton1() throws InterruptedException
	{
		checkoutBtn.click();
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}
	
	public void continuebtn() throws InterruptedException
	{
		continuebtn.click();
		Thread.sleep(2000);
	}
	
	public String qtytext()
	{
		return qtytext.getText();
	}
	
	public String description()
	{
		return description.getText();
	}
	
	public void clickOncheckOutbtn()
	{
		checkoutBtn.click();
	}
}
