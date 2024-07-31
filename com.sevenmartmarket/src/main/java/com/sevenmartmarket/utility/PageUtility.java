package com.sevenmartmarket.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public WebDriver driver;
	JavascriptExecutor js;
	
	public PageUtility(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor) driver;
	}
	
	public void select_byIndex(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void select_Byvisibletext(WebElement element, String visibleText)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public void js_Click(WebElement element)
	{
		js.executeScript("arguments[0].click();",element);
				
	}
	//if element is clicked
public boolean is_clicked(WebElement element)
{
	try {
		element.click();
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
}
//used for scroll and click
public void js_Scrollandclick(WebElement element)
{
	while(! is_clicked(element))
	{
		int x=0;
		js.executeScript("window.scrollBy(0," + x + ")");
		x=x+2;
	}
}

//write for  actions class
}
