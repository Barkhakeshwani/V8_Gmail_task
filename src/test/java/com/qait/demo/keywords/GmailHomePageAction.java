package com.qait.demo.keywords;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class GmailHomePageAction extends GetPage {

	WebDriver driver;
	List<String> listOfLabelNames;
	String labelName;
	public GmailHomePageAction(WebDriver driver) {
		super(driver, "GmailHomePage");
		this.driver=driver;
	}
	
	public void clickGmailIcon() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("gmail_Icon");
		element("gmail_Icon").click();
	}

	public String getProfileName()	{
		/*WebElement element = element("text_profile_name");
		wait.waitForElementToBeVisible(element);*/
		//wait.waitForPageToLoadCompletely();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isElementDisplayed("text_profile_name");
		logMessage("get profile name as "+element("text_profile_name").getText());
		return element("text_profile_name").getText();
	}
	
	public void clickMore() {
		//wait.waitForPageToLoadCompletely();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isElementDisplayed("element_more");
		element("element_more").click();
		logMessage("element more is clicked ");
	}

	public String createNewFolder() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("link_to_create_folder");
		element("link_to_create_folder").click();
		logMessage("Link create new label is clicked ");
		giveLabelName();
		isElementDisplayed("btn_create_label");
		element("btn_create_label").click();
		logMessage("btn_create_label is clicked ");
		return element("label_created_verification_msg").getText();
	}
	
	public void giveLabelName() {
		List<String> windowsList=new ArrayList<String>(driver.getWindowHandles());
        String windows1= ((String)windowsList.get(0));
        driver.switchTo().window(windows1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isElementDisplayed("txt_label_name");
		/*listOfLabelNames = getListOfLabelName();
		String labelName = listOfLabelNames.get(0);
		listOfLabelNames.remove(0);*/
		//labelName = getLabelName();
		element("txt_label_name").sendKeys("citibank");		
	}
	
	public void selectEmailToMoveToLabel() {
		if ( element("checkbox1").getAttribute("aria-checked").equalsIgnoreCase("false"))
		{
		     element("checkbox1").click();
		}
		logMessage("checkbox is selected");
	}

	public void selectMoveToIcon() {
		//wait.waitForPageToLoadCompletely();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isElementDisplayed("move_to_icon");
		element("move_to_icon").click();
		logMessage("move to icon is clicked");
	}

	public String selectLabelToWhichMailsAreToBeMoved() {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed("select_label_to_move");
		element("select_label_to_move").click();
		logMessage("Selected mails moved");
		return element("mail_moved_verification_msg").getText();
	}
	
	/*public List<String> getListOfLabelName() {
		listOfLabelNames = new ArrayList<String>();
		listOfLabelNames.add("politico");
		listOfLabelNames.add("TOI");
		listOfLabelNames.add("gmail");
		listOfLabelNames.add("reportStatus");
		listOfLabelNames.add("newProject");
		listOfLabelNames.add("application");
		return listOfLabelNames;
		
	}*/
	
	public String getLabelName() {
	        String uuid = UUID.randomUUID().toString();
	        return "uuid = " + uuid;
	}

}
