package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider (name = "positiveNaturalNumbers")
    public static Object[][] positiveNaturalNumbers() {
        long a = (long) (Math.random() * 100 + 1);
        long b = (long) (Math.random() * 10 + 1);
        return new Object[][]{{a, b}};
    }

    @DataProvider (name = "negativeNaturalNumbers")
    public static Object[][] negativeNaturalNumbers() {
        long a = (long) (Math.random() * -100 + 1);
        long b = (long) (Math.random() * -10 + 1);
        return new Object[][]{{a, b}};
    }

    @DataProvider (name = "positiveRationalNumbers")
    public static Object[][] positiveRationalNumbers() {
        double a = Math.random() * 100 + 1.0;
        double b = Math.random() * 10 + 1.0;
        return new Object[][]{{a, b}};
    }

    @DataProvider (name = "negativeRationalNumbers")
    public static Object[][] negativeRationalNumbers() {
        double a = Math.random() * -100 - 1.0;
        double b = Math.random() * -10 - 1.0;
        return new Object[][]{{a, b}};
    }

    @DataProvider (name = "naturalNumberAndZero")
    public static Object[][] naturalNumberAndZero() {
        long a = (long) (Math.random() * 10 + 1);
        long zero = 0;
        return new Object[][]{{a, zero}};
    }

    @DataProvider (name = "rationalNumberAndZero")
    public static Object[][] rationalNumberAndZero() {
        double a = Math.random() * 10 + 1.0;
        double zero = 0.0;
        return new Object[][]{{a, zero}};
    }

    @DataProvider (name = "naturalNumber")
    public static Object[][] naturalNumber() {
        long a = (long) (Math.random() * 10 + 1);
        return new Object[][]{{a}};
    }

    @DataProvider (name = "rationalNumber")
    public static Object[][] rationalNumber() {
        double a = Math.random() * 10 + 1.0;
        return new Object[][]{{a}};
    }
}
