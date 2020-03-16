package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NestedFrame {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(1);

         driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frameset-middle");

        WebElement content = driver.findElement(By.id("content"));

        System.out.println(content.getText());

        driver.switchTo().parentFrame();

        driver.quit();
    }
}
