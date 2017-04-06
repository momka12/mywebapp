package org.itstep.myWebApp.service;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.itstep.myWebApp.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "service")
public class UserService {

    @Autowired
    private UserRepository repository;

    @Cacheable(value = "users")
    public List<User> getAll() {
        return repository.getAll();
    }

    @CacheEvict(allEntries = true, value = "users")
    public void delete(Integer id) {
        ExceptionUtil.check(repository.getById(id), id);
        repository.delete(id);
    }

    @CacheEvict(allEntries = true, value = "users")
    public User save(User user) {
        return repository.save(user);
    }

    @CacheEvict(allEntries = true, value = "users")
    public void update(User user) {
        ExceptionUtil.check(repository.getById(user.getId()), user.getId());
        repository.save(user);
    }

    @Cacheable(value = "users")
    public User getById(Integer id) {
        return ExceptionUtil.check(repository.getById(id), id);
    }

    @CacheEvict(allEntries = true, value = "users")
    public void evictCache() {}

}
