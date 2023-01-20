package ifri.dev.musicstreamingbackend.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Playlist name is required")
    private String name;
    private String description;
    private String cover;
    private Integer likesCount;
    @Column(columnDefinition = "boolean default true")
    private Boolean isPrivate;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Track> tracks;
    private LocalDate createdAt;
    private LocalDate updateAt;
}
