package main.java.model;

public class Option {
    private Long optionId;
    private Long questionId;
    private String optionText;

    // Конструкторы
    public Option() {}

    public Option(Long optionId, Long questionId, String optionText) {
        this.optionId = optionId;
        this.questionId = questionId;
        this.optionText = optionText;
    }

    // Геттеры и сеттеры
    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }
}