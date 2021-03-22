package com.codeexcercise.demo.response;

import java.util.List;

public class Quiz {
	private String category;
	private List<QuizResult> results;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<QuizResult> getResults() {
		return results;
	}
	public void setResults(List<QuizResult> results) {
		this.results = results;
	}

}
