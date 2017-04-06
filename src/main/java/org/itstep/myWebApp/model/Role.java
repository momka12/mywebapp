package org.itstep.myWebApp.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority{

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = org.itstep.myWebApp.model.SecurityUser.class)
    private Set<SecurityUser> users;

    @Override
    public String getAuthority() {
        return name;
    }
}
