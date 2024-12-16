package main.java.model;

import java.time.LocalDateTime;

public class Survey {
    private Long surveyId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    // Конструкторы
    public Survey() {}

    public Survey(Long surveyId, String title, String description, LocalDateTime createdAt, LocalDateTime expiresAt) {
        this.surveyId = surveyId;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    // Геттеры и сеттеры
    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
