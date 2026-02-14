package test.automation.UITests;

import org.openqa.selenium.*;
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

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
        homePage = new HomePage();

        wait.until(d -> driver.findElement(homePage.siteLogo).isDisplayed());
        assertTrue(driver.findElement(homePage.siteLogo).isDisplayed(), "Site logo should be visible on the homepage");
    }

    protected void closeAdIfPresent() {
        try {
            driver.findElements(By.cssSelector(".close, .modal-close, .popup-close"))
                    .stream()
                    .filter(e -> e.isDisplayed() && e.isEnabled())
                    .findFirst()
                    .ifPresent(WebElement::click);
        } catch (Exception ignored) {}
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }}