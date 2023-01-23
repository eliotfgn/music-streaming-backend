package ifri.dev.musicstreamingbackend.services;

import ifri.dev.musicstreamingbackend.dto.UserDto;
import ifri.dev.musicstreamingbackend.exceptions.UserNotFoundException;
import ifri.dev.musicstreamingbackend.mappers.UserMapper;
import ifri.dev.musicstreamingbackend.models.User;
import ifri.dev.musicstreamingbackend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean create(UserDto dto) {
        User user = UserMapper.mapToEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);

        return true;
    }

    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id "+ id + " not found"));

        return UserMapper.mapToDto(user);
    }

    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found."));

        return UserMapper.mapToDto(user);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void update(Long id, UserDto dto) {
        User user = UserMapper.mapToEntity(findById(id));
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setLastname(dto.getLastname());
        user.setFirstname(dto.getFirstname());
        user.setProfilePic(dto.getProfilePic());
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
