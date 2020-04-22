package com.automation.tests.day8;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practicetests {
    private WebDriver driver;



    @BeforeMethod
    public void beforeM(){

       driver = DriverFactory.createDriver("chrome");
     driver.get("http://practice.cybertekschool.com/");
    }

    @AfterMethod
    public void afterM(){
    driver.quit();

    }


    @Test
    public void loginTest(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("http://practice.cybertekschool.com/login");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword"+ Keys.ENTER);
         Assert.assertEquals(driver.findElement(By.className("subheader")).getText(),"Welcome to the Secure Area. When you are done click logout below.");

    }



    @Test
    public void forgotPassword(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("asdf@gmail.com"+Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(), "Your e-mail's been sent!","Test failed");


    }


    @Test
    public void checkboxes(){
        driver.navigate().to("http://practice.cybertekschool.com/checkboxes");
        driver.findElements(By.xpath("//input[@type='checkbox']")).get(0).click();
        Assert.assertTrue(driver.findElements(By.xpath("//input[@type='checkbox']")).get(0).isSelected(), "Test Failed");


    }


}
