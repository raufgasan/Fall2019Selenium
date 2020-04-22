package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectBytextMultipleOptions {
    public static void main(String[] args) {


        WebDriver driver =  DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);


        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("C#");
        languagesSelect.selectByVisibleText("Python");

        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();
        for (WebElement selectedlanguage:selectedLanguages ) {
            System.out.println(selectedlanguage.getText());
        }

        languagesSelect.deselectByVisibleText("Java");

        BrowserUtils.wait(3);
        driver.quit();
    }
}
