package com.qait.demo.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;

public class GmailLoginPageAction extends GetPage {

	public GmailLoginPageAction(WebDriver driver) {
		super(driver,"GmailLoginPage");
	}
	
	public void submitLoginDetails()
    {
		wait.waitForPageToLoadCompletely();
        isElementDisplayed("txt_email");
        element("txt_email").clear();
        element("txt_email").sendKeys(YamlReader.getData("emailId_gmail"));
        isElementDisplayed("btn_next");
        element("btn_next").click();
        isElementDisplayed("txt_password");
        element("txt_password").clear();
        element("txt_password").sendKeys(YamlReader.getData("password_gmail"));
        isElementDisplayed("btn_sign_in");
        element("btn_sign_in").click();
    }

}
