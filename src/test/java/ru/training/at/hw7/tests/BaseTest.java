package ru.training.at.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw7.SiteJdi;
import ru.training.at.hw7.PropertiesFile;
import ru.training.at.hw7.pages.HomePage;

public class BaseTest {
    protected static PropertiesFile properties;
    protected static SoftAssert softAssert = new SoftAssert();

    @BeforeClass(alwaysRun = true)
    public static void setUpClass() {
        initElements(SiteJdi.class);
        properties = new PropertiesFile();
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.performLogin(properties.getName(), properties.getPassword());
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }

}

