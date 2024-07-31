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

	@Test(enabled = false) // CONSTRUCTOR CHAINING EXAMPLE
	public void verify_adminUserLanding() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.Login();
		adminpage = homepage.clickOn_admin();

		String actualProfile = adminpage.getAdminUserText();
		String expectedProfile = "Admin Users";
		Assert.assertEquals(expectedProfile, expectedProfile);
	}
	/*
	 * @Test(dataProvider = "ExcelUserCredentials", dataProviderClass
	 * =Data_feeders.class,enabled=true) //METHOD CHAINING EXAMPLE public void
	 * create_newadminUser(String newadminuser, String newadminpass, String
	 * UserType) { loginpage.Login(); adminpage=new AdminPage(driver);
	 * adminpage=homepage.clickOn_admin();
	 * adminpage.clickonNewButton().enterUserCreateDetails(String
	 * newadminuser,String newadminpass,String UserType).clickOnuserCreate(); }
	 */

	@Test(groups = "smoke", enabled = false)
	public void adminpageVerifyAndCreateNew() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminpage = new AdminPage(driver);

		loginpage.Login();
		adminpage.adminclick();
		adminpage.getAdminUserText();
		adminpage.clickonNewButton();
		String username = GeneralUtility.getRandomName();// to avoid duplication.while testing we need to enter unique login data each time											
		String password = "devi1234*";
		adminpage.userDetailsAndSave(username, password, "Staff");

	}

	@Test(groups = "smoke", enabled = true)
	public void verifyUserCreation() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminpage = new AdminPage(driver);

		loginpage.Login();
		adminpage.adminclick();
		adminpage.getAdminUserText();
		adminpage.clickonNewButton();
		String username = GeneralUtility.getRandomName();
		String password = "devi1234*";
		adminpage.userDetailsAndSave(username, password, "Staff");
		String Actualsuccessalert = adminpage.userCreatedAlert();
		String Expectedsucessalert = "User Created Successfully";
		boolean alertmsg = Actualsuccessalert.contains(Expectedsucessalert);
		Assert.assertTrue(alertmsg);
		System.out.println("user created successfully");

	}

	@Test(groups = "smoke", enabled = true)
	public void verifySearchFuctionality() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminpage = new AdminPage(driver);

		loginpage.Login();
		adminpage.adminclick();
		adminpage.Searchfuction("ssss", "Staff");
		String SearchResult=adminpage.verifySearchFunction();
		String actualSearchData="ssss";
		Assert.assertEquals(actualSearchData, SearchResult);
		System.out.println("Search functionality working properly");
	}
	
	@Test(dataProvider = "UserCredentials", dataProviderClass = Data_feeders.class, enabled = false)
	public void verify_create_adminUser(String newadminuser, String newadminpass, String UserType) {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminpage = new AdminPage(driver);
		loginpage.Login();

		adminpage.adminclick();
		adminpage.clickonNewButton();
		adminpage.userDetailsAndSave(newadminuser, newadminpass, UserType);// from dataprovider
	}

	@Test(dataProvider = "ExcelUserCredentials", dataProviderClass = Data_feeders.class, enabled = false)
	public void verify_create_adminUser_excel(String newadminuser, String newadminpass, String UserType) {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		adminpage = new AdminPage(driver);

		loginpage.Login();
		adminpage.adminclick();
		adminpage.clickonNewButton();
		adminpage.userDetailsAndSave(newadminuser, newadminpass, UserType);// dataprovider excel
	}
}