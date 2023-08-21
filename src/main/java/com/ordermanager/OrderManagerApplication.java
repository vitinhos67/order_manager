package com.ordermanager;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class OrderManagerApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(OrderManagerApplication.class);
		
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
		
		
	}

}