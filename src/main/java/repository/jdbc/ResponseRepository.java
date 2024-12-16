package main.java.repository.jdbc;

import main.java.model.Response;

import java.util.List;

public interface ResponseRepository {
    void save(Response response);
    Response findById(Long id);
    List<Response> findAllBySurveyId(Long surveyId);
    void update(Response response);
    void delete(Long id);
}

