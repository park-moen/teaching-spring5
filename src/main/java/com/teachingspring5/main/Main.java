package com.teachingspring5.main;

import com.teachingspring5.config.AppContext;
import com.teachingspring5.spring.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

        Client client = ctx.getBean(Client.class);
        client.send();

        ctx.close();
    }
}
