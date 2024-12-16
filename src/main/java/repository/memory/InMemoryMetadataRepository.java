package main.java.repository.memory;

import main.java.model.Metadata;
import main.java.repository.jdbc.MetadataRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMetadataRepository implements MetadataRepository {
    private List<Metadata> metadataList = new ArrayList<>();
    private long currentId = 1;

    @Override
    public void save(Metadata metadata) {
        metadata.setMetadataId(currentId++);
        metadataList.add(metadata);
    }

    @Override
    public Metadata findById(Long id) {
        return metadataList.stream()
                .filter(m -> m.getMetadataId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Metadata> findAllBySurveyId(Long surveyId) {
        return metadataList.stream()
                .filter(m -> m.getSurveyId().equals(surveyId))
                .toList();
    }

    @Override
    public void update(Metadata metadata) {
        int index = metadataList.indexOf(findById(metadata.getMetadataId()));
        if (index != -1) {
            metadataList.set(index, metadata);
        }
    }

    @Override
    public void delete(Long id) {
        metadataList.removeIf(m -> m.getMetadataId().equals(id));
    }
}
