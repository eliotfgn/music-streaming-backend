package ifri.dev.musicstreamingbackend.repositories;

import ifri.dev.musicstreamingbackend.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}