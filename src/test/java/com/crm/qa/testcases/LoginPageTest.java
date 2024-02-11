package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest()
	{
		super();
	}	
	@BeforeMethod
	public void setUp()
	{
		log.info("Initialize the web browser");
		Initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void validtaePageTitleTest()
	{
		log.info("---------------------Test Started----------------");
		String title = loginPage.validtaePageTitle();	
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
		log.info("---------------------Test Ended----------------");
	}
	
	@Test(priority=2)
	public void validateLogoTest()
	{
		log.info("---------------------Test Started----------------");
		boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);
		log.info("---------------------Test Ended----------------");
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		log.info("---------------------Test Started----------------");
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		log.info("---------------------Test Ended----------------");
	}
	
	@AfterMethod
	public void tearDown()
	{
		log.info("---------------------Test Execution ended----------------");
		driver.quit();
		log.info("---------------------Quite from the browser----------------");
	}
}
