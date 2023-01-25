package ifri.dev.musicstreamingbackend.repositories;

import ifri.dev.musicstreamingbackend.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByNameLikeIgnoreCaseOrNameLikeIgnoreCase(String name, String name1);
}