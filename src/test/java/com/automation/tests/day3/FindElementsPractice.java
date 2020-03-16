package com.automation.tests.day3;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriver drive = DriverFactory.createDriver("chrom");
        drive.get("http://practice.cybertekschool.com/sign_up");
        Thread.sleep(2000);

        WebElement fullName = drive.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");
        Thread.sleep(2000);

        WebElement email = drive.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");
        Thread.sleep(2000);

        WebElement signUp = drive.findElement(By.name("wooden_spoon"));
        signUp.click(); //signUp.submit(); optional
        Thread.sleep(2000);

       String expected = "Thank you for signing up. Click the button below to return to the home page.";
       WebElement message = drive.findElement(By.className("subheader"));
        String actual = message.getText();
        Thread.sleep(6000);

        if (actual.equals(expected)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        drive.quit();



    }
}
