package com.codeexcercise.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.codeexcercise.demo.response.FinalResultResponse;
import com.codeexcercise.demo.service.DemoExcerciseService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CoadingExcerciseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CoadingExcerciseApplication.class, args);
//		DemoExcerciseService bean = run.getBean(DemoExcerciseService.class);
	}

}
