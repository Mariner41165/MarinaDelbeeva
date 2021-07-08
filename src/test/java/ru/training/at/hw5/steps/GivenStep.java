package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    @Given ("Open Home Page")
    public void openHomePage() {
        homePage.open();
    }

    @Given("Open Different Elements Page with credentials {string} and {string}")
    public void openDifferentElementsPage(String name, String password) {
        homePage.open();
        homePage.performLogin(name, password);
        homePage.chooseServiceInMenuAndDifferentElementsInSubmenu();
    }



}
