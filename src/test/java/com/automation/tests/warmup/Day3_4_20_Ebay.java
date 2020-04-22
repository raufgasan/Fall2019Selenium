package com.automation.tests.warmup;


import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Day3_4_20_Ebay {
   static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        /*
        Go to ebay
enter search term
click on search button
print number of results
go to amazon
Go to ebay
enter search term
click on search button
verify title contains search term
Go to wikipedia.org
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)`
         */

//        ebayTest();
//        amazonTest();
        wikiTest();


//        WebDriverManager.chromedriver().setup();

//        WebDriver driver = new ChromeDriver();
//
//    driver.get("https://www.ebay.com/");
//    driver.findElement(By.id("gh-ac")).sendKeys("book"+Keys.ENTER);
//    Thread.sleep(5000);
//    WebElement result = driver.findElement(By.className("BOLD"));
//        System.out.println("result.getText() = " + result.getText());
//        driver.quit();


    }

    public static void ebayTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(5000);
        WebElement result = driver.findElement(By.tagName("h1"));
        System.out.println(result.getText().split(" ")[0]);

    driver.quit();
    }
    public static void amazonTest() throws InterruptedException{
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book"+Keys.ENTER);
       String title = driver.getTitle();
        if(title.contains("java book")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }


       WebElement res= driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));

                System.out.println(res.getText());

        driver.quit();
    }
    public static void wikiTest() throws InterruptedException{
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)", Keys.ENTER);
        String url =driver.getCurrentUrl();
        if (url.endsWith("Selenium_(software)")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        driver.quit();
    }

}
