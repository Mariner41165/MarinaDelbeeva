package ru.training.at.hw2.ex1;

import java.util.Arrays;
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

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); //v.91.0.4472
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    //Assert Browser title
    @Test
    public void assertBrowserTitle() {
        softAssert.assertEquals("Home Page", driver.getTitle());
    }

    //Perform login and Assert Username is logged in
    @Test (priority = 0)
    public void assertUsernameHasLoggedIn() {
        WebElement login = waitForElementLocatedBy(By.className("profile-photo"));
        login.click();
        WebElement name = waitForElementLocatedBy(By.id("name"));
        name.sendKeys("Roman");
        WebElement pass = waitForElementLocatedBy(By.id("password"));
        pass.sendKeys("Jdi1234");
        waitForElementLocatedBy(By.id("login-button")).click();
        WebElement username = waitForElementLocatedBy(By.id("user-name"));
        softAssert.assertTrue(username.isDisplayed());
    }

    //Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test
    public void assertDisplayingMenuButtonsWithProperTexts() {
        waitForElementLocatedBy(By.className("uui-navigation"));
        List<WebElement> navigationBar = waitForElementLocatedBy(By.className("uui-header"))
                                               .findElements(By.className("uui-navigation"));
        List<WebElement> itemsOnHeader = navigationBar.get(0)
                                                      .findElements(By.cssSelector("ul > li"));
        List<String> itemsOnHeaderToStrings =
            itemsOnHeader.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> itemsForChecking = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors");
        softAssert.assertTrue(itemsOnHeaderToStrings.equals(itemsForChecking),
            "there are 4 items on the header section and they have proper texts");
    }

    //Assert that there are 4 images on the Index Page and they are displayed
    @Test
    public void assertDisplayingOfFourImages() {
        List<WebElement> images = waitForListOfElementsLocatedBy(new ByClassName("benefit-icon"));
        softAssert.assertEquals(images.size(), 4);
    }

    //Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test
    public void assertFourTestsUnderIconsHaveProperText() {
        List<WebElement> textsUnderImages = waitForListOfElementsLocatedBy(new ByClassName("benefit-txt"));
        softAssert.assertEquals(textsUnderImages.size(), 4);
    }

    //Assert that there is the iframe with “Frame Button” exist
    @Test
    public void assertExistingIframeWithFrameButton() {
        List<WebElement> iframes = waitForListOfElementsLocatedBy(By.tagName("iframe"));
        Assert.assertNotNull(iframes.get(0).findElements(By.id("frame-button")));
        //Assert.assertTrue(iframes.stream().anyMatch(s -> s.getAttribute("id").contains("frame-button")));
    }

    //Switch to the iframe and check that there is “Frame Button” in the iframe
    //Switch to original window back
    @Test
    public void assertFrameButtonInFrame() {
        driver.switchTo().frame("frame");
        Assert.assertTrue(waitForElementLocatedBy(By.id("frame-button")).isDisplayed());
        driver.switchTo().defaultContent();
    }

    //Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test
    public void assertDisplayingOfFiveItemsInLeftSectionWithProperText() {
        WebElement sideBar = waitForElementLocatedBy(By.className("uui-side-bar"));
        List<WebElement> sideBarItems = sideBar.findElements(By.cssSelector("div > div > div > div > ul > li"));
        List<String> sideBarItemsToStrings =
            sideBarItems.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> itemsForChecking = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertTrue(sideBarItemsToStrings.equals(itemsForChecking),
            "there are 5 items in the Left Section and they have proper text");
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
        //softAssert.assertAll();
    }

    private WebElement waitForElementLocatedBy(By by) {
        return new WebDriverWait(driver, 10)
            .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private List<WebElement> waitForListOfElementsLocatedBy(By by) {
        return new WebDriverWait(driver, 10)
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
