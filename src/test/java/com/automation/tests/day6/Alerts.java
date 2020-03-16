package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();
        BrowserUtils.wait(2);
        String text = driver.switchTo().alert().getText();
        System.out.println(text);
        driver.switchTo().alert().accept();
        BrowserUtils.wait(2);

        String actual = driver.findElement(By.id("result")).getText();
        String expected = "You successfuly clicked an alert";

        if (expected.equals(actual)){
            System.out.println("test pass");
        }else {
            System.out.println("test failed");
        }

        buttons.get(1).click();
        String text1 = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        BrowserUtils.wait(2);

        String actual1 = driver.findElement(By.id("result")).getText();
        String expected1 = "You clicked: Cancel";

        if (expected1.equals(actual1)){
            System.out.println("test pass");
        }else {
            System.out.println("test failed");
        }






        buttons.get(2).click();
        String text2 = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("rauf");
        driver.switchTo().alert().accept();
        BrowserUtils.wait(2);

        String actual2 = driver.findElement(By.id("result")).getText();
        String expected2 = "You entered: rauf";

        if (expected2.equals(actual2)){
            System.out.println("test pass");
        }else {
            System.out.println("test failed");
        }







        BrowserUtils.wait(2);
        driver.quit();
    }
}
