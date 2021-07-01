package com.yener.quiz.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_generator")
    @SequenceGenerator(name = "test_generator", sequenceName = "test_seq", allocationSize = 1)
    @Column(name = "test_id", nullable = false, precision = 0)
    private Long testId;

    @Column(nullable = false)
    private String test_name;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "test")
    private List<Quiz> quizList = new ArrayList<>();

    public Test() {
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

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }
}
