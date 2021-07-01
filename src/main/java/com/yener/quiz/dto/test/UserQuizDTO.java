package com.yener.quiz.dto.test;

import com.yener.quiz.dto.quiz.QestionClobDTO;

public class UserQuizDTO {
    private Long testId;
    private String test_name;
    private QestionClobDTO qestionClobDTO;
    private String comment;
    private Boolean active;
    private Integer userScore;
    private Boolean completed;

    public UserQuizDTO() {
    }


    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
