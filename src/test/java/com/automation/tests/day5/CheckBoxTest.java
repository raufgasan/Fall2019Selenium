package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();


        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(1);

        List<WebElement> check = driver.findElements(By.tagName("input"));

        for (int i = 0; i <check.size() ; i++) {

            if(check.get(i).isSelected()){
                System.out.println("Box "+(i+1)+ " selected");
            }else {
                System.out.println("Box "+(i+1)+ " is not selected");
            }

        }


        driver.quit();

    }
}
