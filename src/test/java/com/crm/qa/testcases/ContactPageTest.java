package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	
	String sheetName="contact";
	
	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		Initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();		
		contactPage = new ContactPage();				
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		testUtil.switchToFrmae();
		contactPage = homePage.clickOnContctsLink();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void verifyContactPageLable()
	{
		Assert.assertTrue(contactPage.verifyContactLable(),"contact lable is missing on the page");
	}
	
	@Test(priority=2)
	public void verifySelectContact() {
		contactPage.selectContact("amar sinha");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data [][]  = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3,dataProvider="getCRMTestData")
	public void validateCreatenewContact(String title,String fName,String lName) throws InterruptedException
	{
		homePage.clickOnNewContactLink();
		Thread.sleep(4000);
		contactPage.createNewContact(title,fName,lName);
		Thread.sleep(4000);
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
