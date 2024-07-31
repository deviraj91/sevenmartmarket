package com.sevenmartmarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartmarket.base.Base;
import com.sevenmartmarket.pages.AdminPage;
import com.sevenmartmarket.pages.HomePage;
import com.sevenmartmarket.pages.LoginPage;
import com.sevenmartmarket.utility.ExcelReader;
import com.sevenmartmarket.utility.GeneralUtility;
import com.sevenmartmarket.utility.ScreenshotCapture;

import dataProviders.Data_feeders;

public class LoginTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	AdminPage adminpage;

	@Test(groups = { "smoke" })
	public void verifyLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminpage = new AdminPage(driver);
		loginpage.Login();

		String actualProfileName = homepage.getProfilename();
		String exectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, exectedProfileName);
		// screenshotcapture.takeSceenshot(driver, "screenshotimage1");this is to get
		// screenchot for all cases
	}

	@Test
	public void excel_check() {
		ExcelReader excel = new ExcelReader();
		excel.setExcelFile("login_file1", "userdetails");
		System.out.println(excel.getCell_Data(1, 1));
	}
}
