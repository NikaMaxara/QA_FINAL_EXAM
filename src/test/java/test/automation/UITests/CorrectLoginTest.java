package test.automation.UITests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.data.Constants;
import test.automation.steps.UISteps.DeleteAccountSteps;
import test.automation.steps.UISteps.HomeSteps;
import test.automation.steps.UISteps.SignLoginSteps;


public class CorrectLoginTest extends BaseTest{
    HomeSteps homeSteps;
    SignLoginSteps signLoginSteps;
    DeleteAccountSteps deleteAccountSteps;

    @BeforeMethod
    public void getReady(){
        homeSteps = new HomeSteps(driver);
        signLoginSteps = new SignLoginSteps(driver);
        deleteAccountSteps = new DeleteAccountSteps(driver);
    }


    @Test(description = "User should login successfully and delete account")
    public void successLogin(){
        homeSteps.clickLogin();
        signLoginSteps
                .validateSignInTitle()
                .enterSignInEmail(Constants.SIGN_IN_EMAIL)
                .enterSignInPassword(Constants.SIGN_IN_PASSWORD)
                .clickSignInButton();
        homeSteps
                .validateSignIn()
                .clickDeleteAccount();
        deleteAccountSteps
                .validateDeleteAccount();
    }
}