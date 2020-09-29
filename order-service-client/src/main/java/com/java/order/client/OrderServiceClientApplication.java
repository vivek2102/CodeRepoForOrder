package com.java.order.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceClientApplication.class, args);
	}

}
