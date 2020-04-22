package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();

        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());



        driver.findElement(By.xpath("//button[starts-with(@id,'button_')]")).click();
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());


        BrowserUtils.wait(2);
        driver.quit();
    }
}
