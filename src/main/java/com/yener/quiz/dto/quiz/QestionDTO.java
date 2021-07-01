package com.yener.quiz.dto.quiz;

public class QestionDTO {

    private Long id;
    private String questionText;
    private String choice_a;
    private String choice_b;
    private String choice_c;
    private String choice_d;
    private String choice_e;
    private String correctAnswer;
    private Boolean active;

    public QestionDTO() {
    }

    public QestionDTO(Long id, String questionText, String choice_a, String choice_b, String choice_c, String choice_d, String choice_e, String correctAnswer, Boolean active) {
        this.id = id;
        this.questionText = questionText;
        this.choice_a = choice_a;
        this.choice_b = choice_b;
        this.choice_c = choice_c;
        this.choice_d = choice_d;
        this.choice_e = choice_e;
        this.correctAnswer = correctAnswer;

        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getChoice_a() {
        return choice_a;
    }

    public void setChoice_a(String choice_a) {
        this.choice_a = choice_a;
    }

    public String getChoice_b() {
        return choice_b;
    }

    public void setChoice_b(String choice_b) {
        this.choice_b = choice_b;
    }

    public String getChoice_c() {
        return choice_c;
    }

    public void setChoice_c(String choice_c) {
        this.choice_c = choice_c;
    }

    public String getChoice_d() {
        return choice_d;
    }

    public void setChoice_d(String choice_d) {
        this.choice_d = choice_d;
    }

    public String getChoice_e() {
        return choice_e;
    }

    public void setChoice_e(String choice_e) {
        this.choice_e = choice_e;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
