package main.java.repository;

import main.java.model.Survey;

import java.util.List;

public interface SurveyRepository {
    void save(Survey survey);
    Survey findById(Long id);
    List<Survey> findAll();
    void update(Survey survey);
    void delete(Long id);
}
