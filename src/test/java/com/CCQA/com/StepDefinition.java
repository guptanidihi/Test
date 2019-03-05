package com.CCQA.com;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition 
{    
	//Initialising WebDriver
	WebDriver driver;
	WebDriverWait wait;
	//Object of GetProperties to read properties file values
	GetProperties prop = new GetProperties();
	String URL=null;
	
	@Before 
	public void setUp() throws IOException
	{ 
	  //System.setProperty("webdriver.chrome.driver", "C:\\selenium tools\\chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", ".\\ChromeDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  wait = new WebDriverWait(driver,30);
	  URL = prop.getPropValues();
	} 
	
	@After
	public void Cleanup()
	{ 
	  driver.quit();	 
	} 
	
	@Given("^user navigates to http://the-internet.herokuapp.com/login$")
	public void navigatePage() 
	{
		 driver.navigate().to(URL);
		 driver.manage().window().maximize();
	}
		
		@When("^user logs in using Username as \"(.*)\" and Password \"(.*)\"$")
		public void login(String uname, String pwd)
		{
		 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(uname);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(pwd);
    	 }
	
		@And("^click on submit button$")
		public void click_on_submit_button() 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
		}
		
		@Then("^login should be successful$")
		public void validateLoginSuccess() 
		{
			System.out.println("Login with valid credentials testcase executed");
			List<WebElement> ele = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='/logout']")));
			if(ele.size()>0)
				System.out.println("Login Successful");
			else
				System.out.println("Login Failed");
		
			
		}
		
		@Then("^login should be unsuccessful$")
		public void validateLoginfailed() 
		{
			System.out.println("Login with invalid credentials testcase executed");
			List<WebElement> ele = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='flash error']")));
			if(ele.size()>0)
				System.out.println("Login Failed");
			else
				System.out.println("Test failed");
	
		}
		
	}

	

