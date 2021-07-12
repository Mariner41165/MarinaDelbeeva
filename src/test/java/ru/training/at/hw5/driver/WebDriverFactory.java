package ru.training.at.hw5.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver createWebDriver(String browserName) {
        WebDriver driver = createChrome();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}