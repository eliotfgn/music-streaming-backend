package ifri.dev.musicstreamingbackend.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Track name is required")
    private String title;
    @NotEmpty(message = "Track should have at least one artist")
    @OneToMany
    private List<Artist> artists;
    @NotNull(message = "Track should have a duration")
    private Integer duration;
    @NotNull(message = "Track should have an audio data")
    private byte[] audio;
    @OneToMany
    private List<Tag> tags;
    private String cover;
    private Integer likesCount;
}