package ru.training.at.hw1.multiplyanddivide;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class SqrtTest {
    Calculator calc = new Calculator();

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "rationalNumber")
    public void sqrtOfPositiveNumber(double a) {
        double result = Math.sqrt(a);
        Assert.assertEquals(calc.sqrt(a), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "rationalNumber")
    public void sqrtOfNegativeNumber(double a) {
        double result = Math.sqrt(Math.abs(-a));
        Assert.assertEquals(calc.sqrt(-a), result);
    }
}
