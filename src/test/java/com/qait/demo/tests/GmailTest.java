package com.qait.demo.tests;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qait.automation.TestSessionInitiator;

public class GmailTest {
	
    private TestSessionInitiator testSessionInitiator;
    
    
    @BeforeTest
    public void initializeVariable() {
        testSessionInitiator = new TestSessionInitiator(this.getClass().getName());
    }
	
    @Test( priority = 1)
    public void verifyUserGmailAccountLogin(){
        testSessionInitiator.launchApplication();
        testSessionInitiator.gmailLoginPageAction.submitLoginDetails();
        Assert.assertEquals(testSessionInitiator.gmailHomePageAction.getProfileName(), "Welcome, barkha keshwani");
    }
    
    @Test( priority = 2)
    public void verifyFolderCreation() {
        testSessionInitiator.gmailHomePageAction.clickGmailIcon();
    	testSessionInitiator.gmailHomePageAction.clickMore();
    	String verificationMsg = null;
		try {
			verificationMsg = testSessionInitiator.gmailHomePageAction.createNewFolder();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	Assert.assertEquals(verificationMsg, "The label \"citibank\" was created.");
    }
    
    @Test( priority = 3)
    public void movingMailToExistingLabel(){
    	testSessionInitiator.gmailHomePageAction.selectEmailToMoveToLabel();
    	testSessionInitiator.gmailHomePageAction.selectMoveToIcon();
    	String mailMovedVerificationMsg = testSessionInitiator.gmailHomePageAction.selectLabelToWhichMailsAreToBeMoved();
    	Assert.assertEquals(mailMovedVerificationMsg, "The conversation has been moved to \"citibank\".");
    }
    
  @AfterTest
    public void closeBrowser() {
    	testSessionInitiator.closeBrowserSession();
    }
}
