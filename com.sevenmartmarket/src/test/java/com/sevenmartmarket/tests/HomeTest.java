package com.sevenmartmarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartmarket.base.Base;
import com.sevenmartmarket.pages.AdminPage;
import com.sevenmartmarket.pages.HomePage;
import com.sevenmartmarket.pages.LoginPage;

public class HomeTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	AdminPage adminpage;

	@Test(groups = { "smoke" })
	public void getDashboardprofile() {
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminPage adminpage = new AdminPage(driver);

		loginpage.Login();
		System.out.println(homepage.getProfilename());
		String Actualprofile=homepage.getProfilename();
		String Expectedprofile="Admin";
		Assert.assertEquals(Actualprofile, Expectedprofile);
	}

	@Test(groups = { "smoke" })
	public void clickManageProductAndVerify() {
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminPage adminpage = new AdminPage(driver);

		loginpage.Login();
		homepage.manageProductMenuClick();
		Boolean ListProductsHeading = homepage.listProducts_Page();
		Assert.assertTrue(ListProductsHeading,"Failed");
		System.out.println("Manage Product menu Click activity working fine");
	}

	@Test(groups = { "smoke" })
	public void clickManageContentAndVerify() {
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminPage adminpage = new AdminPage(driver);

		loginpage.Login();
		homepage.manageContentMenuClick();
		String ActualManageNewsHeading = homepage.manageNews_Page();
		String ExpectedManageNewsHeading = "Manage News";
		Assert.assertEquals(ExpectedManageNewsHeading, ActualManageNewsHeading);
		System.out.println("Manage Content menu Click activity working fine");
		homepage.settingsMenu();
	}

	@Test(groups = { "smoke" })
	public void clickSettingsAndVerifyLogout() {
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		AdminPage adminpage = new AdminPage(driver);

		loginpage.Login();
		homepage.settingsMenu();
		homepage.logoutClick();
		String ActualSignInText = homepage.SignIn_Page();
		String ExpectedSignInText = "Sign in to start your session";
		Assert.assertEquals(ActualSignInText, ExpectedSignInText);
		System.out.println("Logout Activity done correctly");
	}

}
