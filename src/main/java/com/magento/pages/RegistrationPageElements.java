package com.magento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.testBase.BaseClass;

public class RegistrationPageElements extends BaseClass {
	@FindBy(xpath="(//a[text()='My Account'])[2]")
	public WebElement myaccountlink;
	@FindBy(xpath="//a[@title='Create an Account']")
	public WebElement creataccunt;
	@FindBy(xpath="//input[@id='firstname']")
	public WebElement firstname ;
	@FindBy(xpath="//input[@id='lastname']")
	public WebElement lastname;
	@FindBy(xpath="//input[@id='email_address']")
	public WebElement emailAddress;
	
	@FindBy(xpath="//input[@title='Password']")
	public WebElement password;
	@FindBy(xpath="//input[@title='Confirm Password']")
	public WebElement confirmpassword;
	@FindBy(xpath="//button[@title='Register']")
	public WebElement register;
	@FindBy(xpath="//ul[@class='messages']//span")
	public WebElement welcomeMessageOnRegister;
	
	public RegistrationPageElements() {
		PageFactory.initElements(driver, this);
	}

}




