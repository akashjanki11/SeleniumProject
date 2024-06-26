package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropdownList;

public class Inventory_Page extends TestBase{
	//object Repository
	@FindBy(xpath="//button[@data-test='add-to-cart-sauce-labs-backpack']") private WebElement productBackPack;
	@FindBy(xpath="//button[@data-test='add-to-cart-sauce-labs-bike-light']") private WebElement productBikeLight;
	@FindBy(xpath="//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']") private WebElement productfleecejacket;
	//@FindBy(xpath="//button[@data-test='add-to-cart-sauce-labs-onesie']") private WebElement productOnesie;
	//@FindBy(xpath="//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']") private
	@FindBy(xpath="//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath="//div[@class='app_logo']") private WebElement Logo;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[@href='https://www.facebook.com/saucelabs']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement LinkedInLogo;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropdown;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//div[@data-test='footer-copy']") private WebElement footerText;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement menubtn;
	@FindBy(xpath="//button[@data-test='remove-sauce-labs-bike-light']") private WebElement removeBikeLight;
	@FindBy(xpath="//button[@data-test='remove-sauce-labs-backpack']") private WebElement  removeBackPack;
	@FindBy(xpath="//button[@data-test='remove-sauce-labs-fleece-jacket']") private WebElement removefleecejacket;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement menudropdown;
	
	//calling
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods 
	public String verifyPageTitle()
	{	
		return pageTitle.getText();
	}
	
	public boolean verifyTwitterlogo()
	{
		return twitterLogo.isDisplayed();
	}
	
	public boolean verifyFacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	
	public boolean verifyLinkedinLogo()
	{
		return LinkedInLogo.isDisplayed();
	}
	
	public String add6products() throws InterruptedException
	{
		
		HandleDropdownList.handleSelect(dropdown,"Price (low to high)");
		productBackPack.click();
		productBikeLight.click();
		productfleecejacket.click();
		//Thread.sleep(2000);
		return cartIcon.getText();
	}
	
	public String remove6products() throws InterruptedException
	{
		add6products();
		removeBackPack.click();
		removeBikeLight.click();
		//Thread.sleep(2000);
		return cartCount.getText();
	}
	 public String Logo()
	 {
		 return Logo.getText();
	 }
	public String footerText()
	{
		return footerText.getText();
	}
	
	public void menudropdown()
	{	
		menudropdown.click();	
	}
	
	public void cartIcon()
	{
		cartIcon.click();
	}
	
}
