package com.seleniumtests.tests;

import org.testng.annotations.Test;

import com.seleniumtests.core.SeleniumTestPlan;
import com.seleniumtests.dataobject.User;
import com.seleniumtests.util.internal.entity.TestEntity;
import com.seleniumtests.webpage.AdminHomePage;
import com.seleniumtests.webpage.DriveLoginPage;
import com.seleniumtests.webpage.TestLinkLoginPage;

public class TestFirst extends SeleniumTestPlan {
	@Test(groups = "loginAsValidUser")
    public void loginToDrive(final String driveName, final User user) throws Exception {
		/*DriveType driveTypeThis= DriveType.valueOf(driveName.toUpperCase());
		String driveUrl="";
		switch(driveTypeThis){
		case ONEDRIVE:
			driveUrl=ONEDRIVE_PAGE_URL;
		case BOX:
			driveUrl=ONEDRIVE_PAGE_URL;
		case DROPBOX:
			driveUrl=ONEDRIVE_PAGE_URL;
		case GDRIVE:
			driveUrl=ONEDRIVE_PAGE_URL;
		}*/
		
	/*	DriveLoginPage tlp= new DriveLoginPage("onedrive");
    	AdminHomePage ap=  tlp.loginAsValidUser(user);
    	ap.verifyDocumentationDropDown();*/
    }


}
