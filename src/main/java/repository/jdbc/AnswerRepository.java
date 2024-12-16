package main.java.repository.jdbc;

import main.java.model.Answer;

import java.util.List;

public interface AnswerRepository {
    void save(Answer answer);
    Answer findById(Long id);
    List<Answer> findAllByResponseId(Long responseId);
    void update(Answer answer);
    void delete(Long id);
}

