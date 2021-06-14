package ru.training.at.hw1.multiplyanddivide;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class CtgTest {
    Calculator calc = new Calculator();

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "rationalNumber")
    public void ctgOfPositiveNumber(double a) {
        double result = 1.0 / Math.tan(a);
        Assert.assertEquals(calc.ctg(a), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "rationalNumber")
    public void ctgOfNegativeNumber(double a) {
        double result = -1.0 / Math.tan(a);
        Assert.assertEquals(calc.ctg(a), result);
    }

}
