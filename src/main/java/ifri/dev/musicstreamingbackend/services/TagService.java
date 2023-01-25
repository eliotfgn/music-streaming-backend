package ifri.dev.musicstreamingbackend.services;

import ifri.dev.musicstreamingbackend.exceptions.RessourceNotFoundException;
import ifri.dev.musicstreamingbackend.models.Tag;
import ifri.dev.musicstreamingbackend.repositories.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TagService {
    private TagRepository tagRepository;

    public Tag create(String tag) {
        Tag entity = new Tag();
        Optional<Tag> optionalTag = findEntityByName(tag);
        if (optionalTag.isPresent()) {
            return optionalTag.get();
        }
        entity.setName(tag);
        return tagRepository.save(entity);
    }

    public Optional<Tag> findEntityByName(String name) {
        return tagRepository.findByNameIgnoreCase(name);
    }

    public String findByName(String name) {
        return tagRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RessourceNotFoundException("This tag is not saved."))
                .getName();
    }

    public void delete(String name) {
        tagRepository.deleteByNameIgnoreCase(name);
    }
}
