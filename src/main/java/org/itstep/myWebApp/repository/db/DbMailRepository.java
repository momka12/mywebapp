package org.itstep.myWebApp.repository.db;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.repository.MailRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by student on 21.03.2017.
 */
@Repository
public class DbMailRepository implements MailRepository {
    @Override
    public List<Mail> getAll(Integer userId) {
        return null;
    }

    @Override
    public List<Mail> getAll() {
        return null;
    }

    @Override
    public void delete(Integer userId, Integer mailId) {

    }

    @Override
    public void save(Mail mail) {

    }

    @Override
    public Mail getOne(Integer userId, Integer id) {
        return null;
    }
}
