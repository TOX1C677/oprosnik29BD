package main.java.service;

import main.java.model.Response;

import java.util.List;

public interface ResponseService {
    Response createResponse(Response response);
    Response getResponseById(Long id);
    List<Response> getResponsesBySurveyId(Long surveyId);
    Response updateResponse(Response response);
    void deleteResponse(Long id);
}
