package com.sevenmartmarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='d-block']")
	WebElement prolilenameElement;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminUserTileInfo;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	private WebElement ManageProductMenu;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement ListProductHeading;

	@FindBy(xpath = "//a[@class='nav-link']//i[@class='nav-icon fas fa-edit']")
	private WebElement ManageContentMenu;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement ManageNewsMenu;

	@FindBy(xpath = "//i[@class='nav-icon sidebar-item-icon fa fa-cog']")
	private WebElement SettingsMenu;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement ManageNewsHeading;

	@FindBy(xpath = "/html/body/div/aside[1]/div/div[4]/div/div/nav/ul/li[7]/ul/li[3]/a/p")
	private WebElement LogoutMenu;
	@FindBy(xpath = "//p[@class='login-box-msg' ]")
	private WebElement SigninBox;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfilename() {
		return prolilenameElement.getText();
	}

	public AdminPage clickOn_admin() {
		adminUserTileInfo.click();
		return new AdminPage(driver);
	}

	public void manageProductMenuClick() {
		ManageProductMenu.click();
	}

	public boolean listProducts_Page() {
		return ListProductHeading.isDisplayed();
		//return ListProductHeading.getText();
	}

	public void manageContentMenuClick() {
		ManageContentMenu.click();
		ManageNewsMenu.click();
	}

	public String manageNews_Page() {
		return ManageNewsHeading.getText();
	}

	public void settingsMenu() {
		SettingsMenu.click();
	}

	public void logoutClick() {
		LogoutMenu.click();
	}

	public String SignIn_Page() {
		return SigninBox.getText();
	}
}
