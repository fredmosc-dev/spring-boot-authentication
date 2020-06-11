package dev.fredmosc.authentication.user.model;

import dev.fredmosc.authentication.credentials.model.Credentials;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String whatsapp;

    private String cpf;

    @ManyToOne
    private Credentials credentials;

    public User(UserSignUp userSignUp, Credentials credentials) {
        this.name = userSignUp.getName();
        this.whatsapp = userSignUp.getWhatsapp();
        this.cpf = userSignUp.getCpf();
        this.credentials = credentials;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
