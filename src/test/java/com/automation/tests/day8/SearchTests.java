package com.automation.tests.day8;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTests {

    private WebDriver driver;



    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java"+ Keys.ENTER);
       List<WebElement> lst = driver.findElements(By.tagName("h3"));
        for (WebElement each:lst ) {
            String var = each.getText();

            if(!var.isEmpty()){
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }

        }





    }






    @BeforeMethod
    public void setup(){
        //setup webdriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();
    }



    @Test (description = "Search for Java book on amazon")
    public void amazonSearchTest(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+Keys.ENTER);
       List<WebElement>lst= driver.findElements(By.tagName("h2"));
       lst.get(0).click();
        System.out.println(driver.findElement(By.id("title")).getText());


    }









}
