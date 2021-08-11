package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;

	public static void getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\eclipse-workspace\\Online3PMCucumberFramework\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}


	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void mamixizeWindow() {
		driver.manage().window().maximize();
	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void insertType(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public static void click(WebElement ele) {
		ele.click();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static String getData(int row, int cell) throws IOException {
		// loc of the file
		File loc = new File("C:\\Users\\ADMIN\\eclipse-workspace\\PracticeOnline\\Input\\TestData.xlsx");
		// Read the file
		FileInputStream fi = new FileInputStream(loc);
		// Type of workbook
		Workbook w = new XSSFWorkbook(fi);
		// sheetName
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(row);// 0
		Cell c = r.getCell(cell);// 0
		int cellType = c.getCellType();
		// cellType 1-->String,0-->Date,Number
		String value = null;
		if (cellType == 1) {
			value = c.getStringCellValue();
		} else if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sd = new SimpleDateFormat("mm-DD-YYYY");
				value = sd.format(dateCellValue);
			}else {
				double numericCellValue = c.getNumericCellValue();
				//Typecasting-->convert one datatype into another datatype
				long l=(long) numericCellValue;
				value = String.valueOf(l);
			}
		}
		return value;

	}
	
	public static String getAttribute(WebElement ele,String s) {
		String attribute = ele.getAttribute(s);
		return attribute;
	}
	
	public static void pause(long millsec) throws InterruptedException {
		Thread.sleep(millsec);
	}
}
