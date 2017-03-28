package org.itstep.myWebApp.repository.datajpa;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    @Autowired
    private ProxyRepo data;

    @Override
    public List getAll() {
        return data.findAll();
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        return data.deleteById(id) != 0;
    }

    @Override
    public User save(User user) {
        return data.save(user);
    }

    @Override
    public User getById(Integer id) {
        return data.findOne(id);
    }
}
