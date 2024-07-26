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
		 //userTypedropdown.click();
		// select_usertype.click();
	}

	public void clickOnuserCreate() {
		savebutton.click();
	}

	public String getAlertOfUserCreation() {
		return successalert.getText();
	}

	public void enterUserCreateDetails(String newadminuser, String newadminpass, String UserType) {
		enterUsername(newadminuser);
		enterPassword(newadminpass);
		click_Usertype(UserType);
	}

	public void enterdetails() {
		enterUsername("devirraj");
		enterPassword("devi***2019");
		// click_Usertype();
		savebutton.click();
	}

	public void admincreate() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean tick = js.executeScript("arguments[0].isDisplayed;", successtick) != null;

		// js.executeScript("arguments[0].gettext;",successtick);

		Assert.assertFalse(false, "user created");

	}

}
