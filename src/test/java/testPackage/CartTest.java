package testPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.AddToCartPage;
import pagePackage.CartPage;
import pagePackage.CheckoutPage;

public class CartTest extends BaseClass{

	@Test
	public void ckeckOutTest()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		CartPage obnm = new CartPage(driver);
		obnm.gotoAddtocartpage();
		obnm.viewproductDetails();
		obnm.reviseProductQuantity("3");
		
		String reviseQuantitySuccessMessage= driver.findElement(By.xpath("//*[@id=\"checkout-cart\"]/div[1]")).getText();
		System.out.println(reviseQuantitySuccessMessage);
		Assert.assertTrue(reviseQuantitySuccessMessage.contains("You have modified your shopping cart"),"not modified revised quntity");
		
		obnm.clickcontinueShopping();
		AddToCartPage obnmaddtocart= new AddToCartPage(driver);
		obnmaddtocart.shopAnotherProduct();
		obnmaddtocart.gotoHomePage();

		obnm.gotoAddtocartpage();
		obnm.cancelOutOfStockProduct();

		//obnm.passCouponCode("125489");
		//obnm.estimateTax("673638");
		//obnm.setAsGift("happy Birthday");
		//obnm.reviseProductQuantity("0");

		obnm.clickCheckoutButton();


		
	}
}
