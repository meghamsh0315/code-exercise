/**
 * 
 */
package com.codeexcercise.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codeexcercise.demo.response.FinalResultResponse;
import com.codeexcercise.demo.response.Quiz;
import com.codeexcercise.demo.response.QuizResponse;
import com.codeexcercise.demo.response.QuizResult;
import com.codeexcercise.demo.response.Results;

/**
 * @author Meghamsh
 *
 */
@Service
public class DemoExcerciseServiceImpl implements DemoExcerciseService {

	@Override
	public FinalResultResponse getQuizResults() {
		System.out.println("entered into getQuizResults");

		final String uri1 = "https://opentdb.com/api.php?amount=5&category=11";
		final String uri2 = "https://opentdb.com/api.php?amount=5&category=12";

//		final String uri2 = "https://opentdb.com/api.php?amount="+amount+"&category="+category;

		RestTemplate restTemplate = new RestTemplate();
		QuizResponse result = restTemplate.getForObject(uri1, QuizResponse.class);
		QuizResponse result2 = restTemplate.getForObject(uri2, QuizResponse.class);

		FinalResultResponse finalResult = new FinalResultResponse();

		buildResponse(result, result2, finalResult);

		return finalResult;
	}

	private void buildResponse(QuizResponse result, QuizResponse result2, FinalResultResponse finalResult) {
		if (result != null) {
			List<Quiz> quizList = new ArrayList();
			Quiz quiz = new Quiz();
			String category = "";
			if (result.getResults() != null && result.getResults().size() > 0) {
				List<QuizResult> filmQuizResult = new ArrayList();
				for (Results res : result.getResults()) {
					category = res.getCategory();
					if (category.contains("Film")) {
						QuizResult qz = new QuizResult();
						qz.setType(res.getType());
						qz.setDifficulty(res.getDifficulty());
						qz.setQuestion(res.getQuestion());
						qz.setCorrect_answer(res.getCorrect_answer());
						List<String> listAllAnswers = new ArrayList();
						listAllAnswers.addAll(res.getIncorrect_answers());
						if (!listAllAnswers.contains(res.getCorrect_answer())) {
							listAllAnswers.add(res.getCorrect_answer());
						}
						qz.setAll_answers(listAllAnswers);
						filmQuizResult.add(qz);
					}
				}
				if (category.contains("Film")) {
					quiz.setCategory(category);
					quiz.setResults(filmQuizResult);
				}
			}
			if (quiz != null && quiz.getResults() != null) {
				quizList.add(quiz);
			}
			quiz = new Quiz();
			if (result.getResults() != null && result.getResults().size() > 0) {
				List<QuizResult> filmQuizResult = new ArrayList();
				for (Results res : result.getResults()) {

					category = res.getCategory();

					if (category.contains("Music")) {
						QuizResult qz = new QuizResult();
						qz.setType(res.getType());
						qz.setDifficulty(res.getDifficulty());
						qz.setQuestion(res.getQuestion());
						qz.setCorrect_answer(res.getCorrect_answer());
						List<String> listAllAnswers = new ArrayList();
						listAllAnswers = new ArrayList();
						listAllAnswers.addAll(res.getIncorrect_answers());
						if (!listAllAnswers.contains(res.getCorrect_answer())) {
							listAllAnswers.add(res.getCorrect_answer());
						}
						qz.setAll_answers(listAllAnswers);

						filmQuizResult.add(qz);
					}

				}
				if (category.contains("Music")) {
					quiz.setCategory(category);
					quiz.setResults(filmQuizResult);
				}

			}

			if (quiz != null && quiz.getResults() != null) {
				quizList.add(quiz);
			}

			if (result2.getResults() != null && result2.getResults().size() > 0) {
				List<QuizResult> filmQuizResult = new ArrayList();
				for (Results res : result2.getResults()) {
					category = res.getCategory();
					if (category.contains("Film")) {
						QuizResult qz = new QuizResult();
						qz.setType(res.getType());
						qz.setDifficulty(res.getDifficulty());
						qz.setQuestion(res.getQuestion());
						qz.setCorrect_answer(res.getCorrect_answer());
						List<String> listAllAnswers = new ArrayList();
						listAllAnswers.addAll(res.getIncorrect_answers());
						if (!listAllAnswers.contains(res.getCorrect_answer())) {
							listAllAnswers.add(res.getCorrect_answer());
						}
						qz.setAll_answers(listAllAnswers);
						filmQuizResult.add(qz);
					}
				}
				if (category.contains("Film")) {
					quiz.setCategory(category);
					quiz.setResults(filmQuizResult);
				}
			}
			if (quiz != null && quiz.getResults() != null) {
				quizList.add(quiz);
			}
			quiz = new Quiz();
			if (result2.getResults() != null && result2.getResults().size() > 0) {
				List<QuizResult> filmQuizResult = new ArrayList();
				for (Results res : result2.getResults()) {

					category = res.getCategory();

					if (category.contains("Music")) {
						QuizResult qz = new QuizResult();
						qz.setType(res.getType());
						qz.setDifficulty(res.getDifficulty());
						qz.setQuestion(res.getQuestion());
						qz.setCorrect_answer(res.getCorrect_answer());
						List<String> listAllAnswers = new ArrayList();
						listAllAnswers = new ArrayList();
						listAllAnswers.addAll(res.getIncorrect_answers());
						if (!listAllAnswers.contains(res.getCorrect_answer())) {
							listAllAnswers.add(res.getCorrect_answer());
						}
						qz.setAll_answers(listAllAnswers);

						filmQuizResult.add(qz);
					}

				}
				if (category.contains("Music")) {
					quiz.setCategory(category);
					quiz.setResults(filmQuizResult);
				}

			}

			if (quiz != null && quiz.getResults() != null) {
				quizList.add(quiz);
			}

			finalResult.setQuiz(quizList);

		}

	}
}