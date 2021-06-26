package ru.training.at.hw3.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage {

    private final WebDriver driver;
    private final Actions action;

    public DifferentElementsPage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(webDriver, this);
        action = new Actions(driver);
    }

    public void activateCheckboxes() {
        List<WebElement> listOfCheckboxes = driver.findElements(By.className("label-checkbox"));
        action.moveToElement(listOfCheckboxes.get(0)).click().perform();
        action.moveToElement(listOfCheckboxes.get(2)).click().perform();
    }

    public void selectSelenRadiobutton() {
        List<WebElement> listOfRadios = driver.findElements(By.className("label-radio"));
        action.moveToElement(listOfRadios.get(3)).click().perform();
    }

    public void selectYellowColor() {
        WebElement colors = driver.findElement(By.className("colors"));
        WebElement selectElem = colors.findElement(By.className("uui-form-element"));
        new Select(selectElem).selectByIndex(3);
    }
}
