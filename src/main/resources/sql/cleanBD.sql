-- Удаление существующих таблиц
DROP TABLE IF EXISTS Answers, Responses, Questions, Surveys, Options, Metadata CASCADE;

-- Создание схемы (если нужно)
CREATE SCHEMA IF NOT EXISTS confectionery_opros;

-- Установка схемы по умолчанию для текущей сессии
SET search_path TO confectionery_opros;

-- Далее ваш скрипт для создания таблиц и вставки данных
