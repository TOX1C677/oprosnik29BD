package main.java.model;

import java.time.LocalDateTime;

public class Response {
    private Long responseId;
    private Long surveyId;
    private String responseToken;
    private LocalDateTime submittedAt;

    // Конструкторы
    public Response() {}

    public Response(Long responseId, Long surveyId, String responseToken, LocalDateTime submittedAt) {
        this.responseId = responseId;
        this.surveyId = surveyId;
        this.responseToken = responseToken;
        this.submittedAt = submittedAt;
    }

    // Геттеры и сеттеры
    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getResponseToken() {
        return responseToken;
    }

    public void setResponseToken(String responseToken) {
        this.responseToken = responseToken;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
