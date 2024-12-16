package main.java.repository.jdbc;

import main.java.model.Option;
import java.util.List;

public interface OptionRepository {
    void save(Option option);
    Option findById(Long id);
    List<Option> findAllByQuestionId(Long questionId);
    void update(Option option);
    void delete(Long id);
}
