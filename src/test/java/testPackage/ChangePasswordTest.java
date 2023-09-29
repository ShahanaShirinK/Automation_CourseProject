package testPackage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.ChangePasswordPage;

public class ChangePasswordTest extends BaseClass{
	
	
	@Parameters({"newPassword", "password"})
	@Test
	public void changePassword(String newPassword,String password)
	{
		ChangePasswordPage obnm = new ChangePasswordPage(driver);
		
		obnm.changePassword(newPassword);
		String ActualsuccessMessage= driver.findElement(By.xpath("//body/div[@id='account-account']/div[1]")).getText();
		System.out.println(ActualsuccessMessage);
		Assert.assertTrue(ActualsuccessMessage.contains("Your password has been successfully updated"));
		
		
		String generatedEmail= RegisterTest.randomEmail;
		obnm.loginWithOldPassord(generatedEmail,password);
		
		String ActualErrorMessage = driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		Assert.assertTrue(ActualErrorMessage.contains("No match for E-Mail Address and/or Password"));
	
		
		obnm.loginWithNEWPassord(generatedEmail, newPassword);
		String ActualpageTitle = driver.getTitle();
		String expectedPageTitle = "My Account";
		Assert.assertEquals(ActualpageTitle, expectedPageTitle, "Page title not as expected. Login unsuccessfull. Testcase failed");
	
	
	}
	
}
