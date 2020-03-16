package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        driver.findElement(By.name("firstname")).sendKeys("Ruaf");

        driver.findElement(By.name("lastname")).sendKeys("Gasan");

        driver.findElement(By.name("reg_email__")).sendKeys("Gasan@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("Gasan@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("Gasan@gmail.com");
       
        Thread.sleep(2000);

        driver.findElement(By.id("u_0_6")).click();
        driver.findElement(By.id("u_0_13")).click();
        Thread.sleep(2000);
        driver.findElement(By.className  ("_42ft _4jy0 layerConfirm _2rsa uiOverlayButton _4jy3 _4jy1 selected _51sy")).submit();






    }
}
