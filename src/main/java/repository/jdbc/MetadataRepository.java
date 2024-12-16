package main.java.repository.jdbc;

import main.java.model.Metadata;

import java.util.List;

public interface MetadataRepository {
    void save(Metadata metadata);
    Metadata findById(Long id);
    List<Metadata> findAllBySurveyId(Long surveyId);
    void update(Metadata metadata);
    void delete(Long id);
}
