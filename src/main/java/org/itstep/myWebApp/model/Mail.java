package org.itstep.myWebApp.model;

import java.time.LocalDateTime;

public class Mail extends Entity {

    private String text;

    private String to; // email

    private LocalDateTime created;

    private Integer userId; // owner

    public Mail() {
    }

    public Mail(Integer id, String name, String text, String to, LocalDateTime created, Integer userId) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.to = to;
        this.created = created;
        this.userId = userId;
    }

<<<<<<< 2a038c292baa434bfde90231d0c0d14ed1dc9527
    public Mail(String name, String text, String to, LocalDateTime created, Integer userId) {
        this.name = name;
        this.text = text;
        this.to = to;
        this.created = created;
        this.userId = userId;
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

=======
>>>>>>> 9 patches
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

    public Integer getUserId() {
        return userId;
    }

<<<<<<< 2a038c292baa434bfde90231d0c0d14ed1dc9527
    public void setUser(Integer userId) {
        this.userId = userId;
    }
}
=======
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "text='" + text + '\'' +
                ", to='" + to + '\'' +
                ", created=" + created +
                ", userId=" + userId +
                "}";
    }
}
>>>>>>> 9 patches
