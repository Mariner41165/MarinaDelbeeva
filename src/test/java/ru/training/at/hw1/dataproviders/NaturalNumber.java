package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class NaturalNumber {

    @DataProvider (name = "naturalNumber")
    public static Object[][] naturalNumber() {
        long a = (long) (Math.random() * 10 + 1);
        return new Object[][]{{a}};
    }

}
