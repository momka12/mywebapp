package org.itstep.myWebApp.repository.datajpa;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    @Autowired
    private ProxyRepoUser data;

    private static Logger logger = LoggerFactory.getLogger(DataJpaUserRepository.class);

    @Override
    public List getAll() {
        logger.debug(String.valueOf(data.findAll()));
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
