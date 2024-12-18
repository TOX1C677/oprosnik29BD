package main.java.service;

import main.java.model.Answer;

import java.util.List;

public interface AnswerService {
    Answer createAnswer(Answer answer);
    Answer getAnswerById(Long id);
    List<Answer> getAnswersByResponseId(Long responseId);
    Answer updateAnswer(Answer answer);
    void deleteAnswer(Long id);
}
