package ifri.dev.musicstreamingbackend.dto;

import ifri.dev.musicstreamingbackend.dto.TrackDto;
import ifri.dev.musicstreamingbackend.dto.UserDto;
import ifri.dev.musicstreamingbackend.models.Playlist;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link Playlist} entity
 */
public record PlaylistDto(Long id,
                          @NotBlank(message = "Playlist name is required") String name,
                          String description,
                          String cover,
                          Integer likesCount,
                          Boolean isPrivate,
                          UserDto user,
                          List<TrackDto> tracks,
                          LocalDate createdAt,
                          LocalDate updateAt) implements Serializable {
}