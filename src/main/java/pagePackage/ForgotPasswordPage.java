package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	WebDriver driver;
	public ForgotPasswordPage(WebDriver driver)
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
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")
	WebElement forgottenPasswordLink;
	
	@FindBy(id = "input-email")
	WebElement emailField;
	
	@FindBy(xpath = "//body/div[@id='account-forgotten']/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")
	WebElement continueButton;
	
	@FindBy(xpath = "//body/div[@id='account-login']/div[1]")
	WebElement EmailSendedSuccessMessage;
	
	
	
	public void logout()
	{
		myAccount.click();
		logoutLink.click();
		continue3Button.click();
	}
	public void ForgotPassword(String Email)
	{
		myAccount.click();
		loginlink.click();
		forgottenPasswordLink.click();
		emailField.sendKeys(Email);
		continueButton.click();
	}
	
}
