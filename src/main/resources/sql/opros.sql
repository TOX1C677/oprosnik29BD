-- Отключение проверок уникальности и внешних ключей на время создания таблиц
SET CONSTRAINTS ALL DEFERRED;

-- Создание схемы (если нужно)
CREATE SCHEMA IF NOT EXISTS confectionery_opros;

-- Установка схемы по умолчанию для текущей сессии
SET search_path TO confectionery_opros;

-- Создание таблицы Surveys
CREATE TABLE IF NOT EXISTS Surveys (
                                       survey_id SERIAL PRIMARY KEY,
                                       title VARCHAR(255) NOT NULL,
                                       description TEXT,
                                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                       expires_at TIMESTAMP
);

-- Создание таблицы Questions
CREATE TABLE IF NOT EXISTS Questions (
                                         question_id SERIAL PRIMARY KEY,
                                         survey_id INTEGER NOT NULL,
                                         text TEXT NOT NULL,
                                         type VARCHAR(50) NOT NULL,
                                         FOREIGN KEY (survey_id) REFERENCES Surveys(survey_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы Responses
CREATE TABLE IF NOT EXISTS Responses (
                                         response_id SERIAL PRIMARY KEY,
                                         survey_id INTEGER NOT NULL,
                                         response_token VARCHAR(255) NOT NULL UNIQUE,
                                         submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                         FOREIGN KEY (survey_id) REFERENCES Surveys(survey_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы Answers
CREATE TABLE IF NOT EXISTS Answers (
                                       answer_id SERIAL PRIMARY KEY,
                                       response_id INTEGER NOT NULL,
                                       question_id INTEGER NOT NULL,
                                       answer_text TEXT,
                                       FOREIGN KEY (response_id) REFERENCES Responses(response_id) ON DELETE CASCADE ON UPDATE CASCADE,
                                       FOREIGN KEY (question_id) REFERENCES Questions(question_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание индексов для ускорения поиска в таблице Answers
CREATE INDEX IF NOT EXISTS idx_question_id ON Answers(question_id);
CREATE INDEX IF NOT EXISTS idx_response_id ON Answers(response_id);

-- Создание таблицы Options
CREATE TABLE IF NOT EXISTS Options (
                                       option_id SERIAL PRIMARY KEY,
                                       question_id INTEGER NOT NULL,
                                       option_text TEXT NOT NULL,
                                       FOREIGN KEY (question_id) REFERENCES Questions(question_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы Metadata
CREATE TABLE IF NOT EXISTS Metadata (
                                        metadata_id SERIAL PRIMARY KEY,
                                        survey_id INTEGER NOT NULL,
                                        key VARCHAR(255) NOT NULL,
                                        value TEXT,
                                        FOREIGN KEY (survey_id) REFERENCES Surveys(survey_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Вставка тестовых данных в таблицу Surveys
INSERT INTO Surveys (title, description, expires_at) VALUES
                                                         ('Опрос удовлетворенности продуктом', 'Опрос для оценки удовлетворенности клиентов', '2024-12-31'),
                                                         ('Опрос о качестве обслуживания', 'Собираем отзывы о качестве обслуживания', '2024-11-30'),
                                                         ('Опрос 3', 'Описание опроса 3', '2024-12-23'),
                                                         ('Опрос 4', 'Описание опроса 4', '2024-11-25'),
                                                         ('Опрос 5', 'Описание опроса 5', '2024-10-11');

-- Вставка тестовых данных в таблицу Questions
INSERT INTO Questions (survey_id, text, type) VALUES
                                                  (1, 'Как вы оцениваете наш продукт?', 'multiple_choice'),
                                                  (1, 'Что вам понравилось больше всего?', 'open_text'),
                                                  (2, 'Как вы оцениваете наш сервис?', 'multiple_choice'),
                                                  (2, 'Какие у вас предложения?', 'open_text');

-- Выполнение файла с тестовыми данными Responses
\i 'C:\Users\TOX1C\IdeaProjects\oprosnik29BD\src\responses.sql';

-- Вставка тестовых данных в таблицу Options
INSERT INTO Options (question_id, option_text) VALUES
                                                   (1, 'Отлично'),
                                                   (1, 'Хорошо'),
                                                   (1, 'Удовлетворительно'),
                                                   (1, 'Плохо'),
                                                   (2, 'Отлично'),
                                                   (2, 'Хорошо'),
                                                   (2, 'Удовлетворительно'),
                                                   (2, 'Плохо');

-- Вставка тестовых данных в таблицу Metadata
INSERT INTO Metadata (survey_id, key, value) VALUES
                                                 (1, 'IP Address', '192.168.0.1'),
                                                 (1, 'Browser', 'Chrome'),
                                                 (2, 'IP Address', '192.168.0.2'),
                                                 (2, 'Browser', 'Firefox');

-- Вставка данных в Responses с уникальными токенами, используя UUID
DO $$
    BEGIN
        FOR i IN 1..1000 LOOP
                INSERT INTO Responses (survey_id, response_token)
                VALUES (1, gen_random_uuid()::text);  -- Генерация уникального токена
            END LOOP;
    END $$;

-- Дополнительные запросы для изменения данных
-- Обновление данных в таблице Surveys
UPDATE Surveys
SET title = 'Опрос по качеству обслуживания'
WHERE survey_id = 1;

-- Удаление вопроса из таблицы Questions
DELETE FROM Questions
WHERE question_id = 1;

-- Дополнительные запросы для поиска
-- Поиск всех респондентов, которые приняли участие в опросе
SELECT r.response_token
FROM Responses r
         JOIN Surveys s ON r.survey_id = s.survey_id
WHERE s.survey_id = 1;

-- Поиск всех ответов на конкретный вопрос
SELECT a.answer_text
FROM Answers a
         JOIN Questions q ON a.question_id = q.question_id
WHERE q.survey_id = 1
  AND q.text = 'Как вы оцениваете наш продукт?';

-- Дополнительные запросы для получения сводной информации
-- Количество респондентов в опросе
SELECT COUNT(*) AS total_responses
FROM Responses
WHERE survey_id = 1;

-- Статистика: распределение ответов на множественный выбор
SELECT o.option_text, COUNT(*) AS response_count
FROM Answers a
         JOIN Options o ON a.answer_text = o.option_text
WHERE o.question_id = 1
GROUP BY o.option_text;

-- Включение проверок после создания таблиц
SET CONSTRAINTS ALL IMMEDIATE;
