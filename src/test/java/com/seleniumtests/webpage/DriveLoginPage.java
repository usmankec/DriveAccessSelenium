
package com.seleniumtests.webpage;

import org.openqa.selenium.By;

import com.seleniumtests.core.CustomAssertion;
import com.seleniumtests.dataobject.User;
import com.seleniumtests.webelements.ButtonElement;
import com.seleniumtests.webelements.LinkElement;
import com.seleniumtests.webelements.PageObject;
import com.seleniumtests.webelements.TextFieldElement;

/**
 * Defines service for TestLink login page.
 *
 * <p/>Date: 10/2/13 Time: 6:15 PM
 */
public class DriveLoginPage extends PageObject {
	
	 public enum DriveType {
			ONEDRIVE, BOX, DROPBOX, GDRIVE
		}
    private static final String ONEDRIVE_PAGE_URL = "https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=12&ct=1431424201&rver=6.4.6456.0&wp=MBI_SSL_SHARED&wreply=https:%2F%2Fonedrive.live.com%3Fgologin%3D1%26mkt%3Den-US&lc=1033&id=250206&cbcxt=sky&mkt=en-US";
    private static final String BOX_PAGE_URL = "https://app.box.com/login/";
    private static final String DROPBOX_PAGE_URL = "https://dropbox.com/login/";
    private static final String GDRIVE_PAGE_URL = "https://drive.google.com/drive/my-drive";
    static DriveType driveTypeThis;
   
    // Page identifier field is set to seleniumtests.com as TestLink appears in iframe
    
    private static TextFieldElement oneDriveUserNameTextBox = new TextFieldElement("Login Text Box", By.name(DriveLoginUILocators.userNameOneDrive));
    private TextFieldElement oneDrivePasswordTextBox = new TextFieldElement("Password Te  xt Box", By.name(DriveLoginUILocators.passwordOneDrive));
    private ButtonElement oneDriveLoginButton = new ButtonElement("Login ButtonElement", By.id(DriveLoginUILocators.signInButtonOneDrive));
    
    private static TextFieldElement boxUserNameTextBox = new TextFieldElement("Login Text Box", By.id(DriveLoginUILocators.userNameBox));
    private TextFieldElement boxPasswordTextBox = new TextFieldElement("Password Te  xt Box", By.id(DriveLoginUILocators.passwordBox));
    private ButtonElement boxLoginButton = new ButtonElement("Login ButtonElement", By.id(DriveLoginUILocators.signInButtonBox));
    
    private static TextFieldElement dropboxUserNameTextBox = new TextFieldElement("Login Text Box", By.cssSelector(DriveLoginUILocators.userNameDropBox));
    private TextFieldElement dropboxPasswordTextBox = new TextFieldElement("Password Te  xt Box", By.cssSelector(DriveLoginUILocators.passwordDropBox));
    private ButtonElement dropboxLoginButton = new ButtonElement("Login ButtonElement", By.cssSelector(DriveLoginUILocators.signInButtonDropBox));
    
    private static TextFieldElement gDriveUserNameTextBox = new TextFieldElement("Login Text Box", By.id(DriveLoginUILocators.userNameGDrive));
    private TextFieldElement gDrivePasswordTextBox = new TextFieldElement("Password Te  xt Box", By.id(DriveLoginUILocators.passwordGDrive));
    private ButtonElement gDriveLoginButton = new ButtonElement("Login ButtonElement", By.id(DriveLoginUILocators.signInButtonGDrive));
    
    
    public DriveLoginPage() throws Exception {

        // verifies that loginTextBox appears on loginAsValidUser page else test would not make sense
        //super(loginTextBox);
    }

    /**
     * Opens log in page.
     *
     * @param   openPageUrl
     *
     * @throws  Exception
     */
    
    public static String getDriveUrl(String driveName){
    	System.out.println("Login to Drive: "+driveName);
    	driveTypeThis= DriveType.valueOf(driveName.toUpperCase());
		String driveUrl="";
		switch(driveTypeThis){
		case ONEDRIVE:
			driveUrl=ONEDRIVE_PAGE_URL;
			break;
		case BOX:
			driveUrl=BOX_PAGE_URL;
			break;
		case DROPBOX:
			driveUrl=DROPBOX_PAGE_URL;
			break;
		case GDRIVE:
			driveUrl=GDRIVE_PAGE_URL;
			break;
		}
		return driveUrl;
		
    }
    
    
    
    public DriveLoginPage(final String drivename) throws Exception {
    	super(getDriveUrl(drivename) , true);
    
       
        //getDriver().switchTo().frame(getDriver().findElement(By.id("testlink"))); // Switch to test link frame
    }

  

