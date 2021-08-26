package core;

import beans.Board;

import constants.ParameterName;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public static Object[][] trelloBoardDataProvider() {
        return new Object[][]{
            {Board.generateString(10)}
        };
    }

    @DataProvider
    public static Object[][] trelloBoardWithUpdatesDataProvider() {
        return new Object[][]{
            {Board.generateString(10), "NewCardName"}
        };
    }

    @DataProvider
    public static Object[][] getFieldOnBoard() {
        return new Object[][]{
            {Board.generateString(10), ParameterName.ID_MEMBER_CREATOR}
        };
    }
}
