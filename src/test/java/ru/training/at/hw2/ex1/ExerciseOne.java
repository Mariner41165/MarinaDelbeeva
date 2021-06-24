package ru.training.at.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExerciseOne {
    private WebDriver driver;
    private SoftAssert softAssert;
    private WebDriverWait wait;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Test
    public void doExerciseOneInHw2() {
        //Assert Browser title
        softAssert.assertEquals("Home Page", driver.getTitle());

        //Perform login and Assert Username is logged in
        WebElement login = waitForElementLocatedBy(By.className("profile-photo"));
        login.click();
        WebElement name = waitForElementLocatedBy(By.id("name"));
        name.sendKeys("Roman");
        WebElement pass = waitForElementLocatedBy(By.id("password"));
        pass.sendKeys("Jdi1234");
        waitForElementLocatedBy(By.id("login-button")).click();
        WebElement username = waitForElementLocatedBy(By.id("user-name"));
        softAssert.assertTrue(username.isDisplayed());

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> itemsOnHeader =
            waitForListOfElementsLocatedBy(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']"));
        List<String> itemsOnHeaderToStrings =
            itemsOnHeader.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> itemsOnHeaderForChecking = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors");
        softAssert.assertTrue(itemsOnHeaderToStrings.equals(itemsOnHeaderForChecking),
            "there are 4 items on the header section and they have proper texts");

        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = waitForListOfElementsLocatedBy(new ByClassName("benefit-icon"));
        softAssert.assertEquals(images.size(), 4);

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textsUnderImages = waitForListOfElementsLocatedBy(new ByClassName("benefit-txt"));
        softAssert.assertEquals(textsUnderImages.size(), 4);

        //Assert that there is the iframe with “Frame Button” exist
        List<WebElement> iframes = waitForListOfElementsLocatedBy(By.tagName("iframe"));
        softAssert.assertNotNull(iframes.get(0).findElements(By.id("frame-button")));

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        //Switch to original window back
        driver.switchTo().frame("frame");
        Assert.assertTrue(waitForElementLocatedBy(By.id("frame-button")).isDisplayed());
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sideBarItems = waitForListOfElementsLocatedBy(By.xpath("//ul[@class='sidebar-menu left']"));
        List<String> sideBarItemsToStrings =
            sideBarItems.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sideBarItemsForChecking = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertTrue(sideBarItemsToStrings.equals(sideBarItemsForChecking),
            "there are 5 items in the Left Section and they have proper text");
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
