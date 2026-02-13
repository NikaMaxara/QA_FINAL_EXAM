//package test.automation.UITests;
//
//import io.qameta.allure.Attachment;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import test.automation.data.Constants;
//
//import com.codeborne.selenide.Configuration;
//import test.automation.pages.ContactUsPage;
//import test.automation.pages.HomePage;
//import test.automation.steps.UISteps.ContactUsSteps;
//import test.automation.steps.UISteps.HomeSteps;
//
//import java.time.Duration;
//
//import static com.codeborne.selenide.Condition.visible;
//import static com.codeborne.selenide.Selenide.closeWebDriver;
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//
//public class BaseTest {
//    HomePage homePage;
//    WebDriverWait wait;
//
//    @BeforeClass
//    public void setUp(){
//        Configuration.browser = "chrome";
//        Configuration.timeout = 10000;
//
//        open(Constants.AUTOMATION_EXERCISE_URL);
//        getWebDriver().manage().window().maximize();
//
//        wait = new WebDriverWait(getWebDriver(),Duration.ofSeconds(10));
//        homePage = new HomePage();
//        homePage.siteLogo.shouldBe(visible);
//    }
//
//    @AfterClass
//    public void tearDown(){
//        takeScreenshotAllure();
//        closeWebDriver();
//    }
//
//    @Attachment(value = "Screenshot", type = "image/png")
//    public byte[] takeScreenshotAllure(){
//        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
//    }
//}
package test.automation.UITests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.automation.data.Constants;
import test.automation.pages.HomePage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BaseTest {

    public WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(Constants.AUTOMATION_EXERCISE_URL);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        homePage = new HomePage();

        wait.until(d -> driver.findElement(homePage.siteLogo).isDisplayed());
        assertTrue(driver.findElement(homePage.siteLogo).isDisplayed(), "Site logo should be visible on the homepage");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

