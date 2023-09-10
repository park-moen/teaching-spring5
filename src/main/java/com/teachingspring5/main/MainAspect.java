package com.teachingspring5.main;

import com.teachingspring5.chap07.Calculator;
import com.teachingspring5.chap07.RecCalculator;
import com.teachingspring5.config.AppContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

        Calculator calculator = ctx.getBean("calculator", Calculator.class);
        long fiveFact = calculator.factorial(5);

        System.out.println("calculator.factorial(5) = " + fiveFact);
        System.out.println(calculator.getClass().getName());

        ctx.close();
    }
}
