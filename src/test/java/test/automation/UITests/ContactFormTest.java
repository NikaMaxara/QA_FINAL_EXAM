package test.automation.UITests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.data.Constants;
import test.automation.pages.ContactUsPage;
import test.automation.steps.UISteps.ContactUsSteps;
import test.automation.steps.UISteps.HomeSteps;
import test.automation.utils.HelperMethods;

public class ContactFormTest extends BaseTest{

    HomeSteps homeSteps;
    ContactUsPage contactUsPage;
    ContactUsSteps contactUsSteps;

    @BeforeMethod
    public void setUpp(){
        homeSteps = new HomeSteps(driver);
        contactUsPage = new ContactUsPage();
        contactUsSteps = new ContactUsSteps(driver);
    }

    @Test
    public void contactTest(){
        homeSteps.clickContactUs();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(contactUsPage.getInTouchTitle)));
        contactUsSteps
                .enterName(Constants.NAME)
                .enterEmail(Constants.EMAIL)
                .enterSubject(Constants.SUBJECT)
                .enterMessage(Constants.AUTOMATION_EXERCISE_URL)
                .uploadFile(HelperMethods.createFile("file.txt","Testing file"))
                .clickSubmit();

        Alert alert = driver.switchTo().alert();
        alert.accept();
       wait.until(ExpectedConditions.visibilityOf(driver.findElement(contactUsPage.successMessage)));
       contactUsSteps.clickHome();
    }
}
