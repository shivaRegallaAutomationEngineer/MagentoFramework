package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.testBase.BaseClass;

public class DetailsPageElements extends BaseClass{

	@FindBy(xpath="//span[@class='price']")
	public WebElement xperiaDetailsPagePrice;
	
	public DetailsPageElements() {
		PageFactory.initElements(driver, this);
	}
}
