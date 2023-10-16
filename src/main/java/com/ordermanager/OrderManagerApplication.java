package com.ordermanager;

import org.slf4j.Logger;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;



@SpringBootApplication()
@EnableCaching
@PropertySource("classpath:sender-email.properties")
public class OrderManagerApplication {
	
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(OrderManagerApplication.class);
		
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(OrderManagerApplication.class);

		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
		logger.info("Application Order Manager started;");
	}

}