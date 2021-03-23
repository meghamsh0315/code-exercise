/**
 * 
 */
package com.codeexcercise.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codeexcercise.demo.dto.QuizAppProperties;
import com.codeexcercise.demo.response.FinalResultResponse;
import com.codeexcercise.demo.response.Quiz;
import com.codeexcercise.demo.response.QuizResponse;
import com.codeexcercise.demo.response.QuizResult;
import com.codeexcercise.demo.response.Results;

/**
 * @author Megamsh
 *
 */
@Service
public class DemoExcerciseServiceImpl implements DemoExcerciseService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	QuizAppProperties props;

	@Override
	public FinalResultResponse getQuizResults() {

		int size = props.getDownStreams().size();
		List<Future<QuizResponse>> futureList = new ArrayList<>(size);
		
		List<QuizResponse> responseList = new ArrayList<>(size);

		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (String url : props.getDownStreams()) {
			futureList.add(cachedThreadPool.submit(new QuizDataWorker(url, restTemplate)));
		}
		
		for(Future<QuizResponse> futre: futureList) {
			try {
				QuizResponse quizResponse = futre.get();
				System.out.println("resp"+ quizResponse);
				responseList.add(quizResponse);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		
		Map<String, List<Results>> collect = responseList.stream().
		filter(resp -> Integer.parseInt(resp.getResponse_code()) == 0)
		.flatMap(val-> val.getResults().stream())
		.collect(Collectors.groupingBy(Results::getCategory));
		
		System.out.println(collect);
	
		FinalResultResponse finalResult = new FinalResultResponse();

		buildResponse(responseList, finalResult);
		return finalResult;
	}
	
	private void buildResponse(List<QuizResponse> result, FinalResultResponse finalResult){
		String category = "";
		List<Quiz> quizList = new ArrayList();
		if(result != null && result.size() > 0) {
			for(QuizResponse  response: result) {
				Quiz quiz = new Quiz();
				if(Integer.parseInt(response.getResponse_code())==0) {
					response.getResults();
					if (response.getResults() != null && response.getResults().size() > 0) {
						List<QuizResult> filmQuizResult = new ArrayList();
						List<QuizResult> musicQuizResult = new ArrayList();
						for (Results res : response.getResults()) {
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
							}else if (category.contains("Music")) {
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
								musicQuizResult.add(qz);
							}
						}
						if (category.contains("Film")) {
							quiz.setCategory(category);
							quiz.setResults(filmQuizResult);
							quizList.add(quiz);
						}
						if (category.contains("Music")) {
							quiz.setCategory(category);
							quiz.setResults(musicQuizResult);
							quizList.add(quiz);
						}
					}
				}
			}
			
			finalResult.setQuiz(quizList);
		}
	}

	

}
