package com.sevenmartmarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartmarket.constants.Constants;

public class LoginPage {

	WebDriver driver;
	Properties properties = new Properties();

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement SigninButton;

//create a constructor to fetch driver details and data from config file
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream file = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickonSigninButton() {
		SigninButton.click();
	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickonSigninButton();
	}

	public void Login() {
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickonSigninButton();

	}

}
