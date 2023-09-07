package com.teachingspring5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TeachingSpring5Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

        Greeter g = ctx.getBean("greeter", Greeter.class);
        String massage = g.greet("Spring");

        System.out.println(massage);
        ctx.close();
    }

}
