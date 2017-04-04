package org.itstep.myWebApp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "mails")
@Entity
public class Mail extends BaseEntity {

    private String text;

    @Column(name = "toto")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Mail mail = (Mail) o;

        if (text != null ? !text.equals(mail.text) : mail.text != null) return false;
        if (to != null ? !to.equals(mail.to) : mail.to != null) return false;
        if (created != null ? !created.equals(mail.created) : mail.created != null) return false;
        return userId.equals(mail.userId);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + userId.hashCode();
        return result;
    }
}
