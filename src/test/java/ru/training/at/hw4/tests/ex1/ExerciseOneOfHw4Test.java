package ru.training.at.hw4.tests.ex1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.tests.BaseTest;

public class ExerciseOneOfHw4Test extends BaseTest {

    @Feature(value = "Feature 1")
    @Story(value = "User Story 1")
    @Test(description = "Выполнение упражнения 1")
    public void doExerciseOneInHw4() {
        //Assert Browser title
        actionStep.openHomePage();

        //Assert Username is logged in
        actionStep.performLogin(properties.getName(), properties.getPassword());

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.fourItemsWithProperTextsExistInHeader();

        //Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.countOfImagesOnHomePageEqualsTo(4);

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.countOfTextsUnderImagesOnHomePageEqualsTo(4);

        //Assert that there is the iframe with “Frame Button” exist
        assertionStep.iframeExistsOnHomePage();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        //Switch to original window back
        actionStep.switchToIFrame();
        assertionStep.frameButtonIsDisplayedInIFrame();
        actionStep.switchBackFromIFrameToOriginalWindow();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.fiveItemsWithProperTextsAreDisplayedOnHomePage();
    }
}
