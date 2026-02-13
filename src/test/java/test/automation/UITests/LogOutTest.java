package test.automation.UITests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.data.Constants;
import test.automation.pages.SignLoginPage;
import test.automation.steps.UISteps.DeleteAccountSteps;
import test.automation.steps.UISteps.HomeSteps;
import test.automation.steps.UISteps.SignLoginSteps;

public class LogOutTest extends BaseTest{
    HomeSteps homeSteps;
    SignLoginPage signLoginPage;
    SignLoginSteps signLoginSteps;
    DeleteAccountSteps deleteAccountSteps;

    @BeforeMethod
    public void getReady() {
        homeSteps = new HomeSteps(driver);
        signLoginPage = new SignLoginPage();
        signLoginSteps = new SignLoginSteps(driver);
        deleteAccountSteps = new DeleteAccountSteps(driver);
    }

    @Test(description = "Sign in user")
    public void enterSignInCredentials() {
        homeSteps.clickLogin();
        signLoginSteps
                .validateSignInTitle()
                .enterSignInPassword(Constants.SIGN_IN_PASSWORD)
                .enterSignInEmail(Constants.SIGN_IN_EMAIL)
                .clickSignInButton();
        homeSteps
                .clickLogOut();

        boolean isGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(homePage.logOut));

        Assert.assertTrue(isGone, "Log Out button should NOT be visible");
    }
}
