package main.java.service;
import main.java.model.Survey;
import main.java.repository.SurveyRepository;

import java.util.List;

public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public Survey createSurvey(Survey survey) {
        surveyRepository.save(survey);
        return survey;
    }

    @Override
    public Survey getSurveyById(Long id) {
        return surveyRepository.findById(id);
    }

    @Override
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey updateSurvey(Survey survey) {
        surveyRepository.update(survey);
        return survey;
    }

    @Override
    public void deleteSurvey(Long id) {
        surveyRepository.delete(id);
    }
}
