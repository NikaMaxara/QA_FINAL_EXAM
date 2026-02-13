package test.automation.UITests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.data.Constants;
import test.automation.steps.UISteps.DeleteAccountSteps;
import test.automation.steps.UISteps.HomeSteps;
import test.automation.steps.UISteps.SignLoginSteps;

public class UserRegisterTest extends BaseTest {

    HomeSteps homeSteps;
    SignLoginSteps signLoginSteps;
    DeleteAccountSteps deleteAccountSteps;

    @BeforeMethod
    public void getReady() {
        homeSteps = new HomeSteps(driver);
        signLoginSteps = new SignLoginSteps(driver);
        deleteAccountSteps = new DeleteAccountSteps(driver);
    }

    @Test(description = "User should register successfully and then delete the account")
    @Description("Full flow: register a new user and delete the account afterwards")
    public void registerUser() {
        homeSteps.clickLogin();
        signLoginSteps
                .validateRegisterTitle()
                .enterName(Constants.NAME)
                .enterEmail(Constants.EMAIL)
                .clickSignUpButton()
                .verifyEnterAccountInfoVisible()
                .selectGender(Constants.MALE)
                .enterPassword(Constants.PASSWORD)
                .selectDay(Constants.DAY)
                .selectMonth(Constants.MONTH)
                .selectYear(Constants.YEAR)
                .checkNewsletter()
                .checkSpecialOffers()
                .enterFirstName(Constants.FIRST_NAME)
                .enterLastName(Constants.LAST_NAME)
                .enterAddress1(Constants.ADDRESS)
                .enterAddress2(Constants.ADDRESS)
                .selectCountry(Constants.COUNTRY)
                .enterCity(Constants.CITY)
                .enterState(Constants.STATE)
                .enterZipCode(Constants.ZIP_CODE)
                .enterMobileNumber(Constants.MOBILE_NUMBER)
                .clickCreateAccount()
                .validateSuccessRegister()
                .clickContinue();
        homeSteps
                .validateSignIn()
                .clickDeleteAccount();
        deleteAccountSteps
                .validateDeleteAccount()
                .clickContinue();

    }
}
