package ifri.dev.musicstreamingbackend.mappers;

import ifri.dev.musicstreamingbackend.dto.UserDto;
import ifri.dev.musicstreamingbackend.dto.UserRequest;
import ifri.dev.musicstreamingbackend.models.User;

public class UserMapper {
    public static UserDto mapToDto(User user) {
        return new  UserDto(user.getId() ,user.getUsername() ,user.getEmail(), user.getFirstname(),user.getLastname() ,user.getProfilePic());
    }

    public static User mapToEntity(UserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .profilePic(userRequest.getProfilePic())
                .build();
    }
}
