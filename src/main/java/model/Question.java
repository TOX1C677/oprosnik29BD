package main.java.model;

public class Question {
    private Long questionId;
    private Long surveyId;
    private String text;
    private String type;

    // Конструкторы
    public Question() {}

    public Question(Long questionId, Long surveyId, String text, String type) {
        this.questionId = questionId;
        this.surveyId = surveyId;
        this.text = text;
        this.type = type;
    }

    // Геттеры и сеттеры
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
