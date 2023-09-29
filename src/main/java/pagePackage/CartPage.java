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

public class CartPage {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"cart\"]/button")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]")
	WebElement viewCartButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")
	WebElement viewproductDetails;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")
	WebElement ProductQuantityfield;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]")
	WebElement updateButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[1]/a")
	WebElement continueShoppingButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr[2]/td[4]/div/span/button[2]")
	WebElement cancelButton;
	
	@FindBy(xpath = "//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")
	WebElement couponcodeLink;
	
	@FindBy(id = "input-coupon")
	WebElement couponcodeField;
	
	@FindBy(id = "button-coupon")
	WebElement applyCouponButton;
	
	@FindBy(xpath = "//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")
	WebElement taxLink;
	
	@FindBy(id = "input-country")
	WebElement countryField;
	
	@FindBy(id = "input-zone")
	WebElement stateField;
	
	@FindBy(id = "input-postcode") 
	WebElement postCodeField;
	
	@FindBy(id = "button-quote")
	WebElement getQuoteButton;
	
	@FindBy(xpath = "//*[@id=\"accordion\"]/div[3]/div[1]/h4/a")
	WebElement giftFiledLink;
	
	@FindBy(id = "input-voucher")
	WebElement giftCertificate;
	
	@FindBy(id = "button-voucher")
	WebElement giftCertificateBuuton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
	WebElement checkoutButton;
	
	
	
	
	
	
	
	public void gotoAddtocartpage()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart\"]/button")));
																			
		addToCartButton.click();
		viewCartButton.click();
	}
	public void viewproductDetails()
	{
		viewproductDetails.click();
		driver.navigate().back();
	}
	
	public void reviseProductQuantity(String quantity)
	{
		ProductQuantityfield.clear();
		ProductQuantityfield.sendKeys(quantity);
		updateButton.click();
	}
	public void clickcontinueShopping()
	{
		continueShoppingButton.click();
	}
	public void cancelOutOfStockProduct()
	{
		cancelButton.click();
	}
	public void passCouponCode(String couponcode)
	{
		couponcodeLink.click();
		couponcodeField.sendKeys(couponcode);
		applyCouponButton.click();;
	}
	public void estimateTax(String postcode)
	{
		taxLink.click();
		Select obcountry= new Select(countryField);
		obcountry.selectByVisibleText("India");
		
		Select obstate= new Select(stateField);
		obstate.selectByVisibleText("Torfaen");
		
		postCodeField.sendKeys(postcode);
		getQuoteButton.click();
		
		driver.switchTo().alert().accept();
	}
	public void setAsGift(String certificate)
	{
		giftFiledLink.click();
		giftCertificate.sendKeys(certificate);
		giftCertificateBuuton.click();
		driver.switchTo().alert().accept();
	}
	/*
	public void clickCheckoutButton()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Checkout')]")));
			checkoutButton.click();
		}catch(StaleElementReferenceException e)
		{
			System.out.println("stale element exception handled");
		}
	}
	*/
	public void clickCheckoutButton()
	{
		Boolean checkingEnability = checkoutButton.isEnabled();
		System.out.println(checkingEnability);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//*[@id=\\\"content\\\"]/div[3]/div[2]/a")));
		
		Actions obact = new Actions(driver);
		obact.moveToElement(checkoutButton);
		obact.click().perform();
		
		//checkoutButton.click();
		
	}
	
}