    /**
     * Logging in with valid credentials direct user to home page.
     *
     * @param   user
     *
     * @return
     *
     * @throws  Exception
     */
    public void loginToDrive(final User user) throws Exception {
        
    	switch (driveTypeThis){
    	
		case ONEDRIVE:
			   System.out.println("One Drive Selected");
			   oneDriveUserNameTextBox.clear();
			   oneDriveUserNameTextBox.sendKeys(user.getUserID());
			   oneDrivePasswordTextBox.clear();
			   oneDrivePasswordTextBox.sendKeys(user.getPassword());
			   oneDriveLoginButton.click();
			   
		/*      driver.findElement(By.name(DriveLoginUILocators.userNameOneDrive)).sendKeys(userName);
		      driver.findElement(By.name(DriveLoginUILocators.passwordOneDrive)).sendKeys(password);
		      driver.findElement(By.id(DriveLoginUILocators.signInButtonOneDrive)).click();*/
		      System.out.println("login Title: "+driver.getTitle());
		      driver.get("https://login.live.com/logout.srf");
		      System.out.println("logout title: "+driver.getTitle());
		      //driver.close();
		   
			break;
				
		case BOX:
		      System.out.println("Box Drive Selected");
		      
		      	boxUserNameTextBox.clear();
			   boxUserNameTextBox.sendKeys(user.getUserID());
			   boxPasswordTextBox.clear();
			   boxPasswordTextBox.sendKeys(user.getPassword());
			   boxLoginButton.click();
		      
		      
		/*	driver.get("https://app.box.com/login/");
			 driver.findElement(By.id(DriveLoginUILocators.userNameBox)).sendKeys(userName);
		      driver.findElement(By.id(DriveLoginUILocators.passwordBox)).sendKeys(password);
		      driver.findElement(By.id(DriveLoginUILocators.signInButtonBox)).click();*/
		      System.out.println("login Title: "+driver.getTitle());
		      driver.get("https://app.box.com/logout/");
		      System.out.println("logout title: "+driver.getTitle());
			System.out.println("Box Selected");
			//  driver.close();
		break;
				
		case DROPBOX:
		      System.out.println("Drop box Drive Selected");
		      
		      dropboxUserNameTextBox.clear();
			   dropboxUserNameTextBox.sendKeys(user.getUserID());
			   dropboxPasswordTextBox.clear();
			   dropboxPasswordTextBox.sendKeys(user.getPassword());
			   dropboxLoginButton.click();
		      
		      
		      
		      Thread.sleep(8000);
		
			//driver.findElement(By.id("sign-in")).click();
			/* driver.findElement(By.cssSelector(DriveLoginUILocators.userNameDropBox)).sendKeys(userName);
		      driver.findElement(By.cssSelector(DriveLoginUILocators.passwordDropBox)).sendKeys(password);
		      driver.findElement(By.cssSelector(DriveLoginUILocators.signInButtonDropBox)).click();*/
		      System.out.println("login Title: "+driver.getTitle());
		      driver.get("https://www.dropbox.com/logout");
		      System.out.println("logout title: "+driver.getTitle());
		      //driver.close();
			break;
		case GDRIVE:
		      System.out.println("G Drive Selected");
		      
		      gDriveUserNameTextBox.clear();
			   gDriveUserNameTextBox.sendKeys(user.getUserID());
			   gDrivePasswordTextBox.clear();
			   gDrivePasswordTextBox.sendKeys(user.getPassword());
			   gDriveLoginButton.click();
			   
		      
		  /*    
			 driver.findElement(By.id(DriveLoginUILocators.userNameGDrive)).sendKeys(userName);
		      driver.findElement(By.id(DriveLoginUILocators.passwordGDrive)).sendKeys(password);
		      driver.findElement(By.id(DriveLoginUILocators.signInButtonGDrive)).click();*/
			      System.out.println("login Title: "+driver.getTitle());
			      driver.get("https://accounts.google.com/Logout?service=wise");
			      System.out.println("logout title: "+driver.getTitle());
			
			 // driver.close();
		break;
		
		}
    	
    	
    	
    	
    	
    	
    	
    	/*loginTextBox.clear();
        loginTextBox.sendKeys(user.getUserID());
        passwordTextBox.clear();
        passwordTextBox.sendKeys(user.getPassword());
        loginButton.submit();
        return new AdminHomePage();*/
    }

    /**
     * Logging in with invalid credentials keeps user on login page.
     *
     * @param   user
     *
     * @return
     *
     * @throws  Exception
     */
    public DriveLoginPage loginAsInvalidUser(final User user) throws Exception {
     /*   loginTextBox.clear();
        loginTextBox.sendKeys(user.getUserID());
        passwordTextBox.clear();
        passwordTextBox.sendKeys(user.getPassword());
        loginButton.submit();
        getDriver().switchTo().defaultContent();*/
        return this;
    }

    public DriveLoginPage verifyLoginBoxPresence() {
        getDriver().switchTo().frame(getDriver().findElement(By.id("testlink")));
        /*CustomAssertion.assertTrue(isElementPresent(loginTextBox.getBy()),
            "Invalid credentials don't block user from logging in");*/
        return this;
    }
}
