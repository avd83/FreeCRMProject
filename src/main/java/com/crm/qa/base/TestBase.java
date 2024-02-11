package com.crm.qa.base;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListner;

@SuppressWarnings("deprecation")
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	@SuppressWarnings("deprecation")
	public static EventFiringWebDriver e_driver;
	public static WebEventListner eventListner;
	
	public TestBase(){
		
		try {
			prop=new Properties();
			FileReader fis = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\configuration\\configuration.properties");
			prop.load(fis);
			}
		catch(Exception e){
			System.out.println(e);
		}		
	}
			
	@SuppressWarnings("deprecation")
	public void Initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Abhay\\eclipse-workspace1\\FreeCRMTest\\driver\\chromedriver.exe");
			driver= new ChromeDriver();			
		}
		else if(browserName.equalsIgnoreCase("firfox")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Abhay\\eclipse-workspace1\\FreeCRMTest\\driver\\geckodriver.exe");
			driver= new FirefoxDriver();				
		}else if(browserName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Abhay\\eclipse-workspace1\\FreeCRMTest\\driver\\msedgedriver.exe");
			driver= new EdgeDriver();				
		}
		
		e_driver = new EventFiringWebDriver(driver);		
		eventListner= new WebEventListner();
		e_driver.register(eventListner);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	
	
	

}
