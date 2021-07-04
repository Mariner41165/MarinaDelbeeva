package ru.training.at.hw5.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends AbstractPage {

    private final Actions action;

    @FindBy(className = "label-checkbox")
    private List<WebElement> listOfCheckboxes;
    @FindBy (className = "label-radio")
    private List<WebElement> listOfRadios;
    @FindBy (className = "colors")
    private WebElement colors;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    public void activateCheckboxes() {
        action.moveToElement(listOfCheckboxes.get(0)).click().perform();
        action.moveToElement(listOfCheckboxes.get(2)).click().perform();
    }

    public void selectSelenRadiobutton() {
        action.moveToElement(listOfRadios.get(3)).click().perform();
    }

    public void selectYellowColor() {
        WebElement selectElem = colors.findElement(By.className("uui-form-element"));
        new Select(selectElem).selectByIndex(3);
    }

    public void checkingOfDisplayingChosenParameters() {
        driver.getPageSource().contains("Wind: condition changed to true");
        driver.getPageSource().contains("Water: condition changed to true");
        driver.getPageSource().contains("metal: value changed to Selen");
    }
}

