package ru.training.at.hw1.multiplyanddivide;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class PowTest {
    Calculator calc = new Calculator();

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "positiveRationalNumbers")
    public void powOfPositiveNumberToPositivePower(double a, double b) {
        double result = Math.pow(a, b);
        Assert.assertEquals(calc.div(a, b), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "negativeRationalNumbers")
    public void powPositiveNumberToNegativePower(double a, double b) {
        double result = Math.pow(a, b);
        Assert.assertEquals(calc.div(a, b), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "rationalNumberAndZero")
    public void powNumberToZeroPower(double a, double zero) {
        double result = Math.pow(a, zero);
        Assert.assertEquals(calc.div(a, zero), result);
    }

}
