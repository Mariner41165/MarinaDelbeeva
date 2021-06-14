package ru.training.at.hw1.multiplyanddivide;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class DivOfRationalNumbers {
    Calculator calc = new Calculator();

    @Test (groups = {"multiplyanddivide"},
           dataProviderClass = DataProviders.class, dataProvider = "positiveRationalNumbers")
    public void divOfTwoPositiveRationalNumbers(double a, double b) {
        double result = a / b;
        Assert.assertEquals(calc.div(a, b), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "negativeRationalNumbers")
    public void divOfTwoNegativeRationalNumbers(double a, double b) {
        double result = a / b;
        Assert.assertEquals(calc.div(a, b), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "rationalNumberAndZero")
    public void divOfZeroByPositiveRationalNumber(double a, double zero) {
        double result = zero / a;
        Assert.assertEquals(calc.div(zero, a), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "rationalNumberAndZero")
    public void divOfNegativeRationalNumberByZero(double a, double zero) {
        double result = a / zero;
        Assert.assertEquals(calc.div(a, zero), result);
    }
}
