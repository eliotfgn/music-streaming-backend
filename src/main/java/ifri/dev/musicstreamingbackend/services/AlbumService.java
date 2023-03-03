package ifri.dev.musicstreamingbackend.services;

import ifri.dev.musicstreamingbackend.dto.AlbumDto;
import ifri.dev.musicstreamingbackend.exceptions.RessourceNotFoundException;
import ifri.dev.musicstreamingbackend.mappers.AlbumMapper;
import ifri.dev.musicstreamingbackend.models.Album;
import ifri.dev.musicstreamingbackend.models.Track;
import ifri.dev.musicstreamingbackend.repositories.AlbumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AlbumService {
    private AlbumRepository albumRepository;
    private TagService tagService;
    private TrackService trackService;

    public void create(AlbumDto payload) {
        Album album = AlbumMapper.mapToEntity(payload);
        if (payload.tags().isEmpty())
            album.setTags(new HashSet<>());
        else
            album.setTags(payload.tags().stream().map(tagService::create).collect(Collectors.toSet()));

        albumRepository.save(album);
    }

    public AlbumDto getById(Long id) {
        return AlbumMapper.mapToDto(albumRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Album with id "+id+" not found!")));
    }

    public List<AlbumDto> findAll() {
        return albumRepository.findAll()
                .stream()
                .map(AlbumMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void addTrack(Long id, Long trackId) {
        Album album = AlbumMapper.mapToEntity(getById(id));
        Track track = trackService.getTrackEntity(trackId);
        album.getTracks().add(track);
        albumRepository.save(album);
    }

    public void setCover(Long id, String cover) {
        Album album = AlbumMapper.mapToEntity(getById(id));
        album.setCover(cover);
        albumRepository.save(album);
    }

    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}
