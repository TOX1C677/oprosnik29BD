package main.java.repository.jdbc;

import java.util.List;

public interface SurveyRepository {
    void save(Survey survey);
    Survey findById(Long id);
    List<Survey> findAll();
    void update(Survey survey);
    void delete(Long id);
}
