package com.magento.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.magento.testBase.BaseClass;

public class CommonMethods {
	
	
	public static void sendText(WebElement element,String text) {
		waitforVisibility(element);
		element.clear();
		element.sendKeys(text);
	}
	public static void clickAction(WebElement element) {
		waitforClickability(element);
	    element.click();
	}
	
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait= new WebDriverWait(BaseClass.driver,60);
	     return wait;
	}
	public static WebElement waitforClickability(WebElement ele) {
	return	getWaitObject().
		until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static WebElement waitforVisibility(WebElement ele) {
		return	getWaitObject().
			until(ExpectedConditions.visibilityOf(ele));
		}
	
	
	public static String takeScreenshot(String filename)  {
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.driver;
	    File file= ts.getScreenshotAs(OutputType.FILE);
	    String destinationFile=Constants.SCREENSHOT_FILEPATH+filename+getTimeStamp()+".png";
		
	  
  try {
	FileUtils.copyFile(file, new File(destinationFile));
} catch (IOException e) {

	e.printStackTrace();
}
		return destinationFile;
	}
	
	public static String getTimeStamp() {
		Date date= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	return sdf.format(date.getTime());
	}
	
}
