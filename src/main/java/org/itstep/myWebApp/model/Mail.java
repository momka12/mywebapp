package org.itstep.myWebApp.model;

import java.time.LocalDateTime;

public class Mail extends Entity {

    private String text;

    private String to; // email

    private LocalDateTime created;

    private User user; // owner

    public Mail() {
    }

    public Mail(Integer id, String name, String text, String to, LocalDateTime created, User user) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.to = to;
        this.created = created;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
