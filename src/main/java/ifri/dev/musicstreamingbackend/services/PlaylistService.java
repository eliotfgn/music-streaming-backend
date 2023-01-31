package ifri.dev.musicstreamingbackend.services;

import ifri.dev.musicstreamingbackend.repositories.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlaylistService {
    private PlaylistRepository playlistRepository;
}
