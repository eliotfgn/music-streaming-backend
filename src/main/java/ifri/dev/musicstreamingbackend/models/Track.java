package ifri.dev.musicstreamingbackend.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

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
    @NotBlank(message = "Track should have an audio data")
    private String audio;
    @OneToMany
    private Set<Tag> tags;
    private String cover;
    private Integer likesCount;
}