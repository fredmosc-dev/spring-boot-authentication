package dev.fredmosc.authentication.user.service;

import dev.fredmosc.authentication.credentials.model.Credentials;
import dev.fredmosc.authentication.credentials.repository.CredentialsRepository;
import dev.fredmosc.authentication.user.model.User;
import dev.fredmosc.authentication.user.model.UserDto;
import dev.fredmosc.authentication.user.model.UserSignUp;
import dev.fredmosc.authentication.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CredentialsRepository credentialsRepository;
    private final PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, CredentialsRepository credentialsRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.credentialsRepository = credentialsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDto create(UserSignUp userSignUp) {
        Optional<Credentials> existCredentials = credentialsRepository.findByUsername(userSignUp.getUsername());
        if (existCredentials.isPresent()) {
            throw new BadCredentialsException("Username already exists");
        }

        Optional<User> existUser = userRepository.findByCpf(userSignUp.getCpf());
        if (existUser.isPresent()) {
            throw new BadCredentialsException("CPF already exists");
        }

        Credentials credentials = new Credentials(userSignUp);
        credentials.setPassword(passwordEncoder.encode(userSignUp.getPassword()));
        User user = new User(userSignUp, credentials);

        credentialsRepository.save(credentials);
        User savedUser = userRepository.save(user);
        UserDto userDto = new UserDto(savedUser);
        return userDto;
    }

    public List<UserDto> findAll() {
        List<User> allUsers = userRepository.findAll();
        List<UserDto> users = new ArrayList<>();
        allUsers.stream().forEach(user -> {
            UserDto userDto = new UserDto(user);
            users.add(userDto);
        });
        return users;
    }
}
