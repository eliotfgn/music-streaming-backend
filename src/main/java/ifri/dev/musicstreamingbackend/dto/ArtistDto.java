package ifri.dev.musicstreamingbackend.dto;

import ifri.dev.musicstreamingbackend.models.Artist;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link Artist} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArtistDto implements Serializable {
    private Long id;
    @NotNull(message = "Artist should have a name")
    @NotEmpty(message = "Artist name should not be empty")
    private String name;
    private String bio;
    private String profilePic;
    private Integer followersCount;
}