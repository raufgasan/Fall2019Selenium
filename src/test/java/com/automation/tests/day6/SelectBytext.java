package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.DriverManager;
import java.util.List;

public class SelectBytext {
    public static void main(String[] args) {


        WebDriver driver =  DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select sYear= new Select(driver.findElement(By.id("year")));
        Select sMonth= new Select(driver.findElement(By.id("month")));
        Select sDay= new Select(driver.findElement(By.id("day")));



        List<WebElement> month = sMonth.getOptions();
        List<WebElement> day = sDay.getOptions();
        List<WebElement> year = sYear.getOptions();



        sYear.selectByVisibleText("2020");
        sMonth.selectByVisibleText("May");
        sDay.selectByVisibleText("16");

        for (WebElement eachMonth:month ) {

            String months = eachMonth.getText();
            sMonth.selectByVisibleText(months);


            }


        BrowserUtils.wait(2);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Washington");

        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equals("Washington")){
            System.out.println("test pass");
        }else{
            System.out.println("test failed");
        }


        BrowserUtils.wait(2);


        List<WebElement> states = stateSelect.getOptions();
        for (WebElement each:states) {
            System.out.println(each.getText());
        }

        driver.quit();
    }
}
