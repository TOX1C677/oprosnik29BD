package main.java.repository.memory;

import main.java.repository.jdbc.OptionRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOptionRepository implements OptionRepository {
    private List<Option> options = new ArrayList<>();
    private long currentId = 1;

    @Override
    public void save(Option option) {
        option.setOptionId(currentId++);
        options.add(option);
    }

    @Override
    public Option findById(Long id) {
        return options.stream()
                .filter(o -> o.getOptionId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Option> findAllByQuestionId(Long questionId) {
        return options.stream()
                .filter(o -> o.getQuestionId().equals(questionId))
                .toList();
    }

    @Override
    public void update(Option option) {
        int index = options.indexOf(findById(option.getOptionId()));
        if (index != -1) {
            options.set(index, option);
        }
    }

    @Override
    public void delete(Long id) {
        options.removeIf(o -> o.getOptionId().equals(id));
    }
}
