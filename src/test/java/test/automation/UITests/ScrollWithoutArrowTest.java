package test.automation.UITests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.steps.UISteps.HomeSteps;

public class ScrollWithoutArrowTest extends BaseTest{
    HomeSteps homeSteps;

    @BeforeMethod
    public void getReady(){
        homeSteps = new HomeSteps(driver);
    }

    @Test
    public void scrollUpWithOutArrow(){
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement subscription = driver.findElement(homePage.subscriptionLabel);
        wait.until(ExpectedConditions.visibilityOf(subscription));

        js.executeScript("window.scrollTo(0, 0)");

        WebElement topText = driver.findElement(homePage.topText);
        wait.until(ExpectedConditions.visibilityOf(topText));
    }

}
