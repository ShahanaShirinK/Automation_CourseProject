package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]")
	WebElement myAccount;
	
	@FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement continue3Button;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginlink;
	
	@FindBy(xpath = "//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")
	WebElement loginButton;
	
	@FindBy(id = "input-email")
	WebElement emailfield;
	
	@FindBy(id = "input-password")
	WebElement passwordfield;
	
	
	public void Logout()
	{
		myAccount.click();
		logoutLink.click();
		continue3Button.click();
	}
	public void login(String Email, String password)
	{
		myAccount.click();
		loginlink.click();
		emailfield.sendKeys(Email);
		passwordfield.sendKeys(password);
		loginButton.click();
	}
}
