package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"disappearing_button\"]")).click();
        Thread.sleep(2000);

        if (driver.findElements(By.xpath("//*[@id=\"disappearing_button\"]")).size()==0){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (WebElement each: buttons ) {
            each.click();
        }


        driver.quit();



    }
}
