package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//td[contains(text(),'User: test test2')]")
	WebElement userNameLable;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath="//a[text()='New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	

	public String verifyHomePageTitle()
	{
		String homePageTitle = driver.getTitle();
		return homePageTitle;
	}
	public boolean userNameLable()
	{		
		return userNameLable.isDisplayed();		
	}
	
	public ContactPage clickOnContctsLink()
	{
		contactsLink.click();
		return new ContactPage();
	}
	public DealPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealPage();
	}
	public TaskPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TaskPage();
	}
	
	public void clickOnNewContactLink() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		Thread.sleep(5000);
		newContactLink.click();
		Thread.sleep(5000);
	}
	
}
