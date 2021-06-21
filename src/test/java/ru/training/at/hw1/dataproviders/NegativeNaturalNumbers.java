package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class NegativeNaturalNumbers {

    @DataProvider (name = "negativeNaturalNumbers")
    public static Object[][] negativeNaturalNumbers() {
        long a = (long) (Math.random() * -100 + 1);
        long b = (long) (Math.random() * -10 + 1);
        return new Object[][]{{a, b}};
    }

}
