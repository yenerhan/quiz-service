package com.yener.quiz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yener.quiz.dto.quiz.QuizDTO;
import com.yener.quiz.dto.quiz.SaveQuizResponseDTO;
import com.yener.quiz.dto.quiz.SaveUserQuizResponseDTO;
import com.yener.quiz.dto.quiz.UserAnswerDTO;
import com.yener.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @RequestMapping(value = "/findAllQuizByTestId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    List<QuizDTO> findAllQuizByTestId(@RequestBody Long testId) throws IOException {
        return quizService.findAllQuizByTestId(testId);
    }

    @RequestMapping(value = "/saveQuiz", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    SaveQuizResponseDTO saveQuiz(@RequestBody QuizDTO quizDTO) throws JsonProcessingException {
        return quizService.saveQuiz(quizDTO);
    }

    @RequestMapping(value = "/saveUserAnswer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    SaveUserQuizResponseDTO saveUserAnswer(@RequestBody UserAnswerDTO userAnswerDTO) throws JsonProcessingException {
        return quizService.saveUserAnswer(userAnswerDTO);
    }


}
