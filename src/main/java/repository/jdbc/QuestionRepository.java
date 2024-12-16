package main.java.repository.jdbc;

import main.java.model.Question;

import java.util.List;

public interface QuestionRepository {
    void save(Question question);
    Question findById(Long id);
    List<Question> findAllBySurveyId(Long surveyId);
    void update(Question question);
    void delete(Long id);
}

