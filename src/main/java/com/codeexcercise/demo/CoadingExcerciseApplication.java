package com.codeexcercise.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CoadingExcerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoadingExcerciseApplication.class, args);
	}

}
