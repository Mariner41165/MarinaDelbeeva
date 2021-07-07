package ru.training.at.hw6.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw6.pages.DifferentElementsPage;
import ru.training.at.hw6.pages.HomePage;

public class AbstractStep {

    HomePage homePage;
    DifferentElementsPage differentElementsPage;

    protected AbstractStep(WebDriver driver) {
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step ("Открыть домашнюю страницу")
    public void openHomePage() {
        homePage.open();
    }

    @Step ("Залогиниться и проверить отображение имени на странице")
    public void performLogin(String name, String password) {
        homePage.performLogin(name, password);
        homePage.getUsername();
    }

}
