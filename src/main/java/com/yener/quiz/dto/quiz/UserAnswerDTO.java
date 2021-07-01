package com.yener.quiz.dto.quiz;

public class UserAnswerDTO {
    private Long quizId;
    private Integer score;
    private String answerSheet;


    public UserAnswerDTO() {
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAnswerSheet() {
        return answerSheet;
    }

    public void setAnswerSheet(String answerSheet) {
        this.answerSheet = answerSheet;
    }
}
