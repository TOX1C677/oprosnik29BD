package main.java;

import main.java.app.ConsoleApplication;
import main.java.repository.jdbc.QuestionRepository;
import main.java.repository.SurveyRepository;
import main.java.repository.memory.InMemorySurveyRepository;
import main.java.repository.memory.InMemoryQuestionRepository;
import main.java.service.QuestionService;
import main.java.service.QuestionServiceImpl;
import main.java.service.SurveyService;
import main.java.service.SurveyServiceImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Инициализация репозиториев
        SurveyRepository surveyRepository = new InMemorySurveyRepository();
        QuestionRepository questionRepository = new InMemoryQuestionRepository();

        // Инициализация сервисов
        SurveyService surveyService = new SurveyServiceImpl(surveyRepository);
        QuestionService questionService = new QuestionServiceImpl(questionRepository);

        // Запуск консольного приложения
        ConsoleApplication app = new ConsoleApplication(surveyService, questionService);
        app.run();
    }
}
