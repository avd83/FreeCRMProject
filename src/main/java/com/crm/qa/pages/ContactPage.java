package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLable;
	
	//@FindBy(name="title")
	//WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@type='submit'and @value='Save']")
	WebElement saveBtn;
	
	public boolean verifyContactLable()
	{
		return contactLable.isDisplayed();
	}
	
	public void selectContact(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String fName,String lName) throws InterruptedException {
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.name("title")));
		Thread.sleep(3000);
		select.selectByVisibleText(title);
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);	
		saveBtn.click();
	}
	
	

}
