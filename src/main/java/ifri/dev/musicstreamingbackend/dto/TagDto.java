package ifri.dev.musicstreamingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link ifri.dev.musicstreamingbackend.models.Tag} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TagDto implements Serializable {
    private Long id;
    @NotNull(message = "Tag name is required")
    private String name;
}