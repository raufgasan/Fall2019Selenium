package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.tests.vytrack.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTests extends TestBase {




    /**
     * Login and verify that page title is a "Dashboard"
     * 5 minutes
     */
    @Test
    public void verifyPageTitle(){
        //test --> ExtentTest object
        //we must add to every test at the beginning
        //test = report.createTest("Test name");
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals( Driver.getDriver().getTitle(), "Dashboard");
        //if assertion passed, it will set test status in report to passed
        test.pass("Page title Dashboard was verified");

    }

    /**
     * Enter wrong credentials and verify warning message
     *
     */

    @Test
    public void verifyWarningMessage(){
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        BrowserUtils.getScreenshot("verifyWarningMessage");

    }

    @DataProvider
    public Object[][] credentials(){
        return new Object[][]{
                {"storemanager85", "UserUser123"},
                {"salesmanager110", "UserUser123"},
                {"user16", "UserUser123"}
        };
    }

    @Test(dataProvider = "credentials")
    public void loginWithDDT(String userName,String password){
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName,password);
        test.info("Login as : "+userName);
        BrowserUtils.wait(1);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");
    }


}
