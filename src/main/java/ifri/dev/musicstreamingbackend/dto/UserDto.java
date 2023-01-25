package ifri.dev.musicstreamingbackend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A DTO for the {@link ifri.dev.musicstreamingbackend.models.User} entity
 */
public record UserDto(Long id,
                      String email,
                      String username,
                      String firstname,
                      String lastname,
                      String profilePic) implements Serializable {
}