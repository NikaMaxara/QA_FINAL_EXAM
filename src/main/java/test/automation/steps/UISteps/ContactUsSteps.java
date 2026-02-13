package test.automation.steps.UISteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.automation.pages.ContactUsPage;

import java.io.File;

public class ContactUsSteps {

    private WebDriver driver;
    private ContactUsPage contactUsPage;

    public ContactUsSteps(WebDriver driver) {
        this.driver = driver;
        this.contactUsPage = new ContactUsPage();
    }

    @Step("Enter name: {name}")
    public ContactUsSteps enterName(String name) {
        driver.findElement(contactUsPage.nameInput).sendKeys(name);
        return this;
    }

    @Step("Enter email: {email}")
    public ContactUsSteps enterEmail(String email) {
        driver.findElement(contactUsPage.emailInput).sendKeys(email);
        return this;
    }

    @Step("Enter subject: {subject}")
    public ContactUsSteps enterSubject(String subject) {
        driver.findElement(contactUsPage.subjectInput).sendKeys(subject);
        return this;
    }

    @Step("Enter message: {message}")
    public ContactUsSteps enterMessage(String message) {
        driver.findElement(contactUsPage.messageInput).sendKeys(message);
        return this;
    }

    @Step("Upload file: {filePath}")
    public ContactUsSteps uploadFile(String filePath) {
        driver.findElement(contactUsPage.fileInput).sendKeys(new File(filePath).getAbsolutePath());
        return this;
    }

    @Step("Click Submit button")
    public ContactUsSteps clickSubmit() {
        driver.findElement(contactUsPage.submitButton).click();
        return this;
    }

    @Step("Click home button")
    public ContactUsSteps clickHome() {
        driver.findElement(contactUsPage.homeButton).click();
        return this;
    }

    @Step("Validate success message is visible")
    public ContactUsSteps validateSuccessMessage() {
        WebElement msg = driver.findElement(contactUsPage.successMessage);
        Assert.assertTrue(msg.isDisplayed(), "Success message should be visible");
        return this;
    }
}

