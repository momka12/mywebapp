package org.itstep.myWebApp.repository.jpa;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.repository.MailRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaMailRepository implements MailRepository {
    @Override
    public List getAll(Integer userId) {
        return null;
    }

    @Override
    public Mail getById(Integer userId, Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer userId, Integer id) {
        return false;
    }

    @Override
    public Mail save(Mail mail) {
        return null;
    }
}
