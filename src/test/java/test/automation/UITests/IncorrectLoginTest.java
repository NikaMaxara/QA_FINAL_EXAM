package test.automation.UITests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.data.Constants;
import test.automation.pages.SignLoginPage;
import test.automation.steps.UISteps.HomeSteps;
import test.automation.steps.UISteps.SignLoginSteps;

public class IncorrectLoginTest extends BaseTest{
    HomeSteps homeSteps;
    SignLoginPage signLoginPage;
    SignLoginSteps signLoginSteps;
    Faker faker;

    @BeforeMethod
    public void getReady(){
        homeSteps = new HomeSteps(driver);
        signLoginPage = new SignLoginPage();
        signLoginSteps = new SignLoginSteps(driver);
        faker = new Faker();
    }

    @Test(description = "User should not login successfully beacause of invalid credentials")
    public void successLogin(){
        homeSteps.clickLogin();
        signLoginSteps
                .validateSignInTitle()
                .enterSignInEmail(faker.internet().emailAddress())
                .enterSignInPassword(faker.internet().password(8, 12, true, true))
                .clickSignInButton();
        Assert.assertEquals(Constants.INVALID_LOGIN_ERROR,driver.findElement(signLoginPage.signInErrorMessage).getText());
    }
}
