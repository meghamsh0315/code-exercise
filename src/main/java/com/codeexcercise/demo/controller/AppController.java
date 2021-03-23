package com.codeexcercise.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeexcercise.demo.response.FinalResultResponse;
import com.codeexcercise.demo.service.DemoExcerciseService;


@RestController
@RequestMapping("/coding/exercise")
public class AppController {
	
	
	@Autowired
	private DemoExcerciseService demoExcerciseService;
	
	@GetMapping(value = "/quiz", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getQuiz()
			throws Exception {

		final FinalResultResponse results = demoExcerciseService.getQuizResults();

		return new ResponseEntity<Object>(results, HttpStatus.OK);
	}

}
