package com.kafkastreamingdemo.kafkatwitterconsumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@EnableKafka
public class KafkaTwitterConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTwitterConsumerDemoApplication.class, args);
	}

}
