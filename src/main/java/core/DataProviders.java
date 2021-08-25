package core;

import constants.ParameterName;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public static Object[][] createListDataProvider() {
        return new Object[][]{
            {ParameterName.BOARD_NAME, "Ищфкв" + (int)(Math.random()*100)}
        };
    }
}
