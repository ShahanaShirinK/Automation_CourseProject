package testPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.LoginPage;

public class LoginTest extends BaseClass{

	@Parameters({"password"})
	@Test
	public static void login(String password)
	{
		LoginPage obnm = new LoginPage(driver);
		obnm.Logout();
		
		String generatedRandomEmail = RegisterTest.randomEmail;
		obnm.login(generatedRandomEmail, password);
		
	}
}
