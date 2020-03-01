package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);
        //getWindowHandles() - returns id's of all currently opened windows
        //Set - doesn't allow duplicates

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);
        System.out.println("Before switch : "+ driver.getCurrentUrl());
        //since we have all windows
        //and we know id of original window
        //we can say switch to something that is not equals to old window id

        for (String windowId: windowHandles){
            if(!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }
        }


        System.out.println("After switch : "+ driver.getCurrentUrl());

        driver.close();

    }
}
