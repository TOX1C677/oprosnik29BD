package main.java.repository.memory;
import main.java.repository.jdbc.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryQuestionRepository implements QuestionRepository {
    private List<Question> questions = new ArrayList<>();
    private long currentId = 1;

    @Override
    public void save(Question question) {
        question.setQuestionId(currentId++);
        questions.add(question);
    }

    @Override
    public Question findById(Long id) {
        return questions.stream()
                .filter(q -> q.getQuestionId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Question> findAllBySurveyId(Long surveyId) {
        return questions.stream()
                .filter(q -> q.getSurveyId().equals(surveyId))
                .toList();
    }

    @Override
    public void update(Question question) {
        int index = questions.indexOf(findById(question.getQuestionId()));
        if (index != -1) {
            questions.set(index, question);
        }
    }

    @Override
    public void delete(Long id) {
        questions.removeIf(q -> q.getQuestionId().equals(id));
    }
}
