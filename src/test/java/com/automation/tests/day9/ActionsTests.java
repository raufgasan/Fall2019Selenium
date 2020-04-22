package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private By firstimgBy = By.xpath("(//img)[1]");
    private By secondimgBy = By.xpath("(//img)[2]");
    private By therdimgBy = By.xpath("(//img)[3]");


    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        actions = new Actions(driver);

    }


    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);
        WebElement img1 = driver.findElement(firstimgBy);
        WebElement img2 = driver.findElement(secondimgBy);
        WebElement img3 = driver.findElement(therdimgBy);

        actions.moveToElement(img1).perform();  // when we use only one action we do not need build
        actions.moveToElement(img1).pause(1000).moveToElement(img2).moveToElement(img3).build().perform();// we use build when we call more than one action

        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgText1.isDisplayed() );

       actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed() );

        actions.moveToElement(img3).perform();
        WebElement imgText3 = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(imgText3.isDisplayed() );

    }




    @Test
    public void jqueryMenutest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        BrowserUtils.wait(3);
        WebElement enable = driver.findElement(By.id("ui-id-3"));
        WebElement download = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));


        actions.moveToElement(enable).pause(1000).moveToElement(download).pause(1000).click(pdf).build().perform();

        BrowserUtils.wait(3);


    }

    @Test

    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = drag.findElement(By.xpath("//div[@id='droptarget']"));
        BrowserUtils.wait(2);

        actions.dragAndDrop(drag, drop).perform();
        BrowserUtils.wait(2);

        String expected = "You did great!";
        String actual = drop.getText();

        Assert.assertEquals(expected, actual);

    }


    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
