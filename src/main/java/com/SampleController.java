package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableScheduling
public class SampleController extends WebMvcConfigurerAdapter{
	 
	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(SampleController.class, args);
	    }
	    @Override
		  public void addCorsMappings(CorsRegistry registry) {
		    registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods("POST","GET", "OPTIONS", "DELETE").allowedHeaders("x-requested-with");
		  }
}
