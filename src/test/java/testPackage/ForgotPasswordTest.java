package testPackage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.ForgotPasswordPage;

public class ForgotPasswordTest extends BaseClass{

	@Test
	public void forgotPasswordTest()
	{
		ForgotPasswordPage obnm = new ForgotPasswordPage(driver);
		obnm.logout();
		
		String generatedEmail= RegisterTest.randomEmail;
		obnm.ForgotPassword(generatedEmail);
		
		String EmailSendedSuccessMessage= driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		Assert.assertTrue(EmailSendedSuccessMessage.contains("An email with a confirmation link has been sent your email address."));
	}
}
