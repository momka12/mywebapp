package org.itstep.myWebApp.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

/**
 * Created by student on 06.04.2017.
 */
@Entity
@Table(name = "securityUsers")
public class SecurityUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "password")
    @NotNull
    private String pass;

    @Column(name = "login")
    @NotNull
    private String login;

    @Column(name = "enabled")
    @NotNull
    private boolean enabled;

    @Column(name = "locked")
    @NotNull
    private boolean locked;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users", targetEntity = org.itstep.myWebApp.model.Role.class)
    private Set<Role> roles;

    @OneToOne(targetEntity = org.itstep.myWebApp.model.User.class)
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
