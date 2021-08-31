package core;

import constants.ParameterName;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public static Object[][] trelloBoardDataProvider() {
        return new Object[][]{
            {generateString(10)}
        };
    }

    @DataProvider
    public static Object[][] trelloBoardWithUpdatesDataProvider() {
        return new Object[][]{
            {generateString(10), "NewCardName"}
        };
    }

    @DataProvider
    public static Object[][] getFieldOnBoard() {
        return new Object[][]{
            {generateString(10), ParameterName.ID_MEMBER_CREATOR}
        };
    }

    public static String generateString(int length) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";
        String sb = IntStream.range(0, length).map(i -> (int) (AlphaNumericString.length()
            * Math.random())).mapToObj(index -> String.valueOf(AlphaNumericString
            .charAt(index))).collect(Collectors.joining());
        return sb;
    }
}
