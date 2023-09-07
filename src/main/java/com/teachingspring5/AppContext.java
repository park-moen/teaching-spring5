package com.teachingspring5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
    @Bean
    public Greeter greeter() {
        Greeter g = new Greeter();
        g.setFormat("%s, 안녕하세용!");

        return g;
    }
}
