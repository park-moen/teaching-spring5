package com.teachingspring5.config;

import com.teachingspring5.spring.Client;
import com.teachingspring5.spring.Client2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContextWithPrototype {
    @Bean
    @Scope("prototype")
    public Client client() {
        Client client = new Client();
        client.setHost("host");

        return client;
    }

    @Bean(initMethod = "connect", destroyMethod = "close")
    @Scope("singletone")
    public Client2 client2() {
        Client2 client = new Client2();
        client.setHost("host");
        return client;
    }
}
