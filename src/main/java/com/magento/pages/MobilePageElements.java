package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.testBase.BaseClass;

public class MobilePageElements extends BaseClass{

public WebElement mobileClick= driver.findElement(By.xpath("//a[text()='Mobile']"));
//not using the pagefactory

//using the pageFactory  and @FindBy

@FindBy(xpath="//a[text()='Mobile']")
public WebElement mobileClick1;
@FindBy(xpath="//a[@title='Xperia']//following::span[1]//span")
public WebElement xperiaDashboardPagePrice;

@FindBy(xpath="//a[@title='Xperia']")
public WebElement xperiaClick;

public MobilePageElements() {
	PageFactory.initElements(driver, this);
}

}
