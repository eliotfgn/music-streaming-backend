package ifri.dev.musicstreamingbackend.services;

import ifri.dev.musicstreamingbackend.dto.ArtistDto;
import ifri.dev.musicstreamingbackend.exceptions.RessourceNotFoundException;
import ifri.dev.musicstreamingbackend.mappers.ArtistMapper;
import ifri.dev.musicstreamingbackend.models.Artist;
import ifri.dev.musicstreamingbackend.repositories.ArtistRepository;
import ifri.dev.musicstreamingbackend.repositories.TrackRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ArtistService {
    private ArtistRepository artistRepository;

    public void create(ArtistDto payload) {
        Artist artist = ArtistMapper.mapToEntity(payload);
        artist.setAlbums(new ArrayList<>());
        artist.setFollowersCount(0);

        artistRepository.save(artist);
    }

    public ArtistDto getArtist(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Artist with id "+id+" has not be found."));
        return ArtistMapper.mapToDto(artist);
    }

    public List<ArtistDto> findAll() {
        return artistRepository.findAll()
                .stream()
                .map(ArtistMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<ArtistDto> findAllByName(String name) {
        return artistRepository.findByNameLikeIgnoreCaseOrNameLikeIgnoreCase(name, name)
                .stream()
                .map(ArtistMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        artistRepository.deleteById(id);
    }
}
