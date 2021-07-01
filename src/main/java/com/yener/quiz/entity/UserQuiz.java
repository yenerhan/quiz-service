package com.yener.quiz.entity;

import javax.persistence.*;

@Entity(name = "userquiz")
public class UserQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userquiz_generator")
    @SequenceGenerator(name = "userquiz_generator", sequenceName = "userquiz_seq", allocationSize = 1)
    @Column(name = "userquiz_id", nullable = false, precision = 0)
    private Long userquizId;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private String answerSheet;

    @Column(nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public UserQuiz() {
    }


    public Long getUserquizId() {
        return userquizId;
    }

    public void setUserquizId(Long userquizId) {
        this.userquizId = userquizId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
