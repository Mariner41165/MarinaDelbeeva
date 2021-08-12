package ru.training.at.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.training.at.hw7.SiteJdi;
import ru.training.at.hw7.PropertiesFile;
import ru.training.at.hw7.steps.ActionStep;

public class BaseTest extends ActionStep {
    protected static PropertiesFile properties;
    protected static ActionStep step = new ActionStep();

    @BeforeClass(alwaysRun = true)
    public static void setUpClass() {
        initElements(SiteJdi.class);
        properties = new PropertiesFile();
        step.openHomePage();
        step.performLogin(properties.getName(), properties.getPassword());
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }

}

