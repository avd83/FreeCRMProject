package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=10;
	public static long IMPLICITE_WAIT =10;
	
	//public static String TESTDATA_SHEET_PATH = System.getProperty(("user.dir")+"\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMtestData.xlsx");
	
	public static String TESTDATA_SHEET_PATH= "C:\\Users\\Abhay\\eclipse-workspace1"
			+ "\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMtestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
		
	public void switchToFrmae() {
		
		driver.switchTo().frame("mainpanel");		
	}
	
	public static void takeScreenShotAtEndOfTest() throws IOException
	{
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File(currentDir + "/screenshots/" + System.currentTimeMillis()+ ".png"));
	}
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream fis=null;		
		try {
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try{
			book = WorkbookFactory.create(fis);
		}catch (InvalidFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++){
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)	{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}

}
