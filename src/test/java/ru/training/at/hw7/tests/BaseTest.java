package ru.training.at.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.training.at.hw7.SiteJdi;
import ru.training.at.hw7.PropertiesFile;

public class BaseTest {

    public PropertiesFile properties = new PropertiesFile();

    @BeforeClass(alwaysRun = true)
    public static void setUpClass() {
        initElements(SiteJdi.class);
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }

}

