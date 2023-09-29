package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPage {

	WebDriver driver;
	public AddToCartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
	WebElement DesktopMenu;
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")
	WebElement SelectProduct;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[1]/h4/a")
	WebElement SelectMAC;
	
	@FindBy(xpath = "//*[@id=\"input-quantity\"]")
	WebElement QuantityField;
	
	@FindBy(xpath = "//*[@id=\"button-cart\"]")
	WebElement AddToCartButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[2]/a")
	WebElement ReviewButton;
	
	@FindBy(id = "input-review")
	WebElement reviewField;
	
	@FindBy(xpath = "//*[@id=\"form-review\"]/div[4]/div/input[4]")
	WebElement rating4;
	
	@FindBy(id = "button-review")
	WebElement continueButton;
	
	@FindBy(xpath = "//*[@id=\"product-category\"]/ul/li[1]/a")
	WebElement homeButton;
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[6]/a")
	WebElement PhonePDAmenu;
	
	@FindBy(id = "list-view")
	WebElement listview;
	
	@FindBy(id = "grid-view")
	WebElement gridview;
	
	@FindBy(id = "input-sort")
	WebElement sortField;
	
	@FindBy(id = "input-limit")
	WebElement noOfProductView;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[1]")
	WebElement cartIcon;
	
	
	
	
	public void AddtoCart(String Quantity)
	{
		DesktopMenu.click();
		SelectProduct.click();
		SelectMAC.click();
		QuantityField.clear();
		QuantityField.sendKeys(Quantity);
		AddToCartButton.click();
		
	}
	public void writeReview(String review)
	{
		ReviewButton.click();;
		reviewField.sendKeys(review);
		rating4.click();
		continueButton.click();
	}
	public void gotoHomePage()
	{
		homeButton.click();
	}
	public void shopAnotherProduct()
	{
		PhonePDAmenu.click();
		
		viewProductasList();
		viewProductasGrid();
		sortHighToLow();
		setLimitofProductView();
		addtocart();
		
	}
	
	
	public void viewProductasList()
	{
		listview.click();
	}
	public void viewProductasGrid()
	{
		gridview.click();
	}
	
	
	public void sortHighToLow()
	{
		Select obsort= new Select(sortField);
		obsort.selectByVisibleText("Price (High > Low)");
	}
	public void setLimitofProductView()
	{
		Select oblimit= new Select(noOfProductView);
		oblimit.selectByVisibleText("25");
	}
	public void addtocart()
	{
		cartIcon.click();
	}
	
	
	
	
}
