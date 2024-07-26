package com.sevenmartmarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartmarket.base.Base;
import com.sevenmartmarket.pages.AdminPage;
import com.sevenmartmarket.pages.HomePage;
import com.sevenmartmarket.pages.LoginPage;
import com.sevenmartmarket.pages.ManageProductPage;

public class ManageProductTest  extends Base{
ManageProductPage manageproductpage;
AdminPage adminpage;
LoginPage loginpage;
HomePage homepage;

@Test(groups={"Smoke","regresion"})

public void verifyManagerproduct()
{
	loginpage = new LoginPage(driver);
	homepage=new HomePage(driver);

	adminpage=new AdminPage(driver);
	loginpage.Login();
	manageproductpage=new ManageProductPage(driver);
	manageproductpage.clickOnManageproduct();
	manageproductpage.getTextOfListproducts();
	String actualname="Devi";
	String expectedname="Devi";
	
	
	
	Assert.assertEquals(actualname, expectedname);
	
	manageproductpage.getFullrow();
	manageproductpage.ClickonButton();
	
	
}
}
