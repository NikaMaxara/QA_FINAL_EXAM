package test.automation.UITests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.data.Constants;
import test.automation.steps.UISteps.HomeSteps;

public class VerifySubscriptionTest extends BaseTest{

    HomeSteps homeSteps;

    @BeforeMethod
    public void getReady(){
        homeSteps = new HomeSteps(driver);
    }

    @Test
    public void verifySubscription(){
        WebElement subscription = driver.findElement(homePage.subscriptionLabel);
        wait.until(ExpectedConditions.visibilityOf(subscription));

        homeSteps
                .enterSubscribeEmail(Constants.SIGN_IN_EMAIL)
                .clickSubscribeButton();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(homePage.subscriptionSuccessMessage)));
        String message = driver.findElement(homePage.subscriptionSuccessMessage).getText();
        Assert.assertEquals(Constants.SUBSCRIPTION_SUCCESS_MESSAGE,message);
    }
}
