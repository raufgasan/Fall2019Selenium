package com.automation.pages.t5_Activities;

import com.automation.pages.BasePage;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CallsPage extends BasePage {

    @FindBy (css="[title='Log call']")
    private WebElement createLogCall;

    public void clickToLogCall(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createLogCall)).click();
    }
}
