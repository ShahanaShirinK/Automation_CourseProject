package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement RegisterLink;
	
	@FindBy(id = "input-firstname")
	WebElement firstnamefield;
	
	@FindBy(id = "input-lastname")
	WebElement lastnamefield;
	
	@FindBy(id = "input-email")
	WebElement emailfield;
	
	@FindBy(id = "input-telephone")
	WebElement telephonefield;
	
	@FindBy(id = "input-password")
	WebElement passwordfield;
	
	@FindBy(id = "input-confirm")
	WebElement confirmpasswordfield;
	
	@FindBy(xpath = "//b[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicyLink;
	
	@FindBy(xpath = "//div[@id='modal-agree']/div/div/div/button")
	WebElement closeButtonprivacyPolicy;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement continueButton;
	
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement continue2Button;
	
	@FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement continue3Button;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginlink;
	
	@FindBy(xpath = "//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")
	WebElement loginButton;
	
	
	public void clickMyAccount()
	{
		myAccount.click();
	}
	public void clickRegisterLink()
	{
		RegisterLink.click();
	}
	public void passfirstname(String firstname)
	{
		firstnamefield.sendKeys(firstname);
	}
	public void passLastName(String lastname)
	{
		lastnamefield.sendKeys(lastname);
	}
	public void passEmail(String email)
	{
		emailfield.sendKeys(email);
	}
	public void passPhoneNumber(String telephoneNumber)
	{
		telephonefield.sendKeys(telephoneNumber);
	}
	public void passPassword(String password)
	{
		passwordfield.sendKeys(password);
	}
	public void passConfirmPassword(String confirmPassword)
	{
		confirmpasswordfield.sendKeys(confirmPassword);
	}
	public void ClickPrivacyPolicy()
	{
		privacyPolicyLink.click();
		closeButtonprivacyPolicy.click();
	}
	public void clickContinueButton()
	{
		boolean privacyCheckBox = privacyPolicyCheckBox.isSelected();
		
		if(privacyCheckBox == true)
		{
			continueButton.click();
			continue2Button.click();;
		}
		else
		{
			privacyPolicyCheckBox.click();
			continueButton.click();
			continue2Button.click();
		}
	}
	
	
	

}
