package testPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.AddToCartPage;
import pagePackage.ChangePasswordPage;

public class AddToCartTest extends BaseClass {
	
	@Parameters({"newPassword"})
	@Test
	public void AddtoCartTest(String newPassword)
	{
		ChangePasswordPage obnmchange = new ChangePasswordPage(driver);
		
		String generatedEmail = RegisterTest.randomEmail;
		obnmchange.loginWithNEWPassord(generatedEmail, newPassword);
		
		
		AddToCartPage obnm = new AddToCartPage(driver);
		obnm.AddtoCart("2");
		
		/*
		String ProductaddSuccessMessage = driver.findElement(By.xpath("//body/div[@id='product-product']/div[1]")).getText();
		System.out.println(ProductaddSuccessMessage);
		Assert.assertTrue(ProductaddSuccessMessage.contains("Success: You have added"),"product not added to cart");
		*/
		
		obnm.writeReview("GoodProductGoodProductGoodProductGoodProductGoodProductGoodProduct");
		/*
		String reviewsubmitsuccessmessage= driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[2]")).getText();
		System.out.println(reviewsubmitsuccessmessage);
		Assert.assertTrue(reviewsubmitsuccessmessage.contains("Thank you for your review. It has been submitted to the webmaster for approval"),"review is not submitted");
		*/
		
		driver.navigate().back();
		obnm.gotoHomePage();
		
		
	}																	

}
