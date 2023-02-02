package ifri.dev.musicstreamingbackend.services;

import ifri.dev.musicstreamingbackend.dto.PlaylistDto;
import ifri.dev.musicstreamingbackend.dto.TrackDto;
import ifri.dev.musicstreamingbackend.exceptions.RessourceNotFoundException;
import ifri.dev.musicstreamingbackend.mappers.PlaylistMapper;
import ifri.dev.musicstreamingbackend.models.Playlist;
import ifri.dev.musicstreamingbackend.models.Track;
import ifri.dev.musicstreamingbackend.repositories.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaylistService {
    private PlaylistRepository playlistRepository;
    private TrackService trackService;

    public void create(PlaylistDto payload) {
        LocalDate currentDate = LocalDate.now();
        Playlist playlist = PlaylistMapper.mapToEntity(payload);
        playlist.setCreatedAt(currentDate);
        playlist.setUpdateAt(currentDate);
        playlist.setTracks(new ArrayList<>());
        playlist.setLikesCount(0);

        playlistRepository.save(playlist);
    }

    public PlaylistDto findById(Long id) {
        Playlist playlist = findEntityById(id);
        return PlaylistMapper.mapToDto(playlist);
    }

    public Playlist findEntityById(Long id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Playlist with id "+ id +" not found."));
    }

    public List<PlaylistDto> findAll() {
        return playlistRepository.findAll()
                .stream().map(PlaylistMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void addTrack(Long playlistId, Long trackId) {
        Playlist playlist = findEntityById(playlistId);
        Track track = trackService.getTrackEntity(trackId);
        playlist.getTracks().add(track);

        playlistRepository.save(playlist);
    }

    public void update(Long id, PlaylistDto payload) {
        Playlist playlist = findEntityById(id);
        playlist.setCover(payload.cover());
        playlist.setDescription(payload.description());
        playlist.setName(payload.name());
    }

    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }
}
