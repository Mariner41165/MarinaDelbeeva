package ru.training.at.hw3.driverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitActions {

    private WebDriverWait wait;

    public WaitActions(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
    }

}
