package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.t5_Activities.CalendarEvents;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalendarEventsTests {



    @Test
    public void defaultOptionsTest() {
        LoginPage loginPage = new LoginPage();
        CalendarEvents calendarEvents = new CalendarEvents();


        loginPage.login();

        calendarEvents.navigateTo("activities", "calendar events");
        calendarEvents.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEvents, calendarEvents.getCurrentUserName());


    }


}
