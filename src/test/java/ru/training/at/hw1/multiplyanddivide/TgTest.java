package ru.training.at.hw1.multiplyanddivide;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class TgTest {
    Calculator calc = new Calculator();

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "rationalNumber")
    public void tgOfPositiveNumber(double a) {
        double result = Math.tan(a);
        Assert.assertEquals(calc.tg(a), result);
    }

    @Test (groups = {"multiplyAndDivideTests"},
           dataProviderClass = DataProviders.class, dataProvider = "rationalNumber")
    public void tgOfNegativeNumber(double a) {
        double result = Math.tan(-a);
        Assert.assertEquals(calc.tg(-a), result);
    }

}
