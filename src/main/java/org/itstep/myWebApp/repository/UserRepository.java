package org.itstep.myWebApp.repository;

import org.itstep.myWebApp.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by student on 21.03.2017.
 */
public interface UserRepository {

    List<User> getAll();

    boolean delete(Integer id);

    User save(User user);

    User getById(Integer id);

}
