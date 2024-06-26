package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class checkOutPage1 extends TestBase{
	@FindBy(xpath="//div[@data-test='payment-info-label']") private WebElement paymentLabel;
	@FindBy(xpath="//div[@data-test='payment-info-value']") private WebElement paymentText;
	@FindBy(xpath="//div[@data-test='shipping-info-label']") private WebElement shippingLabel;
	@FindBy(xpath="//div[@data-test='shipping-info-value']") private WebElement shippingtext;
	@FindBy(xpath="//div[@data-test='total-info-label']") private WebElement totalLabel;
	@FindBy(xpath="//div[@data-test='subtotal-label']") private WebElement itemtotaltext;
	@FindBy(xpath="//div[@data-test='tax-label']") private WebElement taxtext;
	@FindBy(xpath="//div[@data-test='total-label']") private WebElement totaltext;
	@FindBy(xpath="//button[@data-test='finish']") private WebElement finishbtn;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement qtylabel;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement desclabel;
	@FindBy(xpath="//div[text()='Payment Information:']") private WebElement payment;
	
	public checkOutPage1()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifypaymentLabel()
	{
		return paymentLabel.getText();
	}
	
	public String verifypaymentText()
	{
		return paymentText.getText();
	}

	public String Checkout1title()
	{
		return driver.getTitle();
	}
	
	public String CheckOut1URL()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyfinishbtn()
	{
		finishbtn.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyqtyLabel()
	{
		return qtylabel.getText();
	}
	
	public String verifydesclabel()
	{
		return desclabel.getText();
	}
	
	public String verifyShippinglabel()
	{
		return shippingLabel.getText();
	}
	
	public String verifyShippingtext()
	{
		return shippingtext.getText();
	}
	
	public String verifyTotalLabel()
	{
		return totalLabel.getText();
	}
	
	public String verifyitemtotaltext()
	{
		return itemtotaltext.getText();
	}
	
	public String verifytaxtext()
	{
		return taxtext.getText();
	}
	
	public String verifytotaltext()
	{
		return totaltext.getText();
	}
}
