package ru.training.at.hw1.operations.addandsubtract;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.NegativeRationalNumbers;
import ru.training.at.hw1.dataproviders.PositiveRationalNumbers;

public class SubOfNonZeroRationalNumbers {
    Calculator calc = new Calculator();

    @Test (groups = {"addAndSubtractTests"},
           dataProviderClass = PositiveRationalNumbers.class, dataProvider = "positiveRationalNumbers")
    public void subOfNonZeroPositiveRationalNumbers(double a, double b) {
        double result = a - b;
        Assert.assertEquals(calc.sub(a, b), result);
    }

    @Test (groups = {"addAndSubtractTests"},
           dataProviderClass = NegativeRationalNumbers.class, dataProvider = "negativeRationalNumbers")
    public void subOfNonZeroNegativeRationalNumbers(double a, double b) {
        double result = a - b;
        Assert.assertEquals(calc.sub(a, b), result);
    }
}
