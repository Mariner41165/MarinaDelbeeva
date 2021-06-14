package ru.training.at.hw1.addandsubtract;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class SumOfNonZeroRationalNumbers {
    Calculator calc = new Calculator();

    @Test (groups = {"addAndSubtractTests"},
           dataProviderClass = DataProviders.class, dataProvider = "positiveRationalNumbers")
    public void sumOfPositiveRationalNumbers(double a, double b) {
        double result = a + b;
        Assert.assertEquals(calc.sum(a, b), result);
    }

    @Test (groups = {"addAndSubtractTests"},
           dataProviderClass = DataProviders.class, dataProvider = "negativeRationalNumbers")
    public void sumOfNegativeRationalNumbers(double a, double b) {
        double result = a + b;
        Assert.assertEquals(calc.sum(a, b), result);
    }
}
