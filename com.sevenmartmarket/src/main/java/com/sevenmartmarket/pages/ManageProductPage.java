package com.sevenmartmarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartmarket.utility.GeneralUtility;

public class ManageProductPage {

	WebDriver driver;
	GeneralUtility generalutility=new GeneralUtility();
	
	@FindBy(xpath="//li[@class='nav-item']//p[contains(text(),'Manage Product')]")
	private WebElement manageProduct;
	
	@FindBy(xpath="//li[@class='nav-item']//p[contains(text(),'Manage Product')]")
	private WebElement listProduct;
	
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']//table[@class='table table-bordered table-hover table-sm']//thead//tr[1]//th[1]")
	private WebElement manageproducttabletitle;
	
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']//table[@class='table table-bordered table-hover table-sm']//thead")
	List <WebElement> fullrowheadings;
	
	@FindBy(xpath="//a[contains(text(),'New')]")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement titleclick;
	
	@FindBy(xpath="//input[@id='purpose']")
	private WebElement pricetype;
	
	public  ManageProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnManageproduct()
	{
		manageProduct.click();
	}
	
	public void getTextOfListproducts()
	{
		String listproducttext=listProduct.getText();
		
		System.out.println(listproducttext);
		}
	public void manageproductstitle()
	{
		String manageproductstitletext=manageproducttabletitle.getText();
		
		System.out.println(manageproductstitletext);
		}
		
	
	
	public String print_css_Fontstyle()
	{
		String css1="fontStyle";
		css1=generalutility.get_cssValue(listProduct, css1);
		return css1;
	}
	
	public void getTabletitle()
	{
		String titlecell=manageproducttabletitle.getText();
		System.out.println(titlecell);
	}
	
	public void getFullrow()
	{
		for(WebElement firstfullrowlist:fullrowheadings)
		{
			System.out.println(firstfullrowlist.getText());
		}
	}
	public void ClickonButton()
	{
		newButton.click();
		titleclick.click();
		titleclick.sendKeys("orange");
		boolean radiopricetype=pricetype.isEnabled();
		System.out.println(radiopricetype);
	}
	
}
