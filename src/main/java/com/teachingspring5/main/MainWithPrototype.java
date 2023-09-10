package com.teachingspring5.main;

import com.teachingspring5.config.AppContextWithPrototype;
import com.teachingspring5.spring.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

public class MainWithPrototype {
    public static void main(String[] args) throws IOException {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContextWithPrototype.class);

        Client client1 = ctx.getBean(Client.class);
        Client client2 = ctx.getBean(Client.class);

        System.out.printf("client1 == client2 : %b", client1 == client2);

        ctx.close();
    }
}
