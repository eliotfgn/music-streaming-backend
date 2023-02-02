package ifri.dev.musicstreamingbackend.mappers;

import ifri.dev.musicstreamingbackend.models.Playlist;
import ifri.dev.musicstreamingbackend.dto.PlaylistDto;
import ifri.dev.musicstreamingbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PlaylistMapper {
    @Autowired
    private static UserService userService;
    public static Playlist mapToEntity(PlaylistDto dto) {
        return Playlist.builder()
                .id(dto.id())
                .name(dto.name())
                .description(dto.description())
                .cover(dto.cover())
                .likesCount(dto.likesCount())
                .isPrivate(dto.isPrivate())
                .user(userService.findEntityById(dto.id()))
                .createdAt(dto.createdAt())
                .tracks(dto.tracks().stream().map(TrackMapper::mapToEntity).collect(Collectors.toList()))
                .updateAt(dto.updateAt())
                .build();
    }

    public static PlaylistDto mapToDto(Playlist entity) {
        return new PlaylistDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCover(),
                entity.getLikesCount(),
                entity.getIsPrivate(),
                UserMapper.mapToDto(entity.getUser()),
                entity.getTracks().stream().map(TrackMapper::mapToDto).collect(Collectors.toList()),
                entity.getCreatedAt(),
                entity.getUpdateAt()
        );
    }
}
