package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class RationalNumberAndZero {

    @DataProvider (name = "rationalNumberAndZero")
    public static Object[][] rationalNumberAndZero() {
        double a = Math.random() * 10 + 1.0;
        double zero = 0.0;
        return new Object[][]{{a, zero}};
    }

}
