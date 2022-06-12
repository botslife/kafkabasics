package com.dcl.practise.kafka.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApp {

    public static void main(String[] dcl){
        SpringApplication app = new SpringApplication(KafkaApp.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(dcl);
    }

}
