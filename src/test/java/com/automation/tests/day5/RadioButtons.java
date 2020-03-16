package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().fullscreen();
        BrowserUtils.wait(2);
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement eachButton: radioButtons ) {
            boolean isSelected = eachButton.isSelected();
            System.out.println(eachButton.getAttribute("id")+" selected :"+isSelected);
            if (eachButton.isEnabled()){
            eachButton.click();
                System.out.println("Clicked on :: "+ eachButton.getAttribute("id"));
            BrowserUtils.wait(1);
            }else {
                System.out.println("Button is disabled, not clicked :: "+ eachButton.getAttribute("id"));
            }
            boolean isSelectedafter = eachButton.isSelected();
            System.out.println(eachButton.getAttribute("id")+" selected :"+isSelectedafter);

            System.out.println("=======================================");
        }




        driver.close();



    }
}
