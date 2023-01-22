package ifri.dev.musicstreamingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link ifri.dev.musicstreamingbackend.models.User} entity
 */
@AllArgsConstructor
@Getter
@Setter
public class UserDto implements Serializable {
    private Long id;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;
    private String firstname;
    private String lastname;
    private String profilePic;
}