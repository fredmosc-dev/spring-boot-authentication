package dev.fredmosc.authentication.security.jwtutils;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException {
    public JwtTokenMissingException(String s) {
        super(s);
    }
}
