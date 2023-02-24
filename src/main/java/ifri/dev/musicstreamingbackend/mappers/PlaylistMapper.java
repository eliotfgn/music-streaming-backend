package ifri.dev.musicstreamingbackend.mappers;

import ifri.dev.musicstreamingbackend.models.Playlist;
import ifri.dev.musicstreamingbackend.dto.PlaylistDto;
import ifri.dev.musicstreamingbackend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaylistMapper {
    private UserService userService;
    public Playlist mapToEntity(PlaylistDto dto) {
        return Playlist.builder()
                .id(dto.id())
                .name(dto.name())
                .description(dto.description())
                .cover(dto.cover())
                .likesCount(dto.likesCount())
                .isPrivate(dto.isPrivate())
                .user(userService.findEntityById(dto.userId()))
                .createdAt(dto.createdAt())
                .tracks(dto.tracks().stream().map(TrackMapper::mapToEntity).collect(Collectors.toList()))
                .updateAt(dto.updateAt())
                .build();
    }

    public PlaylistDto mapToDto(Playlist entity) {
        return new PlaylistDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCover(),
                entity.getLikesCount(),
                entity.getIsPrivate(),
                entity.getId(),
                entity.getTracks().stream().map(TrackMapper::mapToDto).collect(Collectors.toList()),
                entity.getCreatedAt(),
                entity.getUpdateAt()
        );
    }
}
