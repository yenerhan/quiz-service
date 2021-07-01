package com.yener.quiz.dto.quiz;

public class QuizDTO {
    private Long quizId;
    private String quiz_name;
    private QestionClobDTO qestionClobDTO;
    private String comment;
    private Long testId;
    private Boolean active;

    public QuizDTO() {
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public QestionClobDTO getQestionClobDTO() {
        return qestionClobDTO;
    }

    public void setQestionClobDTO(QestionClobDTO qestionClobDTO) {
        this.qestionClobDTO = qestionClobDTO;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
