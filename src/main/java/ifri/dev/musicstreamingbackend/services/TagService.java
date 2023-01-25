package ifri.dev.musicstreamingbackend.services;

import ifri.dev.musicstreamingbackend.exceptions.RessourceNotFoundException;
import ifri.dev.musicstreamingbackend.models.Tag;
import ifri.dev.musicstreamingbackend.repositories.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TagService {
    private TagRepository tagRepository;

    public void create(String tag) {
        Tag entity = new Tag();
        if (tagRepository.existsByNameIgnoreCase(tag)) {
            return;
        }
        entity.setName(tag);
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
