package main.java.service;

import main.java.model.Response;
import main.java.repository.jdbc.ResponseRepository;

import java.util.List;

public class ResponseServiceImpl implements ResponseService {
    private final ResponseRepository responseRepository;

    public ResponseServiceImpl(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public Response createResponse(Response response) {
        responseRepository.save(response);
        return response;
    }

    @Override
    public Response getResponseById(Long id) {
        return responseRepository.findById(id);
    }

    @Override
    public List<Response> getResponsesBySurveyId(Long surveyId) {
        return responseRepository.findAllBySurveyId(surveyId);
    }

    @Override
    public Response updateResponse(Response response) {
        responseRepository.update(response);
        return response;
    }

    @Override
    public void deleteResponse(Long id) {
        responseRepository.delete(id);
    }
}
