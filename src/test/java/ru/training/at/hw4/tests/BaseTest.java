package ru.training.at.hw4.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.training.at.hw4.PropertiesFile;
import ru.training.at.hw4.steps.ActionStep;
import ru.training.at.hw4.steps.AssertionStep;

public class BaseTest {

    protected static WebDriver driver;
    protected PropertiesFile properties;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);

        properties = new PropertiesFile();
        driver.get(properties.getUrl());
    }

    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

