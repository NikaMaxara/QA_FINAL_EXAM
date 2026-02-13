package test.automation.UITests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.data.Constants;
import test.automation.pages.SignLoginPage;
import test.automation.steps.UISteps.DeleteAccountSteps;
import test.automation.steps.UISteps.HomeSteps;
import test.automation.steps.UISteps.SignLoginSteps;

public class LoginExistingEmailTest extends BaseTest{
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
    public void enterRegisterCredentials() {
        homeSteps.clickLogin();
        signLoginSteps
                .validateRegisterTitle()
                .enterName(Constants.NAME)
                .enterEmail(Constants.SIGN_IN_EMAIL)
                .clickSignUpButton();

        Assert.assertEquals(Constants.REGISTER_ERROR, driver.findElement(signLoginPage.registerErrorMessage).getText());
    }


}
