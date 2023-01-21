package ifri.dev.musicstreamingbackend.repositories;

import ifri.dev.musicstreamingbackend.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}