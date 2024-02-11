package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	DealPage dealPage;
	TaskPage taskPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		Initialization();
		testUtil = new TestUtil();
		contactPage = new ContactPage();
		loginPage = new LoginPage();		
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","HomePage title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameLableTest() {
		testUtil.switchToFrmae();
		Assert.assertTrue(homePage.userNameLable());		 
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest()
	{		
		testUtil.switchToFrmae();
		contactPage = homePage.clickOnContctsLink();
	}
	
	@Test(priority=4)
	public void verifyDealsLinkTest()
	{
		testUtil.switchToFrmae();
		dealPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void verifyTaskLinkTest(){
		testUtil.switchToFrmae();
		taskPage = homePage.clickOnTasksLink();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
