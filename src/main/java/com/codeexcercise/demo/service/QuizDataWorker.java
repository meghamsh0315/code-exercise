package com.codeexcercise.demo.service;

import java.util.concurrent.Callable;

import org.springframework.web.client.RestTemplate;

import com.codeexcercise.demo.response.QuizResponse;

public class QuizDataWorker implements Callable<QuizResponse>{
	
	String url;
	
	RestTemplate restTemplate;
	
	public QuizDataWorker(String  url, RestTemplate restTemplate) {
		this.url = url;
		this.restTemplate = restTemplate;
	}

	@Override
	public QuizResponse call() throws Exception {
		return restTemplate.getForObject(url, QuizResponse.class);
	}

}
