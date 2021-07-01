package com.yener.quiz.repository;

import com.yener.quiz.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    Test findTestByTestId(Long testId);

}
