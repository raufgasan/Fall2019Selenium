package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {



    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 15);


    @FindBy(css = "#user-menu > a")
    protected WebElement currentUser;


    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }



    /**
     *
     * @param tabName
     * @param moduleName
     */
    public void navigateTo(String tabName, String moduleName){

//        tabName=tabName.substring(0,1).toUpperCase()+tabName.substring(1 ).toLowerCase();
//        moduleName=moduleName.substring(0,1).toUpperCase()+moduleName.substring(1 ).toLowerCase();
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
        String moduleXpath = "//span[@class='title title-level-2' and contains(text(),'"+moduleName+"')]";

        Actions actions = new Actions(driver);

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        BrowserUtils.wait(3);
        actions.moveToElement(tabElement).
                pause(1000).
                click(moduleElement).
                build().perform();
        BrowserUtils.wait(10);
    }




}
