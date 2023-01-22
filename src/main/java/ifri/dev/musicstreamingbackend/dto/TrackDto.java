package ifri.dev.musicstreamingbackend.dto;

import ifri.dev.musicstreamingbackend.dto.TagDto;
import ifri.dev.musicstreamingbackend.models.Track;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Track} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrackDto implements Serializable {
    private Long id;
    @NotBlank(message = "Track name is required")
    private String title;
    @NotNull(message = "Track should have a duration")
    private Integer duration;
    @NotBlank(message = "Track should have an audio data")
    private String audio;
    private List<TagDto> tags;
    private String cover;
    private Integer likesCount;
}