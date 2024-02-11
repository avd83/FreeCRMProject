package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	public LoginPage() {
		
		PageFactory.initElements(driver,this);		
	}
	@FindBy(css="input[placeholder='Username']")
	WebElement userName;
	
	@FindBy(css="input[placeholder='Password']")
	WebElement password;
	
	@FindBy(css="input[type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath= "//img[contains(@alt,'Free CRM Software for customer relationship management, sales and support')]")
	WebElement logo;
	
	public String validtaePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd)
	{
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage() ;
	}
}
