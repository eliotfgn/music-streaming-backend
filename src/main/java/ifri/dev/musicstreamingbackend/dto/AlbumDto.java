package ifri.dev.musicstreamingbackend.dto;

import ifri.dev.musicstreamingbackend.models.AlbumType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link ifri.dev.musicstreamingbackend.models.Album} entity
 */
public record AlbumDto(Long id,
                       @NotBlank(message = "Album name is required") String name,
                       String label,
                       Integer trackCount,
                       @NotEmpty(message = "Album should have at least one track") List<TrackDto> tracks,
                       @NotEmpty(message = "Album should have at least one artist") List<ArtistDto> artists,
                       String cover,
                       Integer likesCount,
                       LocalDate releaseDate,
                       AlbumType type,
                       List<String> tags) implements Serializable {
}