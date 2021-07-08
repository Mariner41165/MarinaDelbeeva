package ru.training.at.hw5.steps;

import ru.training.at.hw5.PropertiesFile;
import ru.training.at.hw5.driver.WebDriverSingleton;
import ru.training.at.hw5.pages.DifferentElementsPage;
import ru.training.at.hw5.pages.HomePage;

public class AbstractStep {

    HomePage homePage;
    DifferentElementsPage differentElementsPage;
    PropertiesFile properties;

    protected AbstractStep() {
        homePage = new HomePage(WebDriverSingleton.getDriver());
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.getDriver());
        properties = new PropertiesFile();
    }
}
