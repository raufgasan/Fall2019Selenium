package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadiobuttonsTest {
    public static void main(String[] args) {

    WebDriver driver = DriverFactory.createDriver("chrom");
    driver.get("http://practice.cybertekschool.com/radio_buttons");
    BrowserUtils.wait(1);

        WebElement blackButton = driver.findElement(By.id("black"));

        if(blackButton.isDisplayed()&&blackButton.isEnabled()){
            blackButton.click();
        }else {
            System.out.println("Failes to click on black button");
        }

        if(blackButton.isSelected()){
            System.out.println("Test Passed!");
        }else {
            System.out.println("Test Failed");
        }

    }
}
