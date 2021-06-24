package ru.training.at.hw1.operations.addandsubtract;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.NegativeNaturalNumbers;
import ru.training.at.hw1.dataproviders.PositiveNaturalNumbers;

public class SumOfNonZeroNaturalNumbers {
    Calculator calc = new Calculator();

    @Test (groups = {"addAndSubtractTests"},
           dataProviderClass = PositiveNaturalNumbers.class, dataProvider = "positiveNaturalNumbers")
    public void sumOfNonZeroPositiveNaturalNumbers(long a, long b) {
        long result = a + b;
        Assert.assertEquals(calc.sum(a, b), result);
    }

    @Test (groups = {"addAndSubtractTests"},
           dataProviderClass = NegativeNaturalNumbers.class, dataProvider = "negativeNaturalNumbers")
    public void sumOfNonZeroNegativeNaturalNumbers(long a, long b) {
        long result = a + b;
        Assert.assertEquals(calc.sum(a, b), result);
    }

}
