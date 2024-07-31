package com.sevenmartmarket.pages;

import static org.testng.Assert.assertListContains;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sevenmartmarket.utility.GeneralUtility;
import com.sevenmartmarket.utility.PageUtility;

public class ManageProductPage {

	static WebDriver driver;
	GeneralUtility generalutility = new GeneralUtility();
	PageUtility pageutility;
	@FindBy(xpath = "//li[@class='nav-item']//p[contains(text(),'Manage Product')]")
	private WebElement manageProduct;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement listProduct;
	/**
	 * @FindBy(xpath="//div[@class='card-body table-p//table[@class='tabletable-bordered table-hover
	 *                                        table-sm']//thead//tr[1]//th[1]")
	 *                                        private WebElement
	 *                                        manageproducttabletitle;
	 **/
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//thead//tr")
	List<WebElement> fullrowheadings;

	@FindBy(xpath = "//a[contains(text(),'New')]")
	private WebElement newButton;

	@FindBy(xpath = "//input[@id='title']")
	private WebElement titleclick;

	@FindBy(xpath = "//input[@id='purpose']")
	private WebElement pricetype;

	@FindBy(xpath = "//input[@id='purpose1' and @value='piece']")
	private WebElement piecePricetype;

	@FindBy(xpath = "//input[@id='p_stock']")
	private WebElement stockavailabilityvalue;

	@FindBy(xpath = "//div[@class='col-sm-6']//input[@name='unlimitw[]']")
	private WebElement checkboxUnlimted;

	@FindBy(xpath = "//div[@class='note-editable card-block']/p")
	private WebElement descriptionbox;

	@FindBy(xpath = "//div[@class=' form-group']//input[@id='main_img']")
	private WebElement Fileupload;

	@FindBy(xpath="//button[@type='submit' and @name='create']")
	WebElement savebutton;
	
	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageproduct() {
		manageProduct.click();
	}

	public void getTextOfListproducts() {
		String listproducttext = listProduct.getText();

		System.out.println(listproducttext);
	}

	public String print_css_Fontstyle() {
		String css1 = "fontStyle";
		css1 = generalutility.get_cssValue(listProduct, css1);
		return css1;
	}

	public void getFullrow() {
		for (WebElement eachfield : fullrowheadings) {
			System.out.println(eachfield.getText());
		}
	}

	public void ClickonNewButton() {
		newButton.click();
	}

	public void addProductpage(String title) {
		titleclick.click();
		titleclick.sendKeys(title);

		boolean radiopricetype = pricetype.isEnabled();
		piecePricetype.click();
	}
	public void addproductScroll(String stock)
	{
		pageutility = new PageUtility(driver);
		pageutility.js_Scrollandclick(stockavailabilityvalue);
		stockavailabilityvalue.sendKeys(stock);
		//pageutility.js_Scrollandclick(checkboxUnlimted);
		 descriptionbox.sendKeys("description entered");
	}
	public void uploadFile() {
		//String fileToUpload= System.getProperty("user.dir")+"\\Keshava Prabha Microfin Loan Card CAAG96923.pdf";
		Fileupload.sendKeys("C:\\Users\\devir\\OneDrive\\Pictures\\Screenshots");
	}
	public void saveandAlert() 
	{
		pageutility = new PageUtility(driver);
		pageutility.js_Scrollandclick(savebutton);
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
public void check_Product_Add()
{
	String currentUrl="https://groceryapp.uniqassosiates.com/admin/Product/add";
	String newUrl=driver.getCurrentUrl();
   Assert.assertEquals(currentUrl, newUrl);
   if(currentUrl==newUrl)
   {
	   System.out.println("Product not added");
   }
   else
   {
	   System.out.println("product added");
   }
}
}
