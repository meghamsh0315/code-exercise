package com.codeexcercise.demo.response;

import java.util.List;

public class QuizResponse {
	private String response_code;
	private List<Results> results;
	
	
	public String getResponse_code() {
		return response_code;
	}
	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}
	

}
