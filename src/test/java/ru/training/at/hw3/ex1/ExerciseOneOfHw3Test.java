package ru.training.at.hw3.ex1;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.BaseTest;
import ru.training.at.hw3.PropertiesFile;
import ru.training.at.hw3.pages.HomePage;

public class ExerciseOneOfHw3Test extends BaseTest {
    private final SoftAssert softAssert = new SoftAssert();
    PropertiesFile properties = new PropertiesFile();

    @Test
    public void doExerciseOneInHw3() {
        //Assert Browser title
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //Assert Username is logged in
        homePage.performLogin(properties.getName(), properties.getPassword());
        softAssert.assertTrue(homePage.getUsername().equalsIgnoreCase(properties.getUsername()));

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> itemsOnHeaderForChecking = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors");
        softAssert.assertTrue(homePage.itemsOnHeaderToStrings().equals(itemsOnHeaderForChecking),
            "there are 4 items on the header section and they have proper texts");

        //Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(homePage.countOfImages(), 4);

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(homePage.countOfTextsUnderImages(), 4);

        //Assert that there is the iframe with “Frame Button” exist
        softAssert.assertNotNull(homePage.existingOfIframe());

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        //Switch to original window back
        driver.switchTo().frame("frame");
        softAssert.assertTrue(homePage.frameButton().isDisplayed());
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> sideBarItemsForChecking = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softAssert.assertTrue(homePage.sideBarItems().equals(sideBarItemsForChecking),
            "there are 5 items in the Left Section and they have proper text");
    }

}
