package test.automation.UITests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.pages.TestCasesPage;
import test.automation.steps.UISteps.HomeSteps;

public class TestCasePageTest extends BaseTest{

    HomeSteps homeSteps;
    TestCasesPage testCasesPage;

    @BeforeMethod
    public void getReady(){
        homeSteps = new HomeSteps(driver);
        testCasesPage = new TestCasesPage();
    }

    @Test
    public void verifyTestCasesPage(){
        homeSteps.openTestCasePage();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(testCasesPage.TestCasesTitle)));
    }
}
