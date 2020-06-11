package dev.fredmosc.authentication.user.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;

public class UserSignUp {

    @NotEmpty
    @NotBlank
    @NotNull
    private String name;

    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "Formato Inválido")
    private String whatsapp;

    @CPF(message = "CPF Inválido")
    private String cpf;

    @Email(message = "Email inválido")
    private String email;

    @Size(min = 6, message = "Username tem que ter pelo menos 6 caracteres")
    private String username;

    @Size(min = 8, message = "Senha tem que ter pelo menos 8 caracteres")
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
