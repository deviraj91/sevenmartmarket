package com.sevenmartmarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sevenmartmarket.constants.Constants;
import com.sevenmartmarket.utility.GeneralUtility;
import com.sevenmartmarket.utility.PageUtility;

public class AdminPage {

	WebDriver driver;
	Properties properties = new Properties();
	PageUtility pageutility;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement admin;

	@FindBy(xpath = "//h1[contains(text(),'Admin Users')]")
	public WebElement getadmintext;

	@FindBy(xpath = "//div[@class='col-sm-12']//i[@class='fas fa-edit']")
	private WebElement newbutton;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernamefield;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordfield;

	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypedropdown;
	/*
	 * @FindBy(
	 * xpath="//select[@id='user_type']//option[@value='admin' and contains(text(),'Admin')]"
	 * ) private WebElement select_usertype;
	 */
	@FindBy(xpath = "//button[@type='submit']//i[@class='fa fa-save']")
	private WebElement savebutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successalert;

	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	private WebElement successtick;
	
	@FindBy(xpath="//div[@class='col-sm-12']//a[2]")
	private WebElement searchbutton;
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement searchUsername;
	
	@FindBy(xpath="//select[@name='ut']")
	private WebElement searchUsertype;

	@FindBy(xpath="//button[@name='Search']")
	private WebElement FindSearch;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	private WebElement SearchOutput;
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream file = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adminclick() {
		admin.click();
	}

	public String getAdminUserText() {
		String admintext = getadmintext.getText();
		System.out.println("admintext is" + admintext);
		return getadmintext.getText();
	}

	public void clickonNewButton() {
		newbutton.click();
	}

	public void enterUsername(String newadminuser) {
		usernamefield.sendKeys(newadminuser);
	}

	public void enterPassword(String newadminpass) {
		passwordfield.sendKeys(newadminpass);
	}

	public void click_Usertype(String UserType) {
		pageutility = new PageUtility(driver);
		pageutility.select_Byvisibletext(userTypedropdown, UserType);
	}

	public void clickOnuserCreate() {
		savebutton.click();
	}
    public void userDetailsAndSave(String newadminuser, String newadminpass, String UserType) {
		
		enterUsername(newadminuser);
		enterPassword(newadminpass);
		click_Usertype(UserType);
		savebutton.click();
	}
	
	public String userCreatedAlert()
	{
		String successAlertmsg=successalert.getText();
		//System.out.println(successAlertmsg);
		return successAlertmsg;
	}
	
	public void Searchfuction (String searchUser,String Usertype) {
		pageutility = new PageUtility(driver);
		searchbutton.click();	
		searchUsername.sendKeys(searchUser);
		pageutility.select_Byvisibletext(searchUsertype, Usertype);
		FindSearch.click();
		
	}
	public String verifySearchFunction()
	{
		return SearchOutput.getText();
	}

}
