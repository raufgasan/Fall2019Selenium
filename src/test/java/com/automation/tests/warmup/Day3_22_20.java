package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day3_22_20 {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        BrowserUtils.wait(1);
    }




    @Test
    public void sortTest(){
        driver.findElement(By.xpath("//table[1]//th[1]")).click();
        List<WebElement>lst = driver.findElements(By.xpath("//table[1]//tr//td[1]"));

        BrowserUtils.wait(1);
        for (int i = 0; i <lst.size()-1 ; i++) {

            String value = lst.get(i).getText();
            String nextValue = lst.get(i+1).getText();
            System.out.println(nextValue);

            Assert.assertTrue(value.compareTo(nextValue)<=0);

        }

    }


    @AfterMethod
    public void terndown(){
        driver.quit();
    }
}
