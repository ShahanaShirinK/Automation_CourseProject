package testPackage;

import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.CheckoutPage;

public class CheckoutTest extends BaseClass {
	
	@Test
	public void checkout()
	{
		CheckoutPage obnm = new CheckoutPage(driver);
		
		//obnm.checkOutOptions();
		obnm.billingDetails("shahana shirin", "K", "punnakkad", "malappuram", "673638", "India", "Torfaen");
		obnm.deliveryDetails();
		obnm.deliveryMethod();
		obnm.paymentMethod();
	}
}
