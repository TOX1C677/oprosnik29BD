package main.java.service;

import main.java.model.Survey;

import java.util.List;

public interface SurveyService {
    Survey createSurvey(Survey survey);
    Survey getSurveyById(Long id);
    List<Survey> getAllSurveys();
    Survey updateSurvey(Survey survey);
    void deleteSurvey(Long id);
}

