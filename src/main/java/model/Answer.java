package main.java.model;

public class Answer {
    private Long answerId;
    private Long responseId;
    private Long questionId;
    private String answerText;

    // Конструкторы
    public Answer() {}

    public Answer(Long answerId, Long responseId, Long questionId, String answerText) {
        this.answerId = answerId;
        this.responseId = responseId;
        this.questionId = questionId;
        this.answerText = answerText;
    }

    // Геттеры и сеттеры
    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
