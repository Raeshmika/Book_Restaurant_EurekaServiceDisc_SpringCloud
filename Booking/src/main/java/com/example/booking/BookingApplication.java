package com.example.booking;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper =  new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		return modelMapper;
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}


}
