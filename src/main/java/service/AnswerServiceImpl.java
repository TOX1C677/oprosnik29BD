package main.java.service;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer createAnswer(Answer answer) {
        answerRepository.save(answer);
        return answer;
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public List<Answer> getAnswersByResponseId(Long responseId) {
        return answerRepository.findAllByResponseId(responseId);
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        answerRepository.update(answer);
        return answer;
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.delete(id);
    }
}
