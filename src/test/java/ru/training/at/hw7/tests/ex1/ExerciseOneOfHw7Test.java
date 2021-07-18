package ru.training.at.hw7.tests.ex1;

import static ru.training.at.hw7.SiteJdi.homePage;
import static ru.training.at.hw7.SiteJdi.metalAndColorsPage;

import org.testng.annotations.Test;
import ru.training.at.hw7.dataProvider.Data;
import ru.training.at.hw7.dataProvider.MetalsColorsDataSet;
import ru.training.at.hw7.tests.BaseTest;

public class ExerciseOneOfHw7Test extends BaseTest {


    @Test (dataProviderClass = MetalsColorsDataSet.class, dataProvider = "metalsColorsData")
    public void doExerciseOneInHw7(Data data) {
        homePage.open();

        //Roman Iovlev is logged in
        homePage.performLogin(properties.getName(), properties.getPassword());

        //Metals&Colors page is opened
        homePage.chooseMetalAndColorsInHeader();

        //Form Metals & Colors form is filled
        metalAndColorsPage.fillForm(data);

        //Form Metals & Colors was submitted
        metalAndColorsPage.submit();

        //Result section contains provided data
        metalAndColorsPage.containsProvidedDataInResultSection(data);
    }
}
