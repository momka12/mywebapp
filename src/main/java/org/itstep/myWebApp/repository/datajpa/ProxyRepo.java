package org.itstep.myWebApp.repository.datajpa;

import org.itstep.myWebApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by student on 27.03.2017.
 */
public interface ProxyRepo extends JpaRepository<User, Integer> {

    int deleteById(Integer integer);
}
