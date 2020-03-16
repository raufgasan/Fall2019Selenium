package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestForiFrame {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(1);

        driver.switchTo().frame("mce_0_ifr");
        BrowserUtils.wait(1);
       WebElement textInput = driver.findElement(By.id("tinymce"));
        BrowserUtils.wait(1);
        System.out.println(textInput.getText());
        BrowserUtils.wait(1);

        textInput.clear();
        textInput.sendKeys("Hellow bro");


        driver.switchTo().defaultContent();

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());
        BrowserUtils.wait(1);

        driver.quit();

    }
}
