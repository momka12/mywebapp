package org.itstep.myWebApp.repository.orm;


import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.hibernate.engine.spi.ManagedEntity;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrmUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List getAll() {
        return manager.createQuery("SELECT us from User us", User.class).getResultList();
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        User reference = manager.getReference(User.class, id);
        if (reference == null)
            return false;

        manager.remove(reference);
        return true;
    }

    @Override
    @Transactional
    public User save(User user) {

        if (user.getId() == null)
            manager.persist(user);
        else
            manager.merge(user);

        return user;
    }

    @Override
    public User getById(Integer id) {
        try {
            return manager.find(User.class, id);
        } catch (Exception ex) {
        return null;
    }
    }
}
