package com.sevenmartmarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenmartmarket.constants.Constants;
import com.sevenmartmarket.utility.ScreenshotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	Properties properties=new Properties();
	ScreenshotCapture screenshotcapture=new ScreenshotCapture();
	
	public Base()
	{
		try {
			FileInputStream file= new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(file);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		}
	//initialize browser
	public void intialize(String browser,String url)
	{
		if(browser.equalsIgnoreCase("chrome"))
				//equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver();
			driver=new FirefoxDriver();
		}
		 
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		
		
	}
	
	@BeforeMethod (enabled=true,alwaysRun=true)
	//alwaysRun
public void launchBrowser()
{
		String browser=properties.getProperty("browser");//to read from properties file
        String url=properties.getProperty("url");
        intialize(browser,url);
}

	////crossbrowser usage
	@Parameters("browser") // to receive data from xml
	@BeforeMethod(enabled=false)
	public void launchBrowser(String browser)
	{
			
	        String url=properties.getProperty("url");
	        intialize(browser,url);
	}
	@AfterMethod(alwaysRun=true)
	public void terminateSession(ITestResult itestResult)
	//ITestResult--Interface
	{
		//listener//monitors a TC that whether it is pass or fail or skip
		if(itestResult.getStatus()==ITestResult.FAILURE)
		{
			screenshotcapture.takeSceenshot(driver,itestResult.getName());
		//itestResult.getName()-to get the name of last executed testcase
		}
	}
}

