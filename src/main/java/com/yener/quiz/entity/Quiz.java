package com.yener.quiz.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_generator")
    @SequenceGenerator(name = "quiz_generator", sequenceName = "quiz_seq", allocationSize = 1)
    @Column(name = "quiz_id", nullable = false, precision = 0)
    private Long quizId;

    @Column(nullable = false)
    private String quiz_name;

    @Basic(optional = false)
    @NotNull
    @Column(columnDefinition = "text")
    private String questionClob;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "quiz")
    private List<UserQuiz> userQuizList = new ArrayList<>();

    public Quiz() {
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

    public String getQuestionClob() {
        return questionClob;
    }

    public void setQuestionClob(String questionClob) {
        this.questionClob = questionClob;
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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<UserQuiz> getUserQuizList() {
        return userQuizList;
    }

    public void setUserQuizList(List<UserQuiz> userQuizList) {
        this.userQuizList = userQuizList;
    }
}
