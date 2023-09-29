package testPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import basePackage.BaseClass;
import pagePackage.RegistrationPage;

public class RegisterTest extends BaseClass{
	
	public static String randomEmail;
	
	@Parameters({"firstName","lastName","PhoneNumber","password","confirmPassword"})
	@Test
	public void RegistrationTest(String firstName,String lastName, String PhoneNumber,
			String password,String confirmPassword)
	{
		RegistrationPage obnm= new RegistrationPage(driver);
		
		obnm.clickMyAccount();
		obnm.clickRegisterLink();
		obnm.passfirstname(firstName);
		obnm.passLastName(lastName);
		
		Faker faker = new Faker();
		randomEmail= faker.name().firstName().toLowerCase()+"@gmail.com";
		obnm.passEmail(randomEmail);
		
		
		obnm.passPhoneNumber(PhoneNumber);
		obnm.passPassword(password);
		obnm.passConfirmPassword(confirmPassword);
		//obnm.ClickPrivacyPolicy();
		obnm.clickContinueButton();
		
	}
	
	
	

}
