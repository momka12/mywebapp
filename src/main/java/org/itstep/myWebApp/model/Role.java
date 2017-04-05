package org.itstep.myWebApp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = org.itstep.myWebApp.model.User.class)
    private Set<User> users;
}
