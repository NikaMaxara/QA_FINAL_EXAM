package test.automation.steps.UISteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import test.automation.pages.TestCasesPage;

public class TestCasesSteps {
    private WebDriver driver;
    private TestCasesPage testCasesPage;

    public TestCasesSteps(WebDriver driver) {
        this.driver = driver;
        this.testCasesPage = new TestCasesPage();
    }

    @Step("Verify test case page is displayed")
    public TestCasesSteps verifyTestCasePage(){
        driver.findElement(testCasesPage.TestCasesTitle).isDisplayed();
        return this;
    }
}
