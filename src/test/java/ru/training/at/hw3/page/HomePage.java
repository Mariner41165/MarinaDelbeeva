package ru.training.at.hw3.page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    @FindBy (className = "profile-photo")
    private WebElement profilePhoto;

    @FindBy (id = "name")
    private WebElement name;

    @FindBy (id = "password")
    private WebElement password;

    @FindBy (id = "login-button")
    private WebElement loginButton;

    public void login(String userName, String password) {
        profilePhoto.click();
        name.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
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
