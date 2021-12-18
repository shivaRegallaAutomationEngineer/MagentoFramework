package com.magento.testBase;

import com.magento.pages.DetailsPageElements;
import com.magento.pages.MobilePageElements;
import com.magento.pages.RegistrationPageElements;

public class PageIntializer extends BaseClass{
	public static MobilePageElements mobilePage;
	public static DetailsPageElements detailsPage;
	public static RegistrationPageElements registrationPage;
	public static void intialize() {
		mobilePage= new MobilePageElements();
		detailsPage= new DetailsPageElements();
		registrationPage=new RegistrationPageElements();
	}

}
