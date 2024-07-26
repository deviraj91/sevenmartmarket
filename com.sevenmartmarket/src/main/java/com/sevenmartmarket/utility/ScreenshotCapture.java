package com.sevenmartmarket.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenmartmarket.constants.Constants;

public class ScreenshotCapture {

	TakesScreenshot takesscreenshot;//interface
	public void takeSceenshot(WebDriver driver,String imagename)
	{
		try
		{
			takesscreenshot=(TakesScreenshot) driver;
			File screenshot=takesscreenshot.getScreenshotAs(OutputType.FILE);
			//to capture screenshot--
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String destination=Constants.SCREENSHOT_FILE_PATH+imagename+"_"+timeStamp+".png";
		    File finalDestination=new File(destination);
		    FileHandler.copy(screenshot, finalDestination);//to move file to desired file
		    
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}
	
}
