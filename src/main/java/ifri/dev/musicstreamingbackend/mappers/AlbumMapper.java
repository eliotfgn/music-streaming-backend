package ifri.dev.musicstreamingbackend.mappers;

import ifri.dev.musicstreamingbackend.dto.AlbumDto;
import ifri.dev.musicstreamingbackend.models.Album;
import ifri.dev.musicstreamingbackend.models.Tag;

import java.util.stream.Collectors;

public class AlbumMapper {
    public static AlbumDto mapToDto(Album entity) {
        return new AlbumDto(
                entity.getId(),
                entity.getName(),
                entity.getLabel(),
                entity.getTrackCount(),
                entity.getTracks().stream().map(TrackMapper::mapToDto).collect(Collectors.toList()),
                entity.getArtists().stream().map(ArtistMapper::mapToDto).collect(Collectors.toList()),
                entity.getCover(),
                entity.getLikesCount(),
                entity.getReleaseDate(),
                entity.getType(),
                entity.getTags().stream().map(Tag::getName).collect(Collectors.toList())
        );
    }

    public static Album mapToEntity(AlbumDto dto) {
        return Album.builder()
                .id(dto.id())
                .name(dto.name())
                .label(dto.label())
                .cover(dto.cover())
                .trackCount(dto.trackCount())
                .likesCount(dto.likesCount())
                .releaseDate(dto.releaseDate())
                .type(dto.type())
                .artists(dto.artists().stream().map(ArtistMapper::mapToEntity).collect(Collectors.toList()))
                .tracks(dto.tracks().stream().map(TrackMapper::mapToEntity).collect(Collectors.toList()))
                .build();
    }
}
