package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step ("Перейти во фрейм")
    public void switchToIFrame() {
        homePage.switchToIFrame();
    }

    @Step ("Вернуться из фрейма на исходную страницу")
    public void switchBackFromIFrameToOriginalWindow() {
        homePage.switchToDefaultContent();
    }

    @Step ("Открыть подраздел '{categoryName}' в разделе Service")
    public void openDifferentElementsPage() {
        homePage.chooseServiceInMenuAndDifferentElementsInSubmenu();
    }

    @Step ("Выбрать чекбоксы Water и Wind")
    public void selectCheckboxesOnDifferentElementsPage() {
        differentElementsPage.activateCheckboxes();
    }

    @Step ("В переключателе выбрать Selen")
    public void selectSelenRadiobuttonOnDifferentElementsPage() {
        differentElementsPage.selectSelenRadiobutton();
    }

    @Step ("Выбрать желтый цвет из выпадающего списка")
    public void selectYellowColorOnDifferentElementsPage() {
        differentElementsPage.selectYellowColor();
    }
}
