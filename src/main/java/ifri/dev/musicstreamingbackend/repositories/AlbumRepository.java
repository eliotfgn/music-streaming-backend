package ifri.dev.musicstreamingbackend.repositories;

import ifri.dev.musicstreamingbackend.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}