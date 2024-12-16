package main.java.app;

import main.java.model.Question;
import main.java.model.Survey;
import main.java.service.QuestionService;
import main.java.service.SurveyService;

import java.util.Scanner;

public class ConsoleApplication {
    private final SurveyService surveyService;
    private final QuestionService questionService;

    public ConsoleApplication(SurveyService surveyService, QuestionService questionService) {
        this.surveyService = surveyService;
        this.questionService = questionService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Опросник ===");
            System.out.println("1. Список опросов");
            System.out.println("2. Создать опрос");
            System.out.println("3. Редактировать опрос");
            System.out.println("4. Удалить опрос");
            System.out.println("5. Вопросы опроса");
            System.out.println("6. Добавить вопрос");
            System.out.println("0. Выход");
            System.out.print("Введите номер действия: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Пропустить оставшийся newline

            switch (choice) {
                case 1 -> listSurveys();
                case 2 -> createSurvey(scanner);
                case 3 -> editSurvey(scanner);
                case 4 -> deleteSurvey(scanner);
                case 5 -> listQuestions(scanner);
                case 6 -> addQuestion(scanner);
                case 0 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void listSurveys() {
        var surveys = surveyService.getAllSurveys();
        if (surveys.isEmpty()) {
            System.out.println("Опросов пока нет.");
        } else {
            System.out.println("=== Список опросов ===");
            for (Survey survey : surveys) {
                System.out.printf("ID: %d | Название: %s | Описание: %s\n",
                        survey.getSurveyId(), survey.getTitle(), survey.getDescription());
            }
        }
    }

    private void createSurvey(Scanner scanner) {
        System.out.print("Введите название опроса: ");
        String title = scanner.nextLine();
        System.out.print("Введите описание опроса: ");
        String description = scanner.nextLine();
        Survey survey = new Survey(null, title, description, null, null);
        surveyService.createSurvey(survey);
        System.out.println("Опрос успешно создан.");
    }

    private void editSurvey(Scanner scanner) {
        System.out.print("Введите ID опроса для редактирования: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Пропустить оставшийся newline
        Survey survey = surveyService.getSurveyById(id);
        if (survey == null) {
            System.out.println("Опрос с таким ID не найден.");
            return;
        }
        System.out.print("Введите новое название опроса: ");
        String title = scanner.nextLine();
        System.out.print("Введите новое описание опроса: ");
        String description = scanner.nextLine();
        survey.setTitle(title);
        survey.setDescription(description);
        surveyService.updateSurvey(survey);
        System.out.println("Опрос успешно обновлен.");
    }

    private void deleteSurvey(Scanner scanner) {
        System.out.print("Введите ID опроса для удаления: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Пропустить оставшийся newline
        surveyService.deleteSurvey(id);
        System.out.println("Опрос успешно удален.");
    }

    private void listQuestions(Scanner scanner) {
        System.out.print("Введите ID опроса для просмотра вопросов: ");
        Long surveyId = scanner.nextLong();
        scanner.nextLine(); // Пропустить оставшийся newline
        var questions = questionService.getQuestionsBySurveyId(surveyId);
        if (questions.isEmpty()) {
            System.out.println("В этом опросе пока нет вопросов.");
        } else {
            System.out.println("=== Вопросы опроса ===");
            for (Question question : questions) {
                System.out.printf("ID: %d | Текст: %s | Тип: %s\n",
                        question.getQuestionId(), question.getText(), question.getType());
            }
        }
    }

    private void addQuestion(Scanner scanner) {
        System.out.print("Введите ID опроса: ");
        Long surveyId = scanner.nextLong();
        scanner.nextLine(); // Пропустить оставшийся newline
        System.out.print("Введите текст вопроса: ");
        String text = scanner.nextLine();
        System.out.print("Введите тип вопроса (например, multiple_choice, open_text): ");
        String type = scanner.nextLine();
        Question question = new Question(null, surveyId, text, type);
        questionService.createQuestion(question);
        System.out.println("Вопрос успешно добавлен.");
    }
}
