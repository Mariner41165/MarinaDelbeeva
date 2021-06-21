package ru.training.at.hw1.operations.multiplyanddivide;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.NegativeRationalNumbers;
import ru.training.at.hw1.dataproviders.PositiveRationalNumbers;
import ru.training.at.hw1.dataproviders.RationalNumberAndZero;

public class DivOfRationalNumbers {
    Calculator calc = new Calculator();

    @Test (groups = {"multiplyanddivide"},
           dataProviderClass = PositiveRationalNumbers.class, dataProvider = "positiveRationalNumbers")
    public void divOfTwoPositiveRationalNumbers(double a, double b) {
        double result = a / b;
        Assert.assertEquals(calc.div(a, b), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = NegativeRationalNumbers.class, dataProvider = "negativeRationalNumbers")
    public void divOfTwoNegativeRationalNumbers(double a, double b) {
        double result = a / b;
        Assert.assertEquals(calc.div(a, b), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = RationalNumberAndZero.class, dataProvider = "rationalNumberAndZero")
    public void divOfZeroByPositiveRationalNumber(double a, double zero) {
        double result = zero / a;
        Assert.assertEquals(calc.div(zero, a), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = RationalNumberAndZero.class, dataProvider = "rationalNumberAndZero")
    public void divOfNegativeRationalNumberByZero(double a, double zero) {
        double result = a / zero;
        Assert.assertEquals(calc.div(a, zero), result);
    }
}
