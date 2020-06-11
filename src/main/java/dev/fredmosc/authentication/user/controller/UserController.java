package dev.fredmosc.authentication.user.controller;

import dev.fredmosc.authentication.user.model.User;
import dev.fredmosc.authentication.user.model.UserSignUp;
import dev.fredmosc.authentication.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Validated UserSignUp userSignUp) {
        logger.info("[USER] {}", userSignUp.getEmail());
        User user = userService.create(userSignUp);
        return ResponseEntity.ok(user);
    }
}
