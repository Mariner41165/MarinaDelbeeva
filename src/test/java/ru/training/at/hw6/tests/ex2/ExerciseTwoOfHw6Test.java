package ru.training.at.hw6.tests.ex2;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw6.tests.BaseTest;

public class ExerciseTwoOfHw6Test extends BaseTest {

    @Feature(value = "Feature 2")
    @Story(value = "User Story 2")
    @Test(description = "Выполнение упражнения 2")
    public void doExerciseTwoInHw6() {
        //Assert Browser title
        actionStep.openHomePage();

        //Assert Username is logged in
        actionStep.performLogin(properties.getName(), properties.getPassword());

        //Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();
        assertionStep.chosenCategoryPageIsOpened("Different elements");

        //Select checkboxes Water, Wind
        actionStep.selectCheckboxesOnDifferentElementsPage();

        //Select radio Selen
        actionStep.selectSelenRadiobuttonOnDifferentElementsPage();

        //Select in dropdown Yellow
        actionStep.selectYellowColorOnDifferentElementsPage();

        //Assert that
        // for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // for radio button there is a log row and value is corresponded to the status of radio button
        // for dropdown there is a log row and value is corresponded to the selected value.
        assertionStep.logOfChosenParametersAreDisplayedOnDifferentElementsPage();
    }
}
