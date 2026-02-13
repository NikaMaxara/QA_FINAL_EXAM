package test.automation.pages;

import org.openqa.selenium.By;
import test.automation.data.Constants;

public class HomePage {

    public By siteLogo = By.xpath("//header//div[contains(@class,'logo')]");
    public By loginOption = By.xpath("//header[@id='header']//a[@href='/login']");
    public By loggedInAs = By.xpath("//header[@id='header']//a[contains(.,'Logged in as " + Constants.FIRST_NAME + "')]");
    public By deleteAccount = By.xpath("//header[@id='header']//a[@href='/delete_account']");
    public By logOut = By.xpath("//header[@id='header']//a[@href='/logout']");
    public By contactUs = By.xpath("//header[@id='header']//a[@href='/contact_us']");
    public By testCasePage = By.xpath("//a[@href='/test_cases']/button[text()='Test Cases']");
    public By subscriptionLabel = By.xpath("//h2[contains(text(),'Subscription')]");
    public By scrollUpButton = By.id("scrollUp");
    public By topText = By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]");
    public By subscribeEmailInput = By.id("susbscribe_email");
    public By subscribeButton = By.id("subscribe");
    public By subscriptionSuccessMessage = By.xpath("//div[@class='alert-success alert']");
}