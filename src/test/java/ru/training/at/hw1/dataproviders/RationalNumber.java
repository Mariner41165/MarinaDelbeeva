package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class RationalNumber {

    @DataProvider (name = "rationalNumber")
    public static Object[][] rationalNumber() {
        double a = Math.random() * 10 + 1.0;
        return new Object[][]{{a}};
    }
}
