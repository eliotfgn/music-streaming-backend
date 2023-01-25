package ifri.dev.musicstreamingbackend.repositories;

import ifri.dev.musicstreamingbackend.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    boolean existsByNameIgnoreCase(String name);
    long deleteByNameIgnoreCase(String name);
    Optional<Tag> findByNameIgnoreCase(String name);
}