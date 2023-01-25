package ifri.dev.musicstreamingbackend.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Album name is required")
    private String name;
    private String label;
    private Integer trackCount;
    @NotEmpty(message = "Album should have at least one track")
    @OneToMany
    private List<Track> tracks;
    @NotEmpty(message = "Album should have at least one artist")
    @OneToMany
    private List<Artist> artists;
    private String cover;
    private Integer likesCount;
    private LocalDate releaseDate;
    @OneToMany
    private Set<Tag> tags;
    private AlbumType type;
}
