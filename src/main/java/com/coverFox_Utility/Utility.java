package com.coverFox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
	// Read data from Excel
	
	public static String readDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile = new FileInputStream("D:\\Excel_Selenium_Practice.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
		String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("Reading data from excel", true);
		return data;
		
	}
	

	//ScreenShot
	
	public static void takeScreenshot(WebDriver driver,String screenshotName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\screenshot"+screenshotName+".png");
		FileHandler.copy(src, dest);	
		Reporter.log("Taking ScreenShot, Saved at "+dest, true);
	}
	
	//ScrollIntoView
	
	public static void ScrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("Scrolling Into View ", true);
	}
	
	public static String readDataFromPropertiesFile(String key) throws IOException
	{
		Properties prop = new Properties();
		
		//C:\Users\imlpa\eclipse-workspace\Selenium_Study\coverFox1.properties
		
		FileInputStream myFile= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\coverFox1.properties");
		prop.load(myFile);
		
		String value = prop.getProperty(key);
		Reporter.log("Reading " +key+ " from properties file", true);
		
		return value;
		
	}

}
