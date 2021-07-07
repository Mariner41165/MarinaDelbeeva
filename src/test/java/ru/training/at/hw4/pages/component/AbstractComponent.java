package ru.training.at.hw4.pages.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractComponent(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}
