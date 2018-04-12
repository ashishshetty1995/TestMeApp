package com.casestudy.testmeapp.TestMeApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtitlity {
	
	public static WebDriver getDriver(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\A07208trng_b4a.03.28\\Desktop\\Ashish\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			return new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\A07208trng_b4a.03.28\\Desktop\\Ashish\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else
		{
		return null;
		}
	}

}
