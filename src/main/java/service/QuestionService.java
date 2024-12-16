package main.java.service;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);
    Question getQuestionById(Long id);
    List<Question> getQuestionsBySurveyId(Long surveyId);
    Question updateQuestion(Question question);
    void deleteQuestion(Long id);
}
