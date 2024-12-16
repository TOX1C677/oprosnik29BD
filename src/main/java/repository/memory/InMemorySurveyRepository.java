package main.java.repository.memory;

import main.java.model.Survey;
import main.java.repository.jdbc.SurveyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemorySurveyRepository implements SurveyRepository {
    private List<Survey> surveys = new ArrayList<>();
    private long currentId = 1;

    @Override
    public void save(Survey survey) {
        survey.setSurveyId(currentId++);
        surveys.add(survey);
    }

    @Override
    public Survey findById(Long id) {
        return surveys.stream()
                .filter(s -> s.getSurveyId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Survey> findAll() {
        return new ArrayList<>(surveys);
    }

    @Override
    public void update(Survey survey) {
        int index = surveys.indexOf(findById(survey.getSurveyId()));
        if (index != -1) {
            surveys.set(index, survey);
        }
    }

    @Override
    public void delete(Long id) {
        surveys.removeIf(s -> s.getSurveyId().equals(id));
    }
}
