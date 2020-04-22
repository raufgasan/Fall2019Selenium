package com.automation.pages.t2_Fleet;

import com.automation.pages.BasePage;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends BasePage {

    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;


    public void clickToCreateCar(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();

    }

}
