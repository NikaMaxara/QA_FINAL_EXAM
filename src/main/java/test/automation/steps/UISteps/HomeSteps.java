package test.automation.steps.UISteps;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.automation.pages.HomePage;

import java.time.Duration;

public class HomeSteps {

    private WebDriver driver;
    private HomePage homePage;

    public HomeSteps(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage();
    }

    @Step("Click on Login option")
    public HomeSteps clickLogin() {
        driver.findElement(homePage.loginOption).click();
        return this;
    }

    @Step("Validate that user is signed in")
    public HomeSteps validateSignIn() {
        WebElement loggedInElem = driver.findElement(homePage.loggedInAs);
        Assert.assertTrue(loggedInElem.isDisplayed(), "User should be signed in");
        return this;
    }

    @Step("Click on Delete Account button")
    public HomeSteps clickDeleteAccount() {
        driver.findElement(homePage.deleteAccount).click();
        return this;
    }

    @Step("Click on Log Out button")
    public HomeSteps clickLogOut() {
        driver.findElement(homePage.logOut).click();
        return this;
    }

    @Step("Click on Contact Us link")
    public HomeSteps clickContactUs() {
        driver.findElement(homePage.contactUs).click();
        return this;
    }

    @Step("Open Test cases Page")
    public HomeSteps openTestCasePage(){
        driver.findElement(homePage.testCaseButton).click();
        return this;
    }

    @Step("Click Scroll Up Button")
    public HomeSteps clickScrollUpButton(){
        driver.findElement(homePage.scrollUpButton).click();
        return this;
    }

    @Step("Enter email '{email}' into subscription field")
    public HomeSteps enterSubscribeEmail(String email) {
       driver.findElement( homePage.subscribeEmailInput).sendKeys(email);
        return this;
    }

    @Step("Click on Subscribe button")
    public HomeSteps clickSubscribeButton() {
        driver.findElement(homePage.subscribeButton).click();
        return this;
    }

}

