package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectedByValue {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("WA");

        String expected = "Washington";
        String actual = stateSelect.getFirstSelectedOption().getText();

        if(expected.equals(actual)){
            System.out.println("test pass");
        }else{
            System.out.println("test failed");
        }


        BrowserUtils.wait(2);
        driver.quit();
    }
}
