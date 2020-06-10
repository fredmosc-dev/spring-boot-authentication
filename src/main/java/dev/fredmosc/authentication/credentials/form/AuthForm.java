package dev.fredmosc.authentication.credentials.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthForm {

    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(userName, password);
    }
}
