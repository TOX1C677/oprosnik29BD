package main.java.repository.memory;

import main.java.model.Answer;
import main.java.repository.jdbc.AnswerRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAnswerRepository implements AnswerRepository {
    private List<Answer> answers = new ArrayList<>();
    private long currentId = 1;

    @Override
    public void save(Answer answer) {
        answer.setAnswerId(currentId++);
        answers.add(answer);
    }

    @Override
    public Answer findById(Long id) {
        return answers.stream()
                .filter(a -> a.getAnswerId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Answer> findAllByResponseId(Long responseId) {
        return answers.stream()
                .filter(a -> a.getResponseId().equals(responseId))
                .toList();
    }

    @Override
    public void update(Answer answer) {
        int index = answers.indexOf(findById(answer.getAnswerId()));
        if (index != -1) {
            answers.set(index, answer);
        }
    }

    @Override
    public void delete(Long id) {
        answers.removeIf(a -> a.getAnswerId().equals(id));
    }
}

