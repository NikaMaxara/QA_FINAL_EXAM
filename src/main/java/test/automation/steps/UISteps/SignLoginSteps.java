package test.automation.steps.UISteps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.automation.pages.SignLoginPage;

public class SignLoginSteps {

    private WebDriver driver;
    private SignLoginPage signLoginPage;

    public SignLoginSteps(WebDriver driver) {
        this.driver = driver;
        this.signLoginPage = new SignLoginPage();
    }

    private void scrollTo(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    private void click(By locator) {
        scrollTo(locator);
        driver.findElement(locator).click();
    }

    private void sendKeys(By locator, String text) {
        scrollTo(locator);
        driver.findElement(locator).sendKeys(text);
    }

    @Step("Validate that the Register title is visible")
    public SignLoginSteps validateRegisterTitle() {
        scrollTo(signLoginPage.registerTitle);
        Assert.assertTrue(driver.findElement(signLoginPage.registerTitle).isDisplayed());
        return this;
    }

    @Step("Enter Name: {name}")
    public SignLoginSteps enterName(String name) {
        sendKeys(signLoginPage.nameInput, name);
        return this;
    }

    @Step("Enter Email: {email}")
    public SignLoginSteps enterEmail(String email) {
        sendKeys(signLoginPage.emailInput, email);
        return this;
    }

    @Step("Click on Sign Up button")
    public SignLoginSteps clickSignUpButton() {
        click(signLoginPage.signUpButton);
        return this;
    }

    @Step("Verify 'Enter Account Information' section is visible")
    public SignLoginSteps verifyEnterAccountInfoVisible() {
        scrollTo(signLoginPage.enterInfoTitle);
        Assert.assertTrue(driver.findElement(signLoginPage.enterInfoTitle).isDisplayed());
        return this;
    }

    @Step("Select Gender: {gender}")
    public SignLoginSteps selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            click(signLoginPage.genderMaleRadio);
        } else if (gender.equalsIgnoreCase("female")) {
            click(signLoginPage.genderFemaleRadio);
        }
        return this;
    }

    @Step("Enter Password: {password}")
    public SignLoginSteps enterPassword(String password) {
        sendKeys(signLoginPage.passwordInput, password);
        return this;
    }

    @Step("Select Day: {day}")
    public SignLoginSteps selectDay(String day) {
        sendKeys(signLoginPage.dayDropdown, day);
        return this;
    }

    @Step("Select Month: {month}")
    public SignLoginSteps selectMonth(String month) {
        sendKeys(signLoginPage.monthDropdown, month);
        return this;
    }

    @Step("Select Year: {year}")
    public SignLoginSteps selectYear(String year) {
        sendKeys(signLoginPage.yearDropdown, year);
        return this;
    }

    @Step("Check Newsletter subscription")
    public SignLoginSteps checkNewsletter() {
        scrollTo(signLoginPage.newsletterCheckbox);
        WebElement elem = driver.findElement(signLoginPage.newsletterCheckbox);
        if (!elem.isSelected()) elem.click();
        return this;
    }

    @Step("Check Special Offers subscription")
    public SignLoginSteps checkSpecialOffers() {
        scrollTo(signLoginPage.offersCheckbox);
        WebElement elem = driver.findElement(signLoginPage.offersCheckbox);
        if (!elem.isSelected()) elem.click();
        return this;
    }

    @Step("Enter First Name: {firstName}")
    public SignLoginSteps enterFirstName(String firstName) {
        sendKeys(signLoginPage.firstNameInput, firstName);
        return this;
    }

    @Step("Enter Last Name: {lastName}")
    public SignLoginSteps enterLastName(String lastName) {
        sendKeys(signLoginPage.lastNameInput, lastName);
        return this;
    }

    @Step("Enter Address 1: {address}")
    public SignLoginSteps enterAddress1(String address) {
        sendKeys(signLoginPage.addressInput1, address);
        return this;
    }

    @Step("Enter Address 2: {address}")
    public SignLoginSteps enterAddress2(String address) {
        sendKeys(signLoginPage.addressInput2, address);
        return this;
    }

    @Step("Enter City: {city}")
    public SignLoginSteps enterCity(String city) {
        sendKeys(signLoginPage.cityInput, city);
        return this;
    }

    @Step("Enter State: {state}")
    public SignLoginSteps enterState(String state) {
        sendKeys(signLoginPage.stateInput, state);
        return this;
    }

    @Step("Enter Zip Code: {zip}")
    public SignLoginSteps enterZipCode(String zip) {
        sendKeys(signLoginPage.zipCodeInput, zip);
        return this;
    }

    @Step("Enter Mobile Number: {mobile}")
    public SignLoginSteps enterMobileNumber(String mobile) {
        sendKeys(signLoginPage.mobileNumberInput, mobile);
        return this;
    }

    @Step("Select Country: {country}")
    public SignLoginSteps selectCountry(String country) {
        sendKeys(signLoginPage.countryDropdown, country);
        return this;
    }

    @Step("Click on Create Account button")
    public SignLoginSteps clickCreateAccount() {
        click(signLoginPage.createAccountButton);
        return this;
    }

    @Step("Validate successful registration message is visible")
    public SignLoginSteps validateSuccessRegister() {
        scrollTo(signLoginPage.successMessage);
        Assert.assertTrue(driver.findElement(signLoginPage.successMessage).isDisplayed());
        return this;
    }

    @Step("Click Continue button")
    public SignLoginSteps clickContinue() {
        click(signLoginPage.continueButton);
        return this;
    }

    @Step("Validate Sign In title is visible")
    public SignLoginSteps validateSignInTitle() {
        scrollTo(signLoginPage.signInTitle);
        Assert.assertTrue(driver.findElement(signLoginPage.signInTitle).isDisplayed());
        return this;
    }

    @Step("Enter Sign In Email: {email}")
    public SignLoginSteps enterSignInEmail(String email) {
        sendKeys(signLoginPage.signInEmailInput, email);
        return this;
    }

    @Step("Enter Sign In Password: {password}")
    public SignLoginSteps enterSignInPassword(String password) {
        sendKeys(signLoginPage.signInPassword, password);
        return this;
    }

    @Step("Click on Sign In button")
    public SignLoginSteps clickSignInButton() {
        click(signLoginPage.signInButton);
        return this;
    }
}
