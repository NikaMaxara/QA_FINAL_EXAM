package test.automation.steps.UISteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test.automation.pages.DeleteAccountPage;

public class DeleteAccountSteps {

    private WebDriver driver;
    private DeleteAccountPage deleteAccountPage;

    public DeleteAccountSteps(WebDriver driver) {
        this.driver = driver;
        this.deleteAccountPage = new DeleteAccountPage();
    }

    @Step("Validate account deletion success message is visible")
    public DeleteAccountSteps validateDeleteAccount() {
        Assert.assertTrue(driver.findElement(deleteAccountPage.successDeleteMessage).isDisplayed(),
                "Account deletion success message should be visible");
        return this;
    }

    @Step("Click Continue button after account deletion")
    public DeleteAccountSteps clickContinue() {
        driver.findElement(deleteAccountPage.continueButton).click();
        return this;
    }
}
