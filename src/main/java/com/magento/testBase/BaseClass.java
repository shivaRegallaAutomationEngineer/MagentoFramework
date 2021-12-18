package com.magento.testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.magento.utils.ConfigsReader;
import com.magento.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
public static ExtentHtmlReporter htmlreporter;
public static ExtentReports report;
public static ExtentTest test;

@BeforeTest(alwaysRun=true)
public void generateReport() {
	ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
	htmlreporter= new ExtentHtmlReporter(Constants.EXTENT_REPORT);
    htmlreporter.config().setDocumentTitle("ExtentReports");
    htmlreporter.config().setReportName("MagentoReport");
     report = new ExtentReports();
     report.attachReporter(htmlreporter);

}
@AfterTest(alwaysRun=true)
public void writeReport() {
report.flush();
}

@BeforeMethod(alwaysRun=true)
public static WebDriver setUp() {
	
	   switch (ConfigsReader.getProperty("BrowserName")) {
	      case "chrome":
			    WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new FirefoxDriver();
				break;
			case "microsoftEdge":
				WebDriverManager.edgedriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				throw new RuntimeException("Browser is not supported");
			}
            driver.get(ConfigsReader.getProperty("URL"));
            PageIntializer.intialize();
            driver.manage().window().maximize();
         return driver;

		}

@AfterMethod(alwaysRun=true)
public static void tearDown() {
	driver.quit();
}

}