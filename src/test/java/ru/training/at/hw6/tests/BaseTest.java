package ru.training.at.hw6.tests;

import static ru.training.at.hw6.driver.WebDriverSingleton.getDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw6.PropertiesFile;
import ru.training.at.hw6.driver.WebDriverSingleton;
import ru.training.at.hw6.steps.ActionStep;
import ru.training.at.hw6.steps.AssertionStep;

public class BaseTest {

    protected WebDriver driver;
    public PropertiesFile properties;
    public ActionStep actionStep;
    public AssertionStep assertionStep;

    @BeforeClass
    public void setUp(ITestContext testContext) {
        WebDriverManager.chromedriver().setup();
        driver = getDriver();
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        testContext.setAttribute("driver", driver);

        properties = new PropertiesFile();
        //driver.get(properties.getUrl());
    }

    @AfterClass
    public void closeDriver() {
        WebDriverSingleton.closeDriver();
    }
}

