package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "button-account")
	WebElement newCustomerContinueButton;
	
	@FindBy(id = "input-payment-firstname")
	WebElement firstnameField;
	
	@FindBy(id = "input-payment-lastname")
	WebElement lastnameField;
	
	@FindBy(id = "input-payment-address-1")
	WebElement addressField;
	
	@FindBy(id = "input-payment-city")
	WebElement cityField;
	
	@FindBy(id = "input-payment-postcode")
	WebElement paymentPostCodeField;
	
	@FindBy(id = "input-payment-country")
	WebElement paymentCountryField;
	
	@FindBy(id = "input-payment-zone")
	WebElement paymentStateField;
	
	@FindBy(id = "button-payment-address")
	WebElement paymentContinueButton;
	
	
	@FindBy(id = "button-shipping-address")
	WebElement deliveryContinueButton;
	
	
	
	@FindBy(id = "button-shipping-method")
	WebElement shippingmethodContinueButton;
	
	@FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[2]/div/a")
	WebElement termsAndConditionLink;
	
	@FindBy(xpath = "//*[@id=\"modal-agree\"]/div/div/div[1]/button")
	WebElement closeTermsAndConditionButton;
	
	@FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[1]/label/input")
	WebElement cashOndeliveryRadioButton;
	
	@FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
	WebElement termsAndConditionckeckBox;
	
	@FindBy(id = "button-payment-method")
	WebElement paymentMethodContinueButton;
	
	@FindBy(id = "button-confirm")
	WebElement confirmOrderContinueButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
	WebElement ContinueButtonAfterOrderPlaced;
	
	
	
	
	
	public void checkOutOptions()
	{
		newCustomerContinueButton.click();
	}
	public void billingDetails(String firstname,String lastname,String address,String city, String postcode,String country,String state)
	{
		firstnameField.sendKeys(firstname);
		lastnameField.sendKeys(lastname);
		addressField.sendKeys(address);
		cityField.sendKeys(city);
		paymentPostCodeField.sendKeys(postcode);
		
		Select obnmcountry = new Select(paymentCountryField);
		obnmcountry.selectByVisibleText(country);  
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-zone")));
		
		Select obnmstate = new Select(paymentStateField);
		obnmstate.selectByVisibleText(state);  
		paymentContinueButton.click();
		
	}
	public void deliveryDetails()
	{
		Actions obactions= new Actions(driver);
		obactions.moveToElement(deliveryContinueButton);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-address")));
		//obactions.doubleClick();
		deliveryContinueButton.click();
	}
	public void deliveryMethod()
	{
		shippingmethodContinueButton.click();
	}
	public void paymentMethod()
	{
		termsAndConditionLink.click();
		closeTermsAndConditionButton.click();
		
		boolean display=  cashOndeliveryRadioButton.isDisplayed();
		System.out.println("checking cashondelivary radiobutton is displayed="+ display);
		
		boolean display1=  termsAndConditionckeckBox.isDisplayed();
		System.out.println("checking termsAndConditionckeckBox is displayed="+ display1);
		
		termsAndConditionckeckBox.click();
		paymentMethodContinueButton.click();
		confirmOrderContinueButton.click();
		ContinueButtonAfterOrderPlaced.click();
	}
}
