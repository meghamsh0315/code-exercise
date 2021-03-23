package com.codeexcercise.demo.dto;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "com.codeexcercise.demo")
@Component
public class QuizAppProperties {

	private List<String> downStreams;

	public List<String> getDownStreams() {
		return downStreams;
	}

	public void setDownStreams(List<String> downSteams) {
		this.downStreams = downSteams;
	}
	

	

}
