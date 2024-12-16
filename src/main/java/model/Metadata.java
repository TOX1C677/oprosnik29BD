package main.java.model;

public class Metadata {
    private Long metadataId;
    private Long surveyId;
    private String key;
    private String value;

    // Конструкторы
    public Metadata() {}

    public Metadata(Long metadataId, Long surveyId, String key, String value) {
        this.metadataId = metadataId;
        this.surveyId = surveyId;
        this.key = key;
        this.value = value;
    }

    // Геттеры и сеттеры
    public Long getMetadataId() {
        return metadataId;
    }

    public void setMetadataId(Long metadataId) {
        this.metadataId = metadataId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

