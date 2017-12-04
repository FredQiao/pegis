package com.fred.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.fred.multi"})
@SpringBootApplication
public class App {
    public static void main(String[] args){
        System.setProperty("server.port", "8081");
        SpringApplication.run(App.class, args);
    }
}
