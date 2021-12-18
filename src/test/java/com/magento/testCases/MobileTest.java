package com.magento.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.magento.testBase.BaseClass;
import com.magento.testBase.PageIntializer;
import com.magento.utils.CommonMethods;
import com.magento.utils.ExcelUtility;

public class MobileTest extends PageIntializer{
	/*      
	Test Steps:
	1. Goto http://live.techpanda.org/index.php/
	2. Click on ‘MOBILE’ menu
	3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
	4. Click on Sony Xperia mobile
	5. Read the Sony Xperia mobile from detail page. Product value in list and details page should be equal ($100). 
	*/
	
	@Test
	public void test_001() {
	   mobilePage.mobileClick1.click();
		String dashboardPrice=mobilePage.xperiaDashboardPagePrice.getText();
		System.out.println("dashboardPrice " +dashboardPrice);
		mobilePage.xperiaClick.click();
	    String detailsprice=	detailsPage.xperiaDetailsPagePrice.getText();
	   SoftAssert sa= new SoftAssert();
	   sa.assertEquals(dashboardPrice, detailsprice,"values did match in details price and dashboard price");
	   CommonMethods.takeScreenshot("price");
	   System.out.println("shiva changes");
	   sa.assertAll();
	
	
	}
	@Test(dataProvider="userdataFromExcel",enabled=false)
	public void dataDriven_002(String FirstName,String LastName,String EmailAddress,String Password,String ConfirmPassword) {
		CommonMethods.clickAction(registrationPage.myaccountlink);
		CommonMethods.clickAction(registrationPage.creataccunt);
      CommonMethods.sendText(registrationPage.firstname, FirstName);
      CommonMethods.sendText(registrationPage.firstname, LastName);
      CommonMethods.sendText(registrationPage.firstname, EmailAddress);
      CommonMethods.sendText(registrationPage.firstname, Password);
      CommonMethods.sendText(registrationPage.firstname, ConfirmPassword);
      CommonMethods.clickAction(registrationPage.register);
  
   
	}
	
	
	@DataProvider(name="userdataFromExcel")
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray("C:\\Users\\Pranitha Regalla\\Desktop\\TestData.xlsx", "Sheet1");
	}
}
