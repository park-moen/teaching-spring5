package com.teachingspring5.main;

import com.teachingspring5.chap07.ExeTimeCalculator;
import com.teachingspring5.chap07.ImpleCalculator;
import com.teachingspring5.chap07.RecCalculator;

public class MainProxy {
    public static void main(String[] args) {
        ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpleCalculator());
        System.out.println(ttCal1.factorial(20));

        ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
        System.out.println(ttCal2.factorial(20));
    }
}
