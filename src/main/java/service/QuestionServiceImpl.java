package main.java.service;

import main.java.model.Question;
import main.java.repository.jdbc.QuestionRepository;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question createQuestion(Question question) {
        questionRepository.save(question);
        return question;
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getQuestionsBySurveyId(Long surveyId) {
        return questionRepository.findAllBySurveyId(surveyId);
    }

    @Override
    public Question updateQuestion(Question question) {
        questionRepository.update(question);
        return question;
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.delete(id);
    }
}
