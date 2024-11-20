package br.com.projetaria.domain.user;

import java.time.LocalDateTime;

public class User {

    private String id;

    private String name;

    private LocalDateTime createdAt;

    public User(
            final String id,
            final String name,
            final LocalDateTime createdAt) {

        this.id = id;
        this.createdAt = createdAt;

        this.defineName(name);

        this.validate();
    }

    public void validate() {
        if (this.name == null) {
            throw new RuntimeException("The user name is required");
        }
    }

    public void defineName(final String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
}
