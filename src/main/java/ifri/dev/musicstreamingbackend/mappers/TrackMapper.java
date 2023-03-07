package ifri.dev.musicstreamingbackend.mappers;

import ifri.dev.musicstreamingbackend.dto.TrackDto;
import ifri.dev.musicstreamingbackend.models.Tag;
import ifri.dev.musicstreamingbackend.models.Track;
import ifri.dev.musicstreamingbackend.services.ArtistService;

import java.util.stream.Collectors;

public class TrackMapper {
    public static TrackDto mapToDto(Track track) {
        return TrackDto.builder()
                .id(track.getId())
                .title(track.getTitle())
                .tags(track.getTags().stream().map(Tag::getName).collect(Collectors.toList()))
                .cover(track.getCover())
                .audio(track.getAudio())
                .likesCount(track.getLikesCount())
                .duration(track.getDuration())
                .artists(track.getArtists().stream().map(artist -> ArtistMapper.mapToDto(artist)).collect(Collectors.toList()))
                .build();
    }

    public static Track mapToEntity(TrackDto track) {
        return Track.builder()
                .id(track.getId())
                .title(track.getTitle())
                .cover(track.getCover())
                .audio(track.getAudio())
                .likesCount(track.getLikesCount())
                .duration(track.getDuration())
                .build();

    }
}
