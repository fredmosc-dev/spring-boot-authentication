package dev.fredmosc.authentication.user.model;

public class UserDto {

    private Long id;
    private String name;
    private String whatsapp;
    private String email;
    private String username;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.whatsapp = user.getWhatsapp();
        this.email = user.getCredentials().getEmail();
        this.username = user.getCredentials().getUsername();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
