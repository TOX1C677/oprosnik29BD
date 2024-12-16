package main.java.repository.memory;
import main.java.repository.jdbc.ResponseRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryResponseRepository implements ResponseRepository {
    private List<Response> responses = new ArrayList<>();
    private long currentId = 1;

    @Override
    public void save(Response response) {
        response.setResponseId(currentId++);
        responses.add(response);
    }

    @Override
    public Response findById(Long id) {
        return responses.stream()
                .filter(r -> r.getResponseId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Response> findAllBySurveyId(Long surveyId) {
        return responses.stream()
                .filter(r -> r.getSurveyId().equals(surveyId))
                .toList();
    }

    @Override
    public void update(Response response) {
        int index = responses.indexOf(findById(response.getResponseId()));
        if (index != -1) {
            responses.set(index, response);
        }
    }

    @Override
    public void delete(Long id) {
        responses.removeIf(r -> r.getResponseId().equals(id));
    }
}

