package dev.fredmosc.authentication.user.service;

import dev.fredmosc.authentication.credentials.model.Credentials;
import dev.fredmosc.authentication.credentials.repository.CredentialsRepository;
import dev.fredmosc.authentication.user.model.User;
import dev.fredmosc.authentication.user.model.UserSignUp;
import dev.fredmosc.authentication.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CredentialsRepository credentialsRepository;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, CredentialsRepository credentialsRepository) {
        this.userRepository = userRepository;
        this.credentialsRepository = credentialsRepository;
    }

    public User create(UserSignUp userSignUp) {
        Credentials credentials = new Credentials(userSignUp);
        User user = new User(userSignUp, credentials);
        return user;
    }
}
