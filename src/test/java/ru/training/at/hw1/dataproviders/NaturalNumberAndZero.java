package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class NaturalNumberAndZero {

    @DataProvider (name = "naturalNumberAndZero")
    public static Object[][] naturalNumberAndZero() {
        long a = (long) (Math.random() * 10 + 1);
        long zero = 0;
        return new Object[][]{{a, zero}};
    }

}
