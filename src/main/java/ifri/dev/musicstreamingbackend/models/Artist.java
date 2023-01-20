package ifri.dev.musicstreamingbackend.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Artist should have a name")
    @NotEmpty(message = "Artist name should not be empty")
    private String name;
    private String bio;
    private String profilePic;
    private Integer followersCount;
    @OneToMany
    private List<Album> albums;
}
