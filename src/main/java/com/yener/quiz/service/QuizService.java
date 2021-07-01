package com.yener.quiz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yener.quiz.base.enums.MessageTypeENUM;
import com.yener.quiz.base.util.Message;
import com.yener.quiz.dto.quiz.*;
import com.yener.quiz.entity.Quiz;
import com.yener.quiz.entity.User;
import com.yener.quiz.entity.UserQuiz;
import com.yener.quiz.repository.QuizRepository;
import com.yener.quiz.repository.TestRepository;
import com.yener.quiz.repository.UserQuizRepository;
import com.yener.quiz.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserQuizRepository userQuizRepository;

    @Autowired
    private TestRepository testRepository;

    public List<QuizDTO> findAllQuizByTestId(Long testId) throws IOException {
        List<Quiz> quizList = quizRepository.findQuizByTestTestId(testId);
        List<QuizDTO> quizDTOList = new ArrayList<>();
        for (Quiz quiz : quizList) {
            QuizDTO quizDTO = new QuizDTO();
            BeanUtils.copyProperties(quiz, quizDTO);
            quizDTO.setTestId(quiz.getTest().getTestId());
            quizDTO.setQestionClobDTO(objectMapper.readValue(quiz.getQuestionClob(), QestionClobDTO.class));
            quizDTOList.add(quizDTO);
        }
        return quizDTOList;
    }


    public SaveQuizResponseDTO saveQuiz(QuizDTO quizDTO) throws JsonProcessingException {
        Quiz quiz = new Quiz();
        BeanUtils.copyProperties(quizDTO, quiz);
        quiz.setTest(testRepository.findTestByTestId(quizDTO.getTestId()));
        quiz.setQuestionClob(objectMapper.writeValueAsString(quizDTO.getQestionClobDTO()));
        quiz = quizRepository.save(quiz);
        SaveQuizResponseDTO saveQuizResponseDTO = new SaveQuizResponseDTO();
        if (quiz.getQuizId() != null) {
            List<Message> messageList = new ArrayList();
            messageList.add(new Message(MessageTypeENUM.SUCCESS, "Kayıt Başarılı"));
            saveQuizResponseDTO.setMessageList(messageList);
        }
        return saveQuizResponseDTO;
    }

    public SaveUserQuizResponseDTO saveUserAnswer(UserAnswerDTO userAnswerDTO) {
        UserQuiz userQuiz = new UserQuiz();
        BeanUtils.copyProperties(userAnswerDTO, userQuiz);
        userQuiz.setQuiz(quizRepository.findQuizByQuizId(userAnswerDTO.getQuizId()));
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findUserByEmail(email);
        userQuiz.setUserId(user.getUserId());
        userQuiz = userQuizRepository.save(userQuiz);
        SaveUserQuizResponseDTO saveUserQuizResponseDTO = new SaveUserQuizResponseDTO();
        if (userQuiz.getUserquizId() != null) {
            List<Message> messageList = new ArrayList();
            messageList.add(new Message(MessageTypeENUM.SUCCESS, "Kayıt Başarılı"));
            saveUserQuizResponseDTO.setMessageList(messageList);
        }
        return saveUserQuizResponseDTO;
    }
}
