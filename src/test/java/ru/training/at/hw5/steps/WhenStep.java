package ru.training.at.hw5.steps;

import io.cucumber.java.en.When;

public class WhenStep extends AbstractStep {

    @When("Perform login with username {string} and password {string}")
    public void performLogin(String name, String password) {
        homePage.performLogin(name, password);
        homePage.getUsername();
    }

    @When ("Switch to the iframe")
    public void switchToIFrame() {
        homePage.switchToIFrame();
    }

    @When ("Switch back from frame")
    public void switchBackFromIFrameToOriginalWindow() {
        homePage.switchToDefaultContent();
    }

    @When ("Click on Different Elements in Service menu")
    public void openDifferentElementsPage() {
        homePage.chooseServiceInMenuAndDifferentElementsInSubmenu();
    }

    @When ("Select checkboxes Water and Wind")
    public void selectCheckboxesOnDifferentElementsPage() {
        differentElementsPage.activateCheckboxes();
    }

    @When ("Select radio Selen")
    public void selectSelenRadiobuttonOnDifferentElementsPage() {
        differentElementsPage.selectSelenRadiobutton();
    }

    @When ("Select Yellow color in dropdown")
    public void selectYellowColorOnDifferentElementsPage() {
        differentElementsPage.selectYellowColor();
    }

}
