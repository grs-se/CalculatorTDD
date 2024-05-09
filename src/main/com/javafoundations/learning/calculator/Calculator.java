package com.javafoundations.learning.calculator;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Calculator {
    // in TDD do not modify method to accommodate new tests until you have seen the method fail
    // do not run any more code than you absolutely have to
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public String calcAnnuity(String R, int t, String r, int n) {
        BigDecimal a = new BigDecimal(r).divide(new BigDecimal(n));
        BigDecimal b = BigDecimal.ONE.add(a);
        BigDecimal c = b.pow(n * t);
        BigDecimal d = c.subtract(BigDecimal.ONE);
        BigDecimal e = d.divide(a);
        BigDecimal f = e.multiply(new BigDecimal(R));
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        return currencyInstance.format(f);
    }
}
