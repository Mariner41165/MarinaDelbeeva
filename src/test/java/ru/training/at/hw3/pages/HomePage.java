package ru.training.at.hw3.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw3.driverutils.WaitActions;

public class HomePage {

    private final WebDriver driver;

    @FindBy (className = "profile-photo")
    private WebElement profilePhoto;
    @FindBy (id = "name")
    private WebElement nameField;
    @FindBy (id = "password")
    private WebElement passwordField;
    @FindBy (id = "login-button")
    private WebElement loginButton;

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(webDriver, this);
        WaitActions waitActions = new WaitActions(webDriver);
    }

    public void performLogin(String name, String password) {
        profilePhoto.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getUsername() {
        WebElement username = driver.findElement(By.id("user-name"));
        return username.getText();
    }

    public List<String> itemsOnHeaderToStrings() {
        List<WebElement> itemsOnHeader =
            driver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']"));
        return itemsOnHeader.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> sideBarItems() {
        List<WebElement> sideBarItems = driver.findElements(By.xpath("//ul[@class='sidebar-menu left']"));
        return sideBarItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int countOfImages() {
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        return images.size();
    }

    public int countOfTextsUnderImages() {
        List<WebElement> textsUnderImages = driver.findElements(By.className("benefit-txt"));
        return (int) textsUnderImages.stream().map(WebElement::getText).count();
    }

    public List<WebElement> existingOfIframe() {
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        return iframes.get(0).findElements(By.id("frame-button"));
    }

    public WebElement frameButton() {
        return driver.findElement(By.id("frame-button"));
    }

    public void openDifferentElementsPage() {
        WebElement serviceButton = driver.findElement(By.className("dropdown-toggle"));
        new Actions(driver).moveToElement(serviceButton).click().perform();
        WebElement differentElements = driver.findElement(By.xpath("//a[text()='Different elements']"));
        new Actions(driver).moveToElement(differentElements).click().perform();
    }
}

