package ru.training.at.hw7.steps;

import ru.training.at.hw7.pages.MetalAndColorsPage;
import ru.training.at.hw7.pages.HomePage;

public class BaseStep {

    HomePage homePage;
    MetalAndColorsPage metalAndColorsPage;

    public BaseStep() {
        homePage = new HomePage();
        metalAndColorsPage = new MetalAndColorsPage();
    }

    public void openHomePage() {
        homePage.open();
    }

    public void performLogin(String name, String password) {
        homePage.performLogin(name, password);
        homePage.getUsername();
    }

}
