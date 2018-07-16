package com.qait.demo.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class HomePageAction extends GetPage {

	
	public HomePageAction(WebDriver driver) {
		super(driver, "HomePage");
	}

	public String getProfileName()
	{
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("txt_profileName");
		logMessage("get profile name as "+element("txt_profileName").getText());
		return element("txt_profileName").getText();
	}
}
