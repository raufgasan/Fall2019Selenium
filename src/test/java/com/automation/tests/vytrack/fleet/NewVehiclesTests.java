package com.automation.tests.vytrack.fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.t2_Fleet.VehiclesPage;
import com.automation.tests.vytrack.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclesPageTests extends TestBase {

    @Test
    public void verifyTitle(){
        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();

        loginPage.login();
        vehiclesPage.navigateTo("fleet", "VehIcles");

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTittle = driver.getTitle();

        Assert.assertEquals(actualTittle, expectedTitle);

    }

}
