package test.automation.pages;

import org.openqa.selenium.By;

public class SignLoginPage {

    public By registerTitle = By.xpath("//div[@class='signup-form']//h2[contains(text(),'New User Signup!')]");
    public By signInTitle = By.xpath("//div[@class='login-form']//h2[contains(text(),'Login to your account')]");
    public By registerForm = By.xpath("//form[@action='/signup']");
    public By nameInput = By.cssSelector("form[action='/signup'] input[name='name']");
    public By emailInput = By.cssSelector("form[action='/signup'] input[name='email']");
    public By signUpButton = By.cssSelector("form[action='/signup'] button[type='submit']");
    public By enterInfoTitle = By.xpath("//div[@class='login-form']//b[contains(text(),'Enter Account Information')]");
    public By genderMaleRadio = By.id("id_gender1");
    public By genderFemaleRadio = By.id("id_gender2");
    public By passwordInput = By.id("password");
    public By dayDropdown = By.id("days");
    public By monthDropdown = By.id("months");
    public By yearDropdown = By.id("years");
    public By newsletterCheckbox = By.id("newsletter");
    public By offersCheckbox = By.id("optin");
    public By firstNameInput = By.id("first_name");
    public By lastNameInput = By.id("last_name");
    public By addressInput1 = By.id("address1");
    public By addressInput2 = By.id("address2");
    public By countryDropdown = By.id("country");
    public By stateInput = By.id("state");
    public By cityInput = By.id("city");
    public By zipCodeInput = By.id("zipcode");
    public By mobileNumberInput = By.id("mobile_number");
    public By createAccountButton = By.xpath("//button[@type='submit' and contains(text(),'Create Account')]");
    public By successMessage = By.xpath("//b[text()='Account Created!']");
    public By continueButton = By.xpath("//a[text()='Continue']");
    public By signInForm = By.xpath("//form[@action='/login']");
    public By signInEmailInput = By.cssSelector("form[action='/login'] input[name='email']");
    public By signInPassword = By.cssSelector("form[action='/login'] input[name='password']");
    public By signInButton = By.cssSelector("form[action='/login'] button[type='submit']");
    public By signInErrorMessage = By.cssSelector("form[action='/login'] p");
    public By registerErrorMessage = By.cssSelector("form[action='/signup'] p");
}

