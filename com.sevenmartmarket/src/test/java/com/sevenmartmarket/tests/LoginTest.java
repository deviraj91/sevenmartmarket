package com.sevenmartmarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartmarket.base.Base;
import com.sevenmartmarket.pages.AdminPage;
import com.sevenmartmarket.pages.HomePage;
import com.sevenmartmarket.pages.LoginPage;
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
		// System.out.println(actualProfileName);
		Assert.assertEquals(actualProfileName, exectedProfileName);
		// System.out.println(GeneralUtility.getRandomName());
		// screenshotcapture.takeSceenshot(driver, "screenshotimage1");// //this is for
		// all cases to get screenshot

		// adminpage.adminclick();
		// adminpage.clickonNewButton();

	}

}
/**need to check
assert and sysout not working
**/