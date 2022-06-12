package com.dcl.practise.kafka.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.KafkaListenerEndpointRegistrar;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Service;

@Service
public class ProduceAndConsume {

    @Autowired
    private final Producer producer;

    @Autowired
    private final KafkaListenerEndpointRegistrar kafkaListenerEndpointRegistrar;

    @Autowired
    ProduceAndConsume(Producer producer,KafkaListenerEndpointRegistrar kafkaListenerEndpointRegistrar){
        this.producer = producer;
        this.kafkaListenerEndpointRegistrar = kafkaListenerEndpointRegistrar;
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean(){
        return (args) -> {
            for (String arg : args) {
                switch (arg) {
                    case "--producer" -> {
                        this.producer.sendMessage("awalther", "t-shirts");
                        this.producer.sendMessage("htanaka", "t-shirts");
                        this.producer.sendMessage("htanaka", "batteries");
                        this.producer.sendMessage("eabara", "t-shirts");
                        this.producer.sendMessage("htanaka", "t-shirts");
                        this.producer.sendMessage("jsmith", "book");
                        this.producer.sendMessage("awalther", "t-shirts");
                        this.producer.sendMessage("jsmith", "batteries");
                        this.producer.sendMessage("jsmith", "gift card");
                        this.producer.sendMessage("eabara", "t-shirts");
                    }
                    case "--consumer" -> {
                        MessageListenerContainer listenerContainer = kafkaListenerEndpointRegistrar.getEndpointRegistry().getListenerContainer("myConsumer");
                        listenerContainer.start();
                    }
                    default -> {
                    }
                }
            }
        };
    }

}
