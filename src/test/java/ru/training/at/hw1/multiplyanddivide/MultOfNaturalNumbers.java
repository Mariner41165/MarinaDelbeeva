package ru.training.at.hw1.multiplyanddivide;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class MultOfNaturalNumbers {
    Calculator calc = new Calculator();

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "positiveNaturalNumbers")
    public void multOfTwoNaturalNumbers(long a, long b) {
        long result = a * b;
        Assert.assertEquals(calc.mult(a, b), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "naturalNumberAndZero")
    public void multOfZeroAndNaturalNumber(long a, long zero) {
        Assert.assertEquals(calc.mult(a, zero), 0);
    }
}
