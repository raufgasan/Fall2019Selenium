package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFor {
    private WebDriver driver;

    @BeforeMethod
    public void beforeM(){

        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void afterM(){
        driver.quit();

    }

    @Test
    public void car(){

        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("store_manager"));
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.wait(5);
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'"+"Fleet"+"')]";
        String moduleXpath = "//span[@class='title title-level-2' and contains(text(),'"+"Vehicles"+"')]";

        Actions actions = new Actions(driver);

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        BrowserUtils.wait(3);
        actions.moveToElement(tabElement).
                pause(1000).
                click(moduleElement).
                build().perform();
        BrowserUtils.wait(10);

        driver.findElement(By.partialLinkText("Create Car") ).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();



    }

}
