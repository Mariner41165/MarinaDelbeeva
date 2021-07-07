package ru.training.at.hw6.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy (className = "profile-photo")
    private WebElement profilePhoto;
    @FindBy (id = "name")
    private WebElement nameField;
    @FindBy (id = "password")
    private WebElement passwordField;
    @FindBy (id = "login-button")
    private WebElement loginButton;
    @FindBy (id = "user-name")
    private WebElement username;
    @FindBy (xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']")
    private List<WebElement> itemsOnHeader;
    @FindBy (xpath = "//ul[@class='sidebar-menu left']")
    private List<WebElement> sideBarItems;
    @FindBy (className = "benefit-icon")
    private List<WebElement> images;
    @FindBy (className = "benefit-txt")
    private List<WebElement> textsUnderImages;
    @FindBy (tagName = "iframe")
    private List<WebElement> iframes;
    @FindBy (className = "dropdown-toggle")
    private WebElement serviceButton;
    @FindBy (xpath = "//a[text()='Different elements']")
    private WebElement differentElements;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
    }

    public void performLogin(String name, String password) {
        profilePhoto.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getUsername() {
        return username.getText();
    }

    public List<String> itemsOnHeaderToStrings() {
        return itemsOnHeader.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> sideBarItems() {
        return sideBarItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int countOfImages() {
        return images.size();
    }

    public int countOfTextsUnderImages() {
        return (int) textsUnderImages.stream().map(WebElement::getText).count();
    }

    public List<WebElement> existingOfIframe() {
        return iframes.get(0).findElements(By.id("frame-button"));
    }

    public void switchToIFrame() {
        driver.switchTo().frame("frame");
    }

    public WebElement frameButton() {
        return driver.findElement(By.id("frame-button"));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void chooseServiceInMenuAndDifferentElementsInSubmenu() {
        new Actions(driver).moveToElement(serviceButton).click().perform();
        new Actions(driver).moveToElement(differentElements).click().perform();
    }
}
