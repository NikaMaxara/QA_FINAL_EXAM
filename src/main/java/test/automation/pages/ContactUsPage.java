package test.automation.pages;

import org.openqa.selenium.By;

public class ContactUsPage {

    public By getInTouchTitle = By.xpath("//div[@class='contact-form']//h2");
    public By contactUsForm = By.xpath("//form[@id='contact-us-form']");
    public By nameInput = By.cssSelector("form#contact-us-form input[name='name']");
    public By emailInput = By.cssSelector("form#contact-us-form input[name='email']");
    public By subjectInput = By.cssSelector("form#contact-us-form input[name='subject']");
    public By messageInput = By.id("message");
    public By fileInput = By.cssSelector("form#contact-us-form input[type='file']");
    public By submitButton = By.cssSelector("form#contact-us-form input[type='submit']");
    public By successMessage = By.xpath(
            "//div[contains(@class,'alert-success') and contains(text(),'Success! Your details have been submitted successfully.')]"
    );
    public By homeButton = By.xpath("//a[@href='/' and contains(@class,'btn-success')]");
}

