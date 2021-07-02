package ru.training.at.hw3.ex2;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.BaseTest;
import ru.training.at.hw3.PropertiesFile;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.HomePage;

public class ExerciseTwoOfHw3Test extends BaseTest {
    private final SoftAssert softAssert = new SoftAssert();
    PropertiesFile properties = new PropertiesFile();

    @Test
    public void doExerciseTwoInHw3() {
        //Assert Browser title
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //Assert Username is logged in
        homePage.performLogin(properties.getName(), properties.getPassword());
        softAssert.assertTrue(homePage.getUsername().equalsIgnoreCase(properties.getUsername()));

        //Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPage();
        softAssert.assertEquals(driver.getTitle(), "Different elements");

        //Select checkboxes Water, Wind
        DifferentElementsPage differentElementsPage = PageFactory.initElements(driver, DifferentElementsPage.class);
        differentElementsPage.activateCheckboxes();

        //Select radio Selen
        differentElementsPage.selectSelenRadiobutton();

        //Select in dropdown Yellow
        differentElementsPage.selectYellowColor();

        //Assert that
        // for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // for radio button there is a log row and value is corresponded to the status of radio button
        // for dropdown there is a log row and value is corresponded to the selected value.
        driver.getPageSource().contains("Wind: condition changed to true");
        driver.getPageSource().contains("Water: condition changed to true");
        driver.getPageSource().contains("metal: value changed to Selen");
    }

}
