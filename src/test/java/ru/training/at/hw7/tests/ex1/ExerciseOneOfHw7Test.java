package ru.training.at.hw7.tests.ex1;

import static ru.training.at.hw7.SiteJdi.homePage;
import static ru.training.at.hw7.SiteJdi.metalAndColorsPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw7.dataProvider.MetalAndColorsValues;
import ru.training.at.hw7.dataProvider.MetalsColorsDataSet;
import ru.training.at.hw7.tests.BaseTest;

public class ExerciseOneOfHw7Test extends BaseTest {

    @Test (dataProviderClass = MetalsColorsDataSet.class, dataProvider = "metalsColorsData")
    public void doExerciseOneInHw7(MetalAndColorsValues values) {
        //User should be logged in
        Assert.assertEquals(homePage.getUsername(), properties.getUsername());

        //Metals&Colors page is opened
        homePage.chooseMetalAndColorsInHeader();

        //Form Metals & Colors is filled
        step.fillForm(values);

        //Form Metals & Colors is submitted
        step.submit();

        //Result section contains provided data
        metalAndColorsPage.shouldContainProvidedDataInResultSection(values);
    }
}
