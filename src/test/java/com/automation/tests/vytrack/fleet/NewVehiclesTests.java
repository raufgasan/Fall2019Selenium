package com.automation.tests.vytrack.fleet;

import com.automation.pages.BasePage;
import com.automation.pages.LoginPage;
import com.automation.pages.t2_Fleet.VehiclesPage;
import com.automation.tests.vytrack.TestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclesTests extends TestBase {

    @Test
    public void verifyTitle(){
        LoginPage loginPage = new LoginPage();
        BasePage vehiclesPage = new VehiclesPage();

        loginPage.login();
        vehiclesPage.navigateTo("Fleet", "Vehicles");

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTittle =  Driver.getDriver().getTitle();

        Assert.assertEquals(actualTittle, expectedTitle);

    }

}
