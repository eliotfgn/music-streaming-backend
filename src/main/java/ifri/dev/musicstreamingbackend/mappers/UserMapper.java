package ifri.dev.musicstreamingbackend.mappers;

import ifri.dev.musicstreamingbackend.dto.UserDto;
import ifri.dev.musicstreamingbackend.models.User;

public class UserMapper {
    public static UserDto mapToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .profilePic(user.getProfilePic())
                .build();
    }

    public static User mapToEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .profilePic(userDto.getProfilePic())
                .build();
    }
}
