package ru.training.at.hw1.addandsubtract;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class SubOfZeroAndNaturalNumber {
    Calculator calc = new Calculator();

    @Test (groups = {"addAndSubtractTests"},
           dataProviderClass = DataProviders.class, dataProvider = "naturalNumberAndZero")
    public void subZeroFromNaturalNumber(long a, long zero) {
        long result = a - zero;
        Assert.assertEquals(calc.sub(a, zero), result);
    }

    @Test (groups = {"addAndSubtractTests"},
           dataProviderClass = DataProviders.class, dataProvider = "naturalNumberAndZero")
    public void subNaturalNumberFromZero(long a, long zero) {
        long result = zero - a;
        Assert.assertEquals(calc.sub(zero, a), result);
    }
}
