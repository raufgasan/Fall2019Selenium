package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);


        driver.findElement(By.id("dropdownMenuLink")).click();

        List<WebElement> links = driver.findElements(By.className("dropdown-item"));

        for (WebElement each:links ) {
            System.out.println(each.getText()+" : "+each.getAttribute("href"));
        }


        driver.findElement(By.linkText("Amazon")).click();



        BrowserUtils.wait(2);
        driver.quit();
    }
}
