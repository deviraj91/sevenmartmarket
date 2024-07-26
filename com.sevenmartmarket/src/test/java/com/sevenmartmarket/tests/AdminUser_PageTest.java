package com.sevenmartmarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartmarket.base.Base;

import com.sevenmartmarket.pages.AdminPage;
import com.sevenmartmarket.pages.HomePage;
import com.sevenmartmarket.pages.LoginPage;
import com.sevenmartmarket.utility.GeneralUtility;


import dataProviders.Data_feeders;

public class AdminUser_PageTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	AdminPage adminpage;

	@Test(groups = "smoke")

	public void adminpageVerify() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminpage = new AdminPage(driver);

		loginpage.Login();
		// adminpage.adminclick();
		// adminpage.getAdminUserText();
		// String text=adminpage.getAdminUserText();
		// System.out.println("text is" +text);
		// adminpage.clickonNewButton();
	}

	// @Test
	// Dataprovider
	@Test(dataProvider = "ExcelUserCredentials", dataProviderClass = Data_feeders.class)
	public void verify_create_adminUser(String newadminuser, String newadminpass, String UserType) // dataprovider
	// public void verify_create_adminUser()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminpage = new AdminPage(driver);

		loginpage.Login();
		System.out.println(newadminuser);
		adminpage.adminclick();
		adminpage.clickonNewButton();
		adminpage.enterUserCreateDetails(newadminuser, newadminpass, UserType);// dataprovider

		adminpage.clickOnuserCreate();
		// String username=GeneralUtility.getRandomName();//to avoid duplication,while
		// entering username and password utility is used
		// String password="devi@123";
		// adminpage.enterUserCreateDetails(username,password,"Staff");

	}
}