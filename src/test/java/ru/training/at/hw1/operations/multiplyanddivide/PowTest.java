package ru.training.at.hw1.operations.multiplyanddivide;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.dataproviders.NegativeRationalNumbers;
import ru.training.at.hw1.dataproviders.PositiveRationalNumbers;
import ru.training.at.hw1.dataproviders.RationalNumberAndZero;

public class PowTest {
    Calculator calc = new Calculator();

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = PositiveRationalNumbers.class, dataProvider = "positiveRationalNumbers")
    public void powOfPositiveNumberToPositivePower(double a, double b) {
        double result = Math.pow(a, b);
        Assert.assertEquals(calc.div(a, b), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = NegativeRationalNumbers.class, dataProvider = "negativeRationalNumbers")
    public void powPositiveNumberToNegativePower(double a, double b) {
        double result = Math.pow(a, b);
        Assert.assertEquals(calc.div(a, b), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = RationalNumberAndZero.class, dataProvider = "rationalNumberAndZero")
    public void powNumberToZeroPower(double a, double zero) {
        double result = Math.pow(a, zero);
        Assert.assertEquals(calc.div(a, zero), result);
    }

}
