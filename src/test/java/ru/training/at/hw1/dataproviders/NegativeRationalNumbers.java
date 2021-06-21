package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class NegativeRationalNumbers {

    @DataProvider (name = "negativeRationalNumbers")
    public static Object[][] negativeRationalNumbers() {
        double a = Math.random() * -100 - 1.0;
        double b = Math.random() * -10 - 1.0;
        return new Object[][]{{a, b}};
    }

}
