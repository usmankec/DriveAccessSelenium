
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
public class TestLinkLoginPage extends PageObject {

    private static final String PAGE_URL = "https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=12&ct=1431424201&rver=6.4.6456.0&wp=MBI_SSL_SHARED&wreply=https:%2F%2Fonedrive.live.com%3Fgologin%3D1%26mkt%3Den-US&lc=1033&id=250206&cbcxt=sky&mkt=en-US";

    // Page identifier field is set to seleniumtests.com as TestLink appears in iframe
    private static LinkElement seleniumTrainingLink = new LinkElement("Selenium Training LinkElement",
            By.linkText("Free Selenium Training"));
    private static TextFieldElement loginTextBox = new TextFieldElement("Login Text Box", By.id("login"));

    public TestLinkLoginPage() throws Exception {

        // verifies that loginTextBox appears on loginAsValidUser page else test would not make sense
        super(loginTextBox);
    }

    /**
     * Opens log in page.
     *
     * @param   openPageUrl
     *
     * @throws  Exception
     */
    
    public enum DriveType {
		ONEDRIVE, BOX, DROPBOX, GDRIVE
	}
    
    public TestLinkLoginPage(final boolean openPageUrl) throws Exception {
    	 super( openPageUrl ? PAGE_URL : null, true);
    
       
        //getDriver().switchTo().frame(getDriver().findElement(By.id("testlink"))); // Switch to test link frame
    }

    private TextFieldElement passwordTextBox = new TextFieldElement("Password Te  xt Box", By.name("tl_password"));
    private ButtonElement loginButton = new ButtonElement("Login ButtonElement", By.name("login_submit"));

    /**
     * Logging in with valid credentials direct user to home page.
     *
     * @param   user
     *
     * @return
     *
     * @throws  Exception
     */
    public AdminHomePage loginAsValidUser(final User user) throws Exception {
        loginTextBox.clear();
        loginTextBox.sendKeys(user.getUserID());
        passwordTextBox.clear();
        passwordTextBox.sendKeys(user.getPassword());
        loginButton.submit();
        return new AdminHomePage();
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
    public TestLinkLoginPage loginAsInvalidUser(final User user) throws Exception {
        loginTextBox.clear();
        loginTextBox.sendKeys(user.getUserID());
        passwordTextBox.clear();
        passwordTextBox.sendKeys(user.getPassword());
        loginButton.submit();
        getDriver().switchTo().defaultContent();
        return this;
    }

    public TestLinkLoginPage verifyLoginBoxPresence() {
        getDriver().switchTo().frame(getDriver().findElement(By.id("testlink")));
        CustomAssertion.assertTrue(isElementPresent(loginTextBox.getBy()),
            "Invalid credentials don't block user from logging in");
        return this;
    }
}
