package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage{
	
	WebDriver driver;
	public ChangePasswordPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Password')]")
	WebElement passwordLink;
	
	@FindBy(id = "input-password")
	WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	WebElement confirmpasswordField;
	
	@FindBy(xpath = "//body/div[@id='account-password']/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")
	WebElement continueButton;
	
	@FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]")
	WebElement myAccount;
	
	@FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement continue3Button;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginlink;
	
	@FindBy(id = "input-email")
	WebElement emailfield;
	
	@FindBy(id = "input-password")
	WebElement passwordfield;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement loginButton;
	
	
	
	
	
	public void changePassword(String newpassword)
	{
		passwordLink.click();
		passwordField.sendKeys(newpassword);
		confirmpasswordField.sendKeys(newpassword);
		continueButton.click();
	}
	public void loginWithOldPassord(String Email, String password)
	{
		//logout
		myAccount.click();
		logoutLink.click();
		continue3Button.click();
		
		//loginWithOldPassord
		myAccount.click();
		loginlink.click();
		emailfield.sendKeys(Email);
		passwordfield.sendKeys(password);
		loginButton.click();
	}
	public void loginWithNEWPassord(String Email, String password)
	{
		emailfield.clear();
		emailfield.sendKeys(Email);
		passwordfield.clear();
		passwordfield.sendKeys(password);
		loginButton.click();
	}
	
	
	

}
