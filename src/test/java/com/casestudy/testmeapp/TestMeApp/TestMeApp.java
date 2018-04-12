package com.casestudy.testmeapp.TestMeApp;

import org.testng.annotations.Test;

//import com.tests.DriverUtitlity;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.awt.List;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestMeApp {
	WebDriver driver = DriverUtitlity.getDriver("chrome");

	@BeforeTest
	public void beforeTest() {
		driver.get("http://10.250.88.140:5432/TestMeApp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

	}

	@Test
	public void testMeApp() {
		String username="shetty12345";
		String password="mercury";
		
		//driver.findElement(By.linkText("SignIn")).click();
		
		//SignUp
		driver.findElement(By.linkText("SignUp")).click();
		driver.findElement(By.name("userName")).sendKeys(username);
		/*
		driver.findElement(By.id("err")).click();
		String validate=driver.findElement(By.id("err")).getText();
		Assert.assertEquals(validate,"Available");
		*/
		driver.findElement(By.name("firstName")).sendKeys("mercury");
		driver.findElement(By.name("lastName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(password);
		driver.findElement(By.name("gender")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("mercury@gmail.com");
		driver.findElement(By.name("mobileNumber")).sendKeys("9876543210");
		driver.findElement(By.name("dob")).sendKeys("27/03/1995");
		driver.findElement(By.name("address")).sendKeys("mercury-mercury-mercury");
		
		Select select = new Select(driver.findElement(By.name("securityQuestion")));
		select.selectByVisibleText("What is your Birth Place?");
		
		driver.findElement(By.name("answer")).sendKeys("MERCURY");
		driver.findElement(By.name("Submit")).click();
		
		//Login
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("Login")).click();
		
		//Order Item
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span"))).click().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span"))).click().perform();

		 driver.findElement(By.partialLinkText("Add to cart")).click();
		 driver.findElement(By.partialLinkText("Cart")).click();
		 driver.findElement(By.partialLinkText("Checkout")).click();
		 driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
		 
		 //Payment
		 driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
		 driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[1]")).sendKeys("123456");
		 driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[2]")).sendKeys("Pass@456");
		 driver.findElement(By.xpath("//*[@id=\"myForm\"]/div[1]/div[3]/input")).click();
		 
		 driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input")).sendKeys("Trans@456");
		 driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();
		 
		 //Home
		 driver.findElement(By.xpath("/html/body/header/div/div/ul/b/a[1]")).click();
		 
		 //Calculate number of orders
		 driver.findElement(By.partialLinkText("OrderDetails")).click();
		 java.util.List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		 int count = rows.size();
		 System.out.println("Number of Order Placed : "+count);
		
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	
	}

}
