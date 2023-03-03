package ifri.dev.musicstreamingbackend.services;

import ifri.dev.musicstreamingbackend.dto.TrackDto;
import ifri.dev.musicstreamingbackend.exceptions.RessourceNotFoundException;
import ifri.dev.musicstreamingbackend.mappers.ArtistMapper;
import ifri.dev.musicstreamingbackend.mappers.TrackMapper;
import ifri.dev.musicstreamingbackend.models.Tag;
import ifri.dev.musicstreamingbackend.models.Track;
import ifri.dev.musicstreamingbackend.repositories.TrackRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TrackService {
    private TrackRepository trackRepository;
    private TagService tagService;
    private ArtistService artistService;

    public void create(TrackDto payload) {
        Track entity = TrackMapper.mapToEntity(payload);
        if (payload.getTags().isEmpty())
            entity.setTags(new HashSet<>());
        else
            entity.setTags(payload.getTags().stream().map(tagService::create).collect(Collectors.toSet()));
        entity.setArtists(
                payload.getArtists()
                        .stream()
                        .map((artistId) -> artistService.getArtistEntity(artistId))
                        .collect(Collectors.toList()));

        trackRepository.save(entity);
    }

    public TrackDto getTrack(Long id) {
        Track entity = trackRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Track with id "+" not found!"));
        return TrackMapper.mapToDto(entity);
    }

    public Track getTrackEntity(Long id) {
        return trackRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Track with id "+" not found!"));
    }

    public void setCover(Long id, String cover) {
        Track entity = getTrackEntity(id);
        entity.setCover(cover);
        trackRepository.save(entity);
    }

    public List<TrackDto> getAll() {
        return trackRepository.findAll()
                .stream()
                .map(TrackMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        trackRepository.deleteById(id);
    }

    public void addTagsToTrack(Long id, List<String> tags) {
        Track track = getTrackEntity(id);
        tags.forEach((tag) -> {
            Tag newTag = tagService.create(tag);
            track.getTags().add(newTag);
        });
        trackRepository.save(track);
    }
}
