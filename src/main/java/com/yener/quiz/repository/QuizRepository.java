package com.yener.quiz.repository;

import com.yener.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {

    List<Quiz> findQuizByTestTestId(Long testId);

    Quiz findQuizByQuizId(Long quizId);


}
