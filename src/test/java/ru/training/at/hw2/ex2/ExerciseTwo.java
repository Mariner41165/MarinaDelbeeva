package ru.training.at.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExerciseTwo {

    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert;
    Actions action;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        action = new Actions(driver);
    }

    @Test
    public void doExersiceTwoInHw2() {
        //Assert Browser title
        softAssert.assertEquals("Home Page", driver.getTitle());

        //Assert User name in the left-top side of screen that user is logged in
        WebElement login = waitForElementLocatedBy(By.className("profile-photo"));
        login.click();
        WebElement name = waitForElementLocatedBy(By.id("name"));
        name.sendKeys("Roman");
        WebElement pass = waitForElementLocatedBy(By.id("password"));
        pass.sendKeys("Jdi1234");
        waitForElementLocatedBy(By.id("login-button")).click();
        WebElement username = waitForElementLocatedBy(By.id("user-name"));
        softAssert.assertTrue(username.isDisplayed());

        //Open through the header menu Service -> Different Elements Page
        WebElement serviceButton = waitForElementLocatedBy(By.className("dropdown-toggle"));
        action.moveToElement(serviceButton).click().perform();
        WebElement differentElements = waitForElementLocatedBy(By.xpath("//a[text()='Different elements']"));
        action.moveToElement(differentElements).click().perform();
        softAssert.assertEquals("Different elements", driver.getTitle());

        //Select checkboxes Water, Wind
        List<WebElement> listOfCheckboxes = waitForListOfElementsLocatedBy(By.className("label-checkbox"));
        action.moveToElement(listOfCheckboxes.get(0)).click().perform();
        action.moveToElement(listOfCheckboxes.get(2)).click().perform();

        //Select radio Selen
        List<WebElement> listOfRadios = waitForListOfElementsLocatedBy(By.className("label-radio"));
        action.moveToElement(listOfRadios.get(3)).click().perform();

        //Select in dropdown Yellow
        WebElement colors = waitForElementLocatedBy(By.className("colors"));
        WebElement selectElem = colors.findElement(By.className("uui-form-element"));
        new Select(selectElem).selectByIndex(3);

        //Assert that
        // for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // for radio button there is a log row and value is corresponded to the status of radio button
        // for dropdown there is a log row and value is corresponded to the selected value.
        driver.getPageSource().contains("Wind: condition changed to true");
        driver.getPageSource().contains("Water: condition changed to true");
        driver.getPageSource().contains("metal: value changed to Selen");
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }

    private WebElement waitForElementLocatedBy(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private List<WebElement> waitForListOfElementsLocatedBy(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
