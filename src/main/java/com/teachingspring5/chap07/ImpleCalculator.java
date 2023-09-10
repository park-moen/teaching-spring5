package com.teachingspring5.chap07;

public class ImpleCalculator implements Calculator {
    @Override
    public long factorial(long num) {
        long result = 1;

        for (int i = 1; i <= num; i++) {
            result *= i;
        }

        return result;
    }
}
