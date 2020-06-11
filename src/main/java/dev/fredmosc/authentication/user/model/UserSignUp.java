package dev.fredmosc.authentication.user.model;

public class UserSignUp {

    private String name;
    private String whatsapp;
    private String cpf;
    private String email;
    private String username;
    private String password;

    public UserSignUp() {
    }

    public UserSignUp(String name, String whatsapp, String cpf, String email, String username, String password) {
        this.name = name;
        this.whatsapp = whatsapp;
        this.cpf = cpf;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
